package mk.ukim.finki.emt.OnlineStore.service.impl;

import mk.ukim.finki.emt.OnlineStore.model.Manufacturer;
import mk.ukim.finki.emt.OnlineStore.persistence.ManufacturerRepository;
import mk.ukim.finki.emt.OnlineStore.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> getManufacturers() {

        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturerRepository.findAll().forEach(manufacturers::add);

        return manufacturers;
    }

    @Override
    public void saveManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }
}
