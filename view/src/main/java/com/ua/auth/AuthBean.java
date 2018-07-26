package com.ua.auth;

import com.ua.auth.domain.ejb.Authentication;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class AuthBean implements Serializable{
    private boolean loggedIn;
    private String login;
    private String password;

    @EJB
    private Authentication authentication;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void doLogin(){
        if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)){
            loggedIn = false;
            return;
        }
        loggedIn = authentication.loginLikeUser(login, password);
    }
}
