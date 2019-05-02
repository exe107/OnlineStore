package mk.ukim.finki.emt.OnlineStore.service.impl;

import mk.ukim.finki.emt.OnlineStore.model.Product;
import mk.ukim.finki.emt.OnlineStore.persistence.ProductRepository;
import mk.ukim.finki.emt.OnlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {

        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);

        return products;
    }

    @Override
    public Product getProduct(Long id) {

        return productRepository.findById(id).get();
    }

    @Override
    public void saveProduct(Product product) {

        productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {

        return productRepository.getProductsByCategoryId(categoryId);
    }

    @Override
    public List<Product> getProductsByCategoryAndManufacturer(Long categoryId, Long manufacturerId) {

        return productRepository.getProductsByCategoryIdAndManufacturerId(categoryId, manufacturerId);
    }

    @Override
    public Long getProductsTotalSumByCategory(Long categoryId) {

        List<Product> products = getProductsByCategory(categoryId);

        int totalSum = products.stream().mapToInt(product -> product.getPrice()).sum();

        return new Long(totalSum);
    }

    @Override
    public List<Product> getProductsByPage(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }
}
