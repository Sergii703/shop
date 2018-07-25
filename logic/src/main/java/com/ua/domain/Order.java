package com.ua.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "order")
    private List<PositionInOrder> positionInOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PositionInOrder> getPositionInOrder() {
        return positionInOrder;
    }

    public void setPositionInOrder(List<PositionInOrder> positionInOrder) {
        this.positionInOrder = positionInOrder;
    }
}
