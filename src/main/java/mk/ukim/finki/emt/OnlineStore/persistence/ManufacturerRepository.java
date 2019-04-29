package mk.ukim.finki.emt.OnlineStore.persistence;

import mk.ukim.finki.emt.OnlineStore.model.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
}
