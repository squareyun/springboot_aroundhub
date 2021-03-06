package studio.square.testproject.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studio.square.testproject.common.Constants;
import studio.square.testproject.common.exception.AroundHubException;
import studio.square.testproject.data.dto.ProductDto;
import studio.square.testproject.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform {} of Around Hub API.", "getProduct");

        ProductDto productDto = productService.getProduct(productId);

        LOGGER.info(
            "[ProductController] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
            productDto.getProductId(),
            productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(),
            (System.currentTimeMillis() - startTime));

        return productDto;
    }

    @PostMapping(value = "/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService.saveProduct(productId, productName, productPrice,
            productStock);

        LOGGER.info(
            "[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
            response.getProductId(),
            response.getProductName(), response.getProductPrice(), response.getProductStock());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PostMapping(value = "/product/exception")
    public void exceptionTest() throws AroundHubException {
        throw new AroundHubException(Constants.ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN,
            "????????? ?????????????????????.");
    }
}
