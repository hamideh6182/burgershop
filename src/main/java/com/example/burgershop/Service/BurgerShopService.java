package com.example.burgershop.Service;

import com.example.burgershop.Repository.MenuRepo;
import com.example.burgershop.model.Menu;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class BurgerShopService {
    private final MenuRepo menuRepo;

    public BurgerShopService(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    public Menu getMenu(int id){
        return menuRepo.getMenu(id);
    }

    public List<Menu> listMenu(){
        return menuRepo.listMenu();
    }

    public Menu addMenu(Menu menu){
        return menuRepo.addMenu(menu);
    }

    public Menu deleteMenu(int id){
        return menuRepo.delete(id);
    }

    public Menu upDateMenu(int id,Menu menu){
        return menuRepo.upDateMenu(id,menu);
    }


}
