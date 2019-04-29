package mk.ukim.finki.emt.OnlineStore.persistence;

import mk.ukim.finki.emt.OnlineStore.model.Accessory;
import org.springframework.data.repository.CrudRepository;

public interface AccessoryRepository extends CrudRepository<Accessory, Long> {
}
