package com.example.demo;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RegistrationPage {

    @Inject
    private RegistrationRepository registrationRepository;
    private String emale;
    private String login;
    private String password;

    public String getEmale() {
        return emale;
    }

    public void setEmale(String emale) {
        this.emale = emale;
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
    public void save() {
        Registration registration = new Registration();
        registration.setEmale(emale);
        registration.setLogin(login);
        registration.setPassword(password);
        registrationRepository.save(registration);
    }
}
