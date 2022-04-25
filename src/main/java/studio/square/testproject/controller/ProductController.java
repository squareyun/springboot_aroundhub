package studio.square.testproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studio.square.testproject.data.dto.ProductDto;
import studio.square.testproject.data.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value="/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId){
        return productService.getProduct(productId);
    }

    @PostMapping(value="/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }
}
