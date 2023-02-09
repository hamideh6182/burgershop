package com.example.burgershop.Repository;

import com.example.burgershop.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MenuRepo {
    private final Map<Integer, Menu> menus = new HashMap<>(Map.of(
            1,new Menu(1,"Menu1",40.00,"CheeseBurger","Pommes","CocaCola"),
            2,new Menu(2,"Menu2",35.00,"HamBurger","Pommes","Fanta"),
            3,new Menu(3,"Menu3",30.00,"JalapenoBurger","Pommes","Soft"),
            4,new Menu(4,"Menu4",25.00,"VegiBurger","Pommes","OrangeSoft")
    ));

    public Menu getMenu(int id){
        Menu menu = menus.get(id);
        if(menu == null){
            throw new NoSuchElementException("No Menu with id " + id + " found in this Menu repo.");
        }
        return menu;
    }

    public List<Menu> listMenu(){
        return new ArrayList<>(menus.values());
    }

    public Menu addMenu(Menu menu){
        menus.put(menu.id(), menu);
        return menu;
    }

    public Menu delete(int id){
        Menu menu = menus.get(id);
        if(menus.get(id) == null){
            return null;
        }
        menus.remove(id);
        return menu;
    }

    public Menu upDateMenu(int id,Menu menu){
        delete(id);
        addMenu(menu);
        return menu;
    }

}


