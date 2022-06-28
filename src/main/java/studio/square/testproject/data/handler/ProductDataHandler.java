package studio.square.testproject.data.handler;

import studio.square.testproject.data.entity.ProductEntity;

public interface ProductDataHandler {

    ProductEntity saveProductEntity(String productId, String productName, int productPrice,
        int productStock);

    ProductEntity getProductEntity(String prodcutId);
}
