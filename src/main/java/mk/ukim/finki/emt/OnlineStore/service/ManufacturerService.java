package mk.ukim.finki.emt.OnlineStore.service;

import mk.ukim.finki.emt.OnlineStore.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    List<Manufacturer> getManufacturers();

    void saveManufacturer(Manufacturer manufacturer);
}
