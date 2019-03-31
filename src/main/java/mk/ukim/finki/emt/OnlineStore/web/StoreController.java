package mk.ukim.finki.emt.OnlineStore.web;

import mk.ukim.finki.emt.OnlineStore.model.Category;
import mk.ukim.finki.emt.OnlineStore.model.Manufacturer;
import mk.ukim.finki.emt.OnlineStore.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class StoreController {
    private List<Category> categories = new ArrayList<>(
            Arrays.asList(
                    new Category(Long.valueOf(0), "Shirts"),
                    new Category(Long.valueOf(1), "Shorts"),
                    new Category(Long.valueOf(2), "Shoes")
            )
    );

    private List<Manufacturer> manufacturers = new ArrayList<>(
            Arrays.asList(
                    new Manufacturer(Long.valueOf(0), "Nike"),
                    new Manufacturer(Long.valueOf(1), "Adidas"),
                    new Manufacturer(Long.valueOf(2), "Puma")
            )
    );

    private List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(Long.valueOf(0),
                            "Nike shirt",
                            "XL shirt",
                            "https://images-na.ssl-images-amazon.com/images/I/61OLLS-CDoL._UX679_.jpg",
                            categories.get(0),
                            manufacturers.get(0)),
                    new Product(Long.valueOf(1),
                            "Adidas shorts",
                            "Shorts for men",
                            "https://www.sportspower.com.au/wp-content/uploads/2018/07/BS5039-1295x1295.jpg",
                            categories.get(1),
                            manufacturers.get(1)),
                    new Product(Long.valueOf(2),
                            "Puma shoes",
                            "Shoes size 42",
                            "https://pumaimages.azureedge.net/images/355110/01/sv01/fnd/PNA/h/600/w/600",
                            categories.get(2),
                            manufacturers.get(2))
            )
    );

    @GetMapping("/products")
    private void showProducts(Model model) {

        model.addAttribute("products", products);
    }

    @GetMapping("/product/{productId}")
    private String showProduct(@PathVariable int productId, Model model) {

        Product product = products.get(productId);
        model.addAttribute("product", product);

        return "product";
    }

    @GetMapping("/products/add")
    private String createProduct(Model model) {

        model.addAttribute("product", new Product());
        model.addAttribute("categories", categories);
        model.addAttribute("manufacturers", manufacturers);

        return "create-product";
    }

    @PostMapping("/products/add")
    private String addProduct(@Valid Product product, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("categories", categories);
            model.addAttribute("manufacturers", manufacturers);

            return "create-product";
        }

        Long manufacturerId = product.getManufacturer().getId();
        Optional<Manufacturer> selectedManufacturer = manufacturers
            .stream()
            .filter(manufacturer -> manufacturer.getId().equals(manufacturerId))
            .findFirst();

        Long categoryId = product.getCategory().getId();
        Optional<Category> selectedCategory = categories
            .stream()
            .filter(category -> category.getId().equals(categoryId))
            .findFirst();

        product.setManufacturer(selectedManufacturer.get());
        product.setCategory(selectedCategory.get());
        product.setId(Long.valueOf(products.size()));
        products.add(product);

        return "redirect:/products";
    }
}
