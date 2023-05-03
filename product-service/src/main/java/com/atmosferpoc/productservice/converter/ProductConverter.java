package com.atmosferpoc.productservice.converter;

import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.entity.Product;
import com.atmosferpoc.shared.model.dto.ProductDto;
import com.atmosferpoc.shared.model.resource.ProductResource;
import com.atmosferpoc.shared.util.IOHelper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Component
public class ProductConverter implements BaseConverter<ProductDto, Product, ProductResource> {
    @SneakyThrows
    @Override
    public ProductResource toResource(Product entity) {
        var resource = new ProductResource();
        resource.setDescription(entity.getDescription());
        resource.setName(entity.getName());
        resource.setPrice(entity.getPrice());
        byte[] bytes = IOHelper.readAsBase64(entity.getImage());

        resource.setImage(Base64.getEncoder().encodeToString(bytes));

        return resource;
    }

    public ProductResource toGetResource(List<Product> resources) throws IOException {
        var resource = new ProductResource();
        var entity = resources.get(0);
        resource.setDescription(entity.getDescription());
        resource.setName(entity.getName());
        resource.setPrice(entity.getPrice());

        byte[] bytes = IOHelper.readAsBase64(entity.getImage());

        resource.setImage(Base64.getEncoder().encodeToString(bytes));

        return resource;
    }

    @Override
    public Product toEntity(ProductDto dto) {
        var product = new Product();
        product.setDescription(dto.getDescription());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        return product;
    }
}
