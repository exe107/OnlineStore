package mk.ukim.finki.emt.OnlineStore.service;

import mk.ukim.finki.emt.OnlineStore.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(Long id);

    void saveProduct(Product product);

    List<Product> getProductsByCategory(Long categoryId);

    List<Product> getProductsByCategoryAndManufacturer(Long categoryId, Long manufacturerId);

    Long getProductsTotalSumByCategory(Long categoryId);
}
