package mk.ukim.finki.emt.OnlineStore.web;

import mk.ukim.finki.emt.OnlineStore.model.Accessory;
import mk.ukim.finki.emt.OnlineStore.model.Category;
import mk.ukim.finki.emt.OnlineStore.model.Manufacturer;
import mk.ukim.finki.emt.OnlineStore.model.Product;
import mk.ukim.finki.emt.OnlineStore.service.AccessoryService;
import mk.ukim.finki.emt.OnlineStore.service.CategoryService;
import mk.ukim.finki.emt.OnlineStore.service.ManufacturerService;
import mk.ukim.finki.emt.OnlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class StoreController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private AccessoryService accessoryService;

    @GetMapping
    private String showProducts(Model model) {

        List<Product> products = productService.getProducts();

        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/{productId}")
    private String showProduct(@PathVariable Long productId, Model model) {

        Product product = productService.getProduct(productId);
        model.addAttribute("product", product);

        return "product";
    }

    @GetMapping("/add")
    private String createProduct(Model model) {

        List<Category> categories = categoryService.getCategories();
        List<Manufacturer> manufacturers = manufacturerService.getManufacturers();
        List<Accessory> accessories = accessoryService.getAccessories();

        model.addAttribute("product", new Product());
        model.addAttribute("categories", categories);
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("accessories", accessories);

        return "create-product";
    }

    @PostMapping("/add")
    private String addProduct(@Valid Product product, BindingResult bindingResult, Model model, HttpServletRequest request) {

        List<Category> categories = categoryService.getCategories();
        List<Manufacturer> manufacturers = manufacturerService.getManufacturers();
        List<Accessory> accessories = accessoryService.getAccessories();

        if (bindingResult.hasErrors()) {

            model.addAttribute("categories", categories);
            model.addAttribute("manufacturers", manufacturers);
            model.addAttribute("accessories", accessories);

            return "create-product";
        }

        Long manufacturerId = product.getManufacturer().getId();
        Optional<Manufacturer> selectedManufacturer = manufacturers
                .stream()
                .filter(manufacturer -> manufacturer.getId().equals(manufacturerId))
                .findFirst();

        product.setManufacturer(selectedManufacturer.get());

        Long categoryId = product.getCategory().getId();
        Optional<Category> selectedCategory = categories
                .stream()
                .filter(category -> category.getId().equals(categoryId))
                .findFirst();

        product.setCategory(selectedCategory.get());

        String[] selectedAccessoriesIds = request.getParameterValues("accessories");

        if (selectedAccessoriesIds != null) {

            List<Accessory> selectedAccessories =
                    Arrays.stream(selectedAccessoriesIds)
                            .map(Long::parseLong)
                            .map(accessoryService::getAccessory)
                            .collect(Collectors.toList());

            product.setAccessories(selectedAccessories);
        }

        productService.saveProduct(product);

        return "redirect:/products";
    }

    @GetMapping("/{productId}/edit")
    private String editProduct(@PathVariable Long productId, Model model) {

        Product product = productService.getProduct(productId);
        model.addAttribute("product", product);

        return "edit-product";
    }

    @PatchMapping("/{productId}")
    private String updateProduct(@PathVariable Long productId, Product formProduct) {

        Product product = productService.getProduct(productId);
        product.setDescription(formProduct.getDescription());
        product.setUrl(formProduct.getUrl());
        product.setPrice(formProduct.getPrice());

        productService.saveProduct(product);

        return String.format("redirect:/products/%d", productId);
    }
}
