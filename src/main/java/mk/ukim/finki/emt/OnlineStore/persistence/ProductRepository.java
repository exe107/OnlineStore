package mk.ukim.finki.emt.OnlineStore.persistence;

import mk.ukim.finki.emt.OnlineStore.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> getProductsByCategoryId(Long id);

    List<Product> getProductsByCategoryIdAndManufacturerId(Long categoryId, Long manufacturerId);
}
