package com.example.burgershop.Controller;

import com.example.burgershop.Repository.MenuRepo;
import com.example.burgershop.Service.BurgerShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

class BurgerShopControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MenuRepo menuRepo;

    @Autowired
    BurgerShopService burgerShopService;

    @Test
    void menus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/burger-shop-api/menus"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
[
    {
        "id": 1,
        "name": "Menu1",
        "price": 40.0,
        "mainDish": "CheeseBurger",
        "sideDish": "Pommes",
        "beverage": "CocaCola"
    },
    {
        "id": 2,
        "name": "Menu2",
        "price": 35.0,
        "mainDish": "HamBurger",
        "sideDish": "Pommes",
        "beverage": "Fanta"
    },
    {
        "id": 3,
        "name": "Menu3",
        "price": 30.0,
        "mainDish": "JalapenoBurger",
        "sideDish": "Pommes",
        "beverage": "Soft"
    },
    {
        "id": 4,
        "name": "Menu4",
        "price": 25.0,
        "mainDish": "VegiBurger",
        "sideDish": "Pommes",
        "beverage": "OrangeSoft"
    }
]

"""));

    }

    @Test
    void menu() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/burger-shop-api/menus/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""

{
    "id": 1,
    "name": "Menu1",
    "price": 40.0,
    "mainDish": "CheeseBurger",
    "sideDish": "Pommes",
    "beverage": "CocaCola"
}
"""));
    }

    @Test
    void addMenu() {
    }

    @Test
    void upDateMenu() {
    }

    @Test
    void deleteMenu() {
    }
}