package com.ua.auth.domain.ejb;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Admin {
    @Id
    private long id;

    @OneToOne
    private Credentials credentials;
}
