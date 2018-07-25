package com.ua.ejb;

import com.ua.domain.Order;
import com.ua.domain.Position;
import com.ua.domain.PositionInOrder;
import javafx.geometry.Pos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class OrdersManagerBean {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Order createOrder(){
        Order order = new Order();
        entityManager.persist(order);

        return order;
    }

    public Position cretatePosition(String name, int price){
        Position position = new Position();
        position.setName(name);
        position.setPrice(price);
        entityManager.persist(position);

        return position;
    }

    public boolean addOrder(long positionId, long orderId, int quantity){
        Position position = entityManager.find(Position.class, positionId);
        if(position == null){
            return false;
        }

        Order order = entityManager.find(Order.class, orderId);
            if(order == null){
                return false;
            }


        PositionInOrder positionInOrder = new PositionInOrder();
        positionInOrder.setOrder(order);
        positionInOrder.setPosition(position);
        positionInOrder.setQuantity(quantity);
        entityManager.persist(positionInOrder);

        return true;
    }
}
