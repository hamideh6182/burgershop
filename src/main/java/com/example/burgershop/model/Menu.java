package com.example.burgershop.model;

public record Menu (
        int id,
        String name,
        double price,
        String mainDish,
        String sideDish,
        String beverage
        ){
}
