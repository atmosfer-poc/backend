package com.atmosferpoc.productservice.controller;

import com.atmosferpoc.core.controller.AbstractEntityController;
import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.Product;
import com.atmosferpoc.productservice.converter.ProductConverter;
import com.atmosferpoc.productservice.service.ProductService;
import com.atmosferpoc.shared.endpoints.ProductEndpoints;
import com.atmosferpoc.shared.model.dto.ProductDto;
import com.atmosferpoc.shared.model.dto.ProductGetParamsDto;
import com.atmosferpoc.shared.model.resource.ProductResource;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(ProductEndpoints.PRODUCT)
@RequiredArgsConstructor
public class ProductController extends AbstractEntityController<ProductDto, Product, ProductResource, Long> {
    private final ProductService productService;
    private final ProductConverter productConverter;

    @Override
    public ProductResource save(ProductDto dto) {
        var entity = productService.saveProduct(dto.getImage(), toEntity(dto));
        return toResource(entity);
    }

    @GetMapping
    @Cacheable("productCache")
    public ProductResource getProduct(ProductGetParamsDto dto) throws IOException {
        var resources = productService.getProducts(dto);

        if (!CollectionUtils.isEmpty(resources)) {
            return productConverter.toGetResource(resources);
        } else {
            throw new GeneralException(ErrorStatusCode.PRODUCT_NOT_FOUND);
        }
    }

    @GetMapping(ProductEndpoints.PAGEABLE)
    public List<ProductResource> getProductsPagination(@RequestParam(value = "page", defaultValue = "0") int page,
                                                       @RequestParam(value = "size", defaultValue = "20") int size,
                                                       @RequestParam(name = "sort", required = false) String sort,
                                                       @RequestParam(name = "direction", required = false, defaultValue = "ASC") String direction,
                                                       @RequestParam(value = "audit", defaultValue = "false") boolean isExistAudit) {
        var resources = productService.getProductsPagination(page, size, sort, direction, isExistAudit);
        return toResource(resources);
    }


    @Override
    protected BaseEntityService<Product, Long> getService() {
        return productService;
    }

    @Override
    protected BaseConverter<ProductDto, Product, ProductResource> getConverter() {
        return productConverter;
    }
}
