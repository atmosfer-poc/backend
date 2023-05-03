package com.atmosferpoc.productservice.service.impl;

import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.entity.FileInfo;
import com.atmosferpoc.entity.Product;
import com.atmosferpoc.productservice.repository.ProductRepository;
import com.atmosferpoc.productservice.repository.specifications.ProductSpecifications;
import com.atmosferpoc.productservice.service.FileService;
import com.atmosferpoc.productservice.service.ProductService;
import com.atmosferpoc.shared.model.dto.ProductGetParamsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl extends AbstractEntityService<Product, Long> implements ProductService {
    private final ProductRepository productRepository;
    private final FileService fileService;

    @Override
    public Product saveProduct(MultipartFile file, Product entity) {
        FileInfo upload = fileService.upload(file);
        entity.setImage(upload.getBucketName());
        return save(entity);
    }

    @Override
    public List<Product> getProducts(ProductGetParamsDto dto) {
        return productRepository.findAll(ProductSpecifications
                .prepareSpecifications(dto));
    }

    @Override
    public List<Product> getProductsPagination(int page, int size, String sort, String direction, boolean isExistAudit) {
        Pageable pageable = PageRequest.of(page, size);
        if (StringUtils.isNotBlank(sort)) {
            pageable = PageRequest.of(page, size, Sort.Direction.valueOf(direction), sort);
        }
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.toList();
    }


    @Override
    public BaseJpaRepository<Product, Long> getJpaRepository() {
        return productRepository;
    }
}
