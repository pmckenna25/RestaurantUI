package ui.Model;

import java.util.List;

public class Order {

    private String table;
    private int orderNumber;
    private List<Stuff> order;

    public Order(String table, List<Stuff> order, int orderNumber){

        this.orderNumber = orderNumber;
        this.table = table;
        this.order = order;
    }

}
