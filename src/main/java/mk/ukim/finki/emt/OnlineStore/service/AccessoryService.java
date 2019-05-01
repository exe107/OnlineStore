package mk.ukim.finki.emt.OnlineStore.service;

import mk.ukim.finki.emt.OnlineStore.model.Accessory;

import java.util.List;

public interface AccessoryService {

    List<Accessory> getAccessories();

    Accessory getAccessory(Long id);

    void saveAccessory(Accessory accessory);
}
