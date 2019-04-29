package mk.ukim.finki.emt.OnlineStore.service.impl;

import mk.ukim.finki.emt.OnlineStore.model.Accessory;
import mk.ukim.finki.emt.OnlineStore.persistence.AccessoryRepository;
import mk.ukim.finki.emt.OnlineStore.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    private AccessoryRepository accessoryRepository;

    @Override
    public List<Accessory> getAccessories() {

        List<Accessory> accessories = new ArrayList<>();
        accessoryRepository.findAll().forEach(accessories::add);

        return accessories;
    }
}
