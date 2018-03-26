package br.com.hermivaldo.webservice.model;

import com.google.gson.annotations.SerializedName;

public class LivroSaraiva {

    private String sku;
    private String brand;
    private String name;
    @SerializedName("price/bestPrice/value")
    private Float preco;


    public float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return this.name + this.sku + this.brand;
    }
}
