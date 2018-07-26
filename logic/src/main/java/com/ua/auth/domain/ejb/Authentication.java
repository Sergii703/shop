package com.ua.auth.domain.ejb;

import org.apache.commons.lang3.StringUtils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class Authentication {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public boolean loginLikeUser(String email, String pasword){
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(pasword)){
            return false;
        }
        Credentials credentials = entityManager.find(Credentials.class, email);
        if (credentials == null){
            return false;
        }

        if(!pasword.equals(credentials.getPassword())){
            return false;
        }
        User user = credentials.getUser();
        return user != null;
    }

    public boolean loginLikeAdmin(String email, String pasword){
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(pasword)){
            return false;
        }
        Credentials credentials = entityManager.find(Credentials.class, email);
        if (credentials == null){
            return false;
        }

        if(!pasword.equals(credentials.getPassword())){
            return false;
        }
        Admin admin = credentials.getAdmin();
        return admin != null;
    }
}
