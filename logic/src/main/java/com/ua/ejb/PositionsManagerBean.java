package com.ua.ejb;

import com.ua.domain.Position;
import javafx.geometry.Pos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless @LocalBean
public class PositionsManagerBean {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Position cretatePosition(String name, int price){
        Position position = new Position();
        position.setName(name);
        position.setPrice(price);
        entityManager.persist(position);

        return position;
    }

    public List<Position> getPosition(){
        TypedQuery<Position> query = entityManager.createQuery("select c from Position c", Position.class);
        return query.getResultList();
    }
}
