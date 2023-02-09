package com.example.burgershop.Controller;


import com.example.burgershop.Service.BurgerShopService;
import com.example.burgershop.model.Menu;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger-shop-api")
public class BurgerShopController {

    private final BurgerShopService burgerShopService;

    public BurgerShopController(BurgerShopService burgerShopService) {
        this.burgerShopService = burgerShopService;
    }

    @GetMapping("/menus")
    public List<Menu> menus(){
        return burgerShopService.listMenu();
    }

    @GetMapping("/menus/{id}")
    public Menu menu(@PathVariable int id){
        return burgerShopService.getMenu(id);
    }

    @PostMapping("/menu")
    public Menu addMenu(@RequestBody Menu menu){
         return burgerShopService.addMenu(menu);
    }

    @PutMapping("/menus/{id}")
    public Menu upDateMenu(@PathVariable int id,@RequestBody Menu menu){
        return burgerShopService.upDateMenu(id,menu);
    }

    @DeleteMapping("/menus/{id}")
    public Menu deleteMenu(@PathVariable int id){
        return burgerShopService.deleteMenu(id);
    }
}
