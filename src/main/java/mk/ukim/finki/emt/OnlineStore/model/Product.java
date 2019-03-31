package mk.ukim.finki.emt.OnlineStore.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Product {

    private Long id;

    @NotBlank
    private String name;

    private String description;
    private String url;

    @NotNull
    private Category category;

    @NotNull
    private Manufacturer manufacturer;

    public Product() { }

    public Product(Long id, String name, String description, String url, Category category, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = category;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
