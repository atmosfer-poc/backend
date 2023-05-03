package com.atmosferpoc.productservice.repository;

import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends BaseJpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {
}
