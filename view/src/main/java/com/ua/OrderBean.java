package com.ua;

import com.ua.domain.Order;
import com.ua.domain.Position;
import com.ua.ejb.OrdersManagerBean;
import com.ua.ejb.PositionsManagerBean;
import javafx.geometry.Pos;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Named
@SessionScoped
public class OrderBean implements Serializable {
    private Order order;
    private String name;
    private int price;
    private  int quantity;

    @EJB
    private OrdersManagerBean ordersManagerBean;

    @EJB
    private PositionsManagerBean positionsManagerBean;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void createOrder(){
        if(order == null){
            order = ordersManagerBean.createOrder();
        }
    }

    public void createPosition(){
        positionsManagerBean.cretatePosition(name, price);
    }

    public List<Position> getPosition(){
        return positionsManagerBean.getPosition();
    }

    public void addPosition(Position position){
        if (order == null){
            return;
        }
        ordersManagerBean.addOrder(position.getId(), order.getId(), 1);
    }

    public List<Position> getPositionInOrder(){
        if(order == null){
            return Collections.emptyList();
        }
        return ordersManagerBean.getPositionInOrder(order.getId());
    }
}
