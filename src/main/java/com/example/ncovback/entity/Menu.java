package com.example.ncovback.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private String path;
    private String name;
    private String label;
    private String icon;
    private String url;
    private List<Menu> children;

    public Menu() {
    }
    public Menu(String path, String name, String label, String icon, String url) {
        this.path = path;
        this.name = name;
        this.label = label;
        this.icon = icon;
        this.url = url;
    }
}
