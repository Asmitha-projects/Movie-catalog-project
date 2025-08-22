package io.javaproject.movie_catalog_service.Model;

public class CatalogItem {
    private String name;
    private String desc;
    private String rating;

    public CatalogItem(String name, String desc, String rating) {
        this.rating = rating;
        this.desc = desc;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
