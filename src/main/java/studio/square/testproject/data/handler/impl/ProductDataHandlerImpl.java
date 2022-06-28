package studio.square.testproject.data.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studio.square.testproject.data.dao.ProductDAO;
import studio.square.testproject.data.entity.ProductEntity;
import studio.square.testproject.data.handler.ProductDataHandler;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

    ProductDAO productDAO;

    @Autowired
    ProductDataHandlerImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice,
        int productStock) {

        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice,
            productStock);

        return productDAO.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String prodcutId) {
        return productDAO.getProduct(prodcutId);
    }
}
