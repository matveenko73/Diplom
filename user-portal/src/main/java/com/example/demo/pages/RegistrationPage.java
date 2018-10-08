package com.example.demo.pages;

import com.example.demo.Registration;
import com.example.demo.repositories.RegistrationRepository;
import org.springframework.data.domain.Example;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class RegistrationPage {

    @Inject
    private RegistrationRepository registrationRepository;
    private String email;
    private String login;
    private String password;
    private String repeatPassword;


    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String save() {
        if (password.equals(repeatPassword)) {

            Registration example = new Registration();
            example.setLogin(login);
            Optional<Registration> alreadyExist = registrationRepository.findOne(Example.of(example));
            if (alreadyExist.isPresent()) {
                sendMessage("Такой пользователь уже существует");
                return null;
            }

            Registration registration = new Registration();
            registration.setEmail(email);
            registration.setLogin(login);
            registration.setPassword(password);
            registrationRepository.save(registration);

            return "goToLogin";
        } else {
            sendMessage("Пароли не совпадают");
        }
        return null;
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, message, null));
    }
}
