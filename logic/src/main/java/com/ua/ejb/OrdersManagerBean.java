package com.ua.ejb;

import com.ua.domain.Order;
import com.ua.domain.Position;
import com.ua.domain.PositionInOrder;
import javafx.geometry.Pos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<Position> getPositionInOrder(long orderId){
        Order order = entityManager.find(Order.class, orderId);
        if(order == null){
            return Collections.emptyList();
        }

        List<PositionInOrder>positionInOrders = order.getPositionInOrder();
        List<Position> result = new ArrayList<>();
            for (PositionInOrder positionInOrder : positionInOrders){
                result.add(positionInOrder.getPosition());
            }
            return result;
    }
}
