package com.ua.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Position {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  String name;
    private int price;
}
