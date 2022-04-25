package studio.square.testproject.data.service.impl;

import org.springframework.stereotype.Service;
import studio.square.testproject.data.dto.ProductDto;
import studio.square.testproject.data.entity.ProductEntity;
import studio.square.testproject.data.handler.ProductDataHandler;
import studio.square.testproject.data.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler;

    ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }
}
