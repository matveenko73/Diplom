package com.example.demo;

import com.example.demo.pages.Person;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Main {

    @Inject
    private Person person;

    private String password;
    private String login;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String checkPassword() {
        if (password.equals("1")) {
            return "goToProfile";
        } else {
            login = "";
            password = "";
            sendMessage("Wrong Password");
        }
        return null;
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, message, null));
    }
}
