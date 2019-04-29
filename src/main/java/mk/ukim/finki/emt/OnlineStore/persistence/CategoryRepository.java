package mk.ukim.finki.emt.OnlineStore.persistence;

import mk.ukim.finki.emt.OnlineStore.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
