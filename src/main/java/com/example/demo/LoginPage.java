package com.example.demo;

import org.springframework.data.domain.Example;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class LoginPage {

    @Inject
    private RegistrationRepository registrationRepository;

    private String login;
    private String password;

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

    public String checkPassword() {

        if (password.equals("admin") && login.equals("admin")) {
            return "goToAdministratorPage";
        }

        Registration examplePassword = new Registration();
        examplePassword.setPassword(password);
        examplePassword.setLogin(login);
        Optional<Registration> existPassword = registrationRepository.findOne(Example.of(examplePassword));

        if (existPassword.isPresent()) {
            return "goToQuestion_1";

        } else {
            login = "";
            password = "";
            sendMessage("Wrong Login or Password");
        }
        return null;
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, message, null));
    }
}
