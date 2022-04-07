package com.tilek.spring.neobis.entitysamples;

import com.tilek.spring.neobis.entity.Order;
import com.tilek.spring.neobis.entity.Product;
import com.tilek.spring.neobis.entity.User;
import com.tilek.spring.neobis.entity.Warehouse;
import com.tilek.spring.neobis.model.enums.Role;
import com.tilek.spring.neobis.model.enums.Status;
import lombok.Data;

import java.util.*;

@Data
public class Samples {

    private List<Product> products;
    private List<Order> orders;
    private List<Warehouse> warehouses;
    private List<User> users;
    private Date date;

    public Samples() {
        warehouses = Arrays.asList(new Warehouse(1L, "Kyrgyzstan", "Bishkek", "Lev Tolstoy 2/1"),
                new Warehouse(2L, "Kyrgyzstan", "Bishkek", "Abay St. 5a"),
                new Warehouse(3L, "Kyrgyzstan", "Osh", "Prospect Manas 10/2"));
        products = Arrays.asList(new Product(1L, "Iphone 13", 1200, 10, warehouses.get(0)),
                new Product(2L, "Iphone 10", 1000, 10, warehouses.get(1)),
                new Product(3L, "Iphone 14", 1500, 10, warehouses.get(2)));
        this.orders = Arrays.asList(
                new Order(1L, 2, 2400D, "Kyrgyzstan",
                "Bishkek", "Asanbay 40/58",
                    new GregorianCalendar(2022, Calendar.APRIL, 1).getTime(), products.get(0)),
                new Order(2L, 3, 3000D, "Kyrgyzstan",
                    "Bishkek", "11mkr. 25/16",
                    new GregorianCalendar(2022, Calendar.APRIL, 5).getTime(), products.get(1)),
                new Order(2L, 3, 3000D, "Kyrgyzstan",
                    "Osh", "Shopokova 2D/1",
                    new GregorianCalendar(2022, Calendar.APRIL, 10).getTime(), products.get(2)));
        this.users = Arrays.asList(
                new User(1L, "tilek@gmail.com", "tilek", "Tilek", "Zholdoshbek",
                Role.DIRECTOR, Status.ACTIVE),
                new User(1L, "kanykei@gmail.com", "kanykei", "Kanykei", "Zholdoshbekova",
                        Role.ADMINISTRATOR, Status.ACTIVE));
    }
}
