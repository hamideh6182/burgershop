package com.example.burgershop.Service;

import com.example.burgershop.Repository.MenuRepo;
import com.example.burgershop.model.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BurgerShopServiceTest {

    MenuRepo menuRepo = mock(MenuRepo.class);
    BurgerShopService burgerShopService =new BurgerShopService(menuRepo);
    @Test
    void getMenu() {
        //GIVEN
        when(menuRepo.getMenu(1)).thenReturn(new Menu(1,"Menu1",40.00,"CheeseBurger","Pommes","CocaCola"));
        //WHEN
        Menu actual = burgerShopService.getMenu(1);
        //THEN
        verify(menuRepo).getMenu(1);
        Assertions.assertEquals(new Menu(1,"Menu1",40.00,"CheeseBurger","Pommes","CocaCola"),actual);
    }

    @Test
    void listMenu() {
        //Given
        when(menuRepo.listMenu()).thenReturn(List.of(new Menu(1,"Menu1",40.00,"CheeseBurger","Pommes","CocaCola")));
        //WHEN
        List<Menu> actual = burgerShopService.listMenu();
        //THEN
        verify(menuRepo).listMenu();
        Assertions.assertEquals(List.of(new Menu(1,"Menu1",40.00,"CheeseBurger","Pommes","CocaCola")),actual);
    }

    @Test
    void addMenu() {
        //GIVEN
        when(menuRepo.addMenu(new Menu(5,"Menu5",40.00,"CheeseBurger","Pommes","CocaCola")))
                .thenReturn(new Menu(5,"Menu5",40.00,"CheeseBurger","Pommes","CocaCola"));
        //WHEN
        Menu actual = burgerShopService.addMenu(new Menu(5,"Menu5",40.00,"CheeseBurger","Pommes","CocaCola"));
        //
        verify(menuRepo).addMenu(new Menu(5,"Menu5",40.00,"CheeseBurger","Pommes","CocaCola"));
        Assertions.assertEquals(new Menu(5,"Menu5",40.00,"CheeseBurger","Pommes","CocaCola"),actual);
    }

    @Test
    void deleteMenu() {
        //GIVEN
        when(menuRepo.delete(1)).thenReturn(new Menu(1,"Menu1",40.00,"CheeseBurger","Pommes","CocaCola"));
        //WHEN
        Menu actual = burgerShopService.deleteMenu(1);
        //THEN
        verify(menuRepo).delete(1);
        Assertions.assertEquals(new Menu(1,"Menu1",40.00,"CheeseBurger","Pommes","CocaCola"),actual);
    }

    @Test
    void upDateMenu() {
        //GIVEN
        when(menuRepo.upDateMenu(2,new Menu(2,"Menu2",35.00,"HamBurger","Pommes","Fanta")))
                .thenReturn(new Menu(2,"Menu2",35.00,"HamBurger","Pommes","Fanta"));

        when(menuRepo.delete(2)).thenReturn(new Menu(2,"Menu2",35.00,"HamBurger","Pommes","Fanta"));

        when(menuRepo.addMenu(new Menu(2,"Menu2",35.00,"HamBurger","Pommes","Fanta")))
                .thenReturn(new Menu(2,"Menu2",35.00,"HamBurger","Pommes","Fanta"));

        //WHEN
        Menu actual = burgerShopService.upDateMenu(2,new Menu(2,"Menu2",35.00,"HamBurger","Pommes","Fanta"));
        Assertions.assertEquals(new Menu(2,"Menu2",35.00,"HamBurger","Pommes","Fanta"),actual);
    }
}