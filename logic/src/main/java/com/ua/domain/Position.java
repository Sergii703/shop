package com.ua.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  String name;
    private int price;

    @OneToMany(mappedBy = "position")
    private List<PositionInOrder> positionInOrder;

    public List<PositionInOrder> getPositionInOrder() {
        return positionInOrder;
    }

    public void setPositionInOrder(List<PositionInOrder> positionInOrder) {
        this.positionInOrder = positionInOrder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
