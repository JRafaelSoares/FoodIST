package pt.ulisboa.tecnico.cmov.foodist.domain;

import java.util.List;
import java.util.Map;

import foodist.server.grpc.contract.Contract;

public class Menu {
    private String foodServiceName;
    private String menuName;
    private double price;
    private Contract.FoodType type;
    private String language;
    private String translatedName;
    private String menuId;

    //To send menus to the server
    public Menu(String foodServiceName, String menuName, double price, Contract.FoodType type, String language, String translatedName) {
        this.foodServiceName = foodServiceName;
        this.menuName = menuName;
        this.price = price;
        this.type = type;
        this.language = language;
        this.translatedName = translatedName;
    }

    //To receive menus from the server
    public Menu(String originalName, double price, Contract.FoodType type, String language, String translatedName, String menuId) {
        this.price = price;
        this.type = type;
        this.language = language;
        this.translatedName = translatedName;
        this.menuName = originalName;
        this.menuId = menuId;
    }


    public String getFoodServiceName() {
        return this.foodServiceName;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public double getPrice() {
        return this.price;
    }

    public static Menu parseContractMenu(Contract.Menu menu) {
        return new Menu(menu.getOriginalName(), menu.getPrice(), menu.getType(), menu.getLanguage(), menu.getTranslatedName(), String.valueOf(menu.getMenuId()));
    }

    public Contract.FoodType getType() {
        return type;
    }

    public boolean isDesirable(Map<Contract.FoodType, Boolean> constraints) {
        return constraints.get(this.type);
    }

    public String getLanguageName() {
        return this.language;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getTranslatedName() {
        return this.translatedName;
    }

    public String getMenuId() {
        return menuId;
    }
}
