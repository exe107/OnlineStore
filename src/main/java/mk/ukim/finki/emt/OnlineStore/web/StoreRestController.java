package mk.ukim.finki.emt.OnlineStore.web;

import mk.ukim.finki.emt.OnlineStore.model.*;
import mk.ukim.finki.emt.OnlineStore.service.*;
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

    @Autowired
    private AccessoryService accessoryService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/products")
    private List<Product> getProducts() {

        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    private Product getProduct(@PathVariable Long id) {

        return productService.getProduct(id);
    }

    @GetMapping("/product/category/{categoryId}")
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

    @GetMapping("/categories")
    private List<Category> getCategories() {

        return categoryService.getCategories();
    }

    @PostMapping("/categories")
    private void saveCategory(@RequestBody Category category) {

        categoryService.saveCategory(category);
    }

    @GetMapping("/manufacturers")
    private List<Manufacturer> getManufacturers() {

        return manufacturerService.getManufacturers();
    }

    @PostMapping("/manufacturers")
    private void saveManufacturer(@RequestBody Manufacturer manufacturer) {

        manufacturerService.saveManufacturer(manufacturer);
    }

    @GetMapping("/accessories")
    private List<Accessory> getAccessories() {

        return accessoryService.getAccessories();
    }

    @PostMapping("/accessories")
    private void saveAccessory(@RequestBody Accessory accessory) {

        accessoryService.saveAccessory(accessory);
    }

    @GetMapping("/transactions")
    private List<Transaction> getTransactions() {

        return transactionService.getTransactions();
    }
}
