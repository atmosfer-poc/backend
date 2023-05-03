package com.atmosferpoc.productservice.service;

import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.Product;
import com.atmosferpoc.shared.model.dto.ProductGetParamsDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService extends BaseEntityService<Product, Long> {
    Product saveProduct(MultipartFile file, Product entity);

    List<Product> getProducts(ProductGetParamsDto dto);

    List<Product> getProductsPagination(int page, int size, String sort, String direction, boolean isExistAudit);
}
