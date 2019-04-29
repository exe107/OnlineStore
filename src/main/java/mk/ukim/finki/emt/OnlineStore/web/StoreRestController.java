package mk.ukim.finki.emt.OnlineStore.web;

import mk.ukim.finki.emt.OnlineStore.model.Category;
import mk.ukim.finki.emt.OnlineStore.model.Manufacturer;
import mk.ukim.finki.emt.OnlineStore.model.Product;
import mk.ukim.finki.emt.OnlineStore.service.CategoryService;
import mk.ukim.finki.emt.OnlineStore.service.ManufacturerService;
import mk.ukim.finki.emt.OnlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class StoreRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping("/products")
    private List<Product> getProducts() {

        return productService.getProducts();
    }

    @GetMapping("products/{id}")
    private Product getProduct(@PathVariable Long id) {

        return productService.getProduct(id);
    }

    @GetMapping("product/category/{categoryId}")
    private List<Product> getProductsByCategory(@PathVariable Long categoryId) {

        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/product/category/{categoryId}/manufacturer/{manufacturerId}")
    private List<Product> getProductsByCategoryAndManufacturer(@PathVariable Long categoryId, @PathVariable Long manufacturerId) {

        return productService.getProductsByCategoryAndManufacturer(categoryId, manufacturerId);
    }

    @GetMapping("/product/category/{categoryId}/price")
    private Long getProductsTotalSumByCategory(@PathVariable Long categoryId) {

        return productService.getProductsTotalSumByCategory(categoryId);
    }

    @PostMapping("/products")
    private void saveProduct(@RequestBody Product product) {

        productService.saveProduct(product);
    }

    @PostMapping("/categories")
    private void saveCategory(@RequestBody Category category) {

        categoryService.saveCategory(category);
    }

    @PostMapping("/manufacturers")
    private void saveManufacturer(@RequestBody Manufacturer manufacturer) {

        manufacturerService.saveManufacturer(manufacturer);
    }

}
