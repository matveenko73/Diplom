package com.example.demo;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("question_3")
public class Qestion_3 {

    private String profession;
    private String nameOrganization;
    private String education;
    private String car;
    private String[] carPreference;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String[] getCarPreference() {
        return carPreference;
    }

    public void setCarPreference(String[] carPreference) {
        this.carPreference = carPreference;
    }

    public String checkMargins() {
        if (profession != null && !profession.trim().equals("") &&
                nameOrganization != null && !nameOrganization.trim().equals("") &&
                education != null && !education.trim().equals("") &&
                car != null && !car.trim().equals("") &&
                carPreference != null && carPreference.length != 0) {

            return "goToInformation";
        }
        sendMessage("Заполнены не все поля");
        return null;
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, message, null));
    }
}
