package com.example.demo;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("question_2")
public class Qestion_2 {

    private String country;
    private String city;
    private String gender;
    private String children;
    private String[] genderPreference;

    public String[] getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(String[] genderPreference) {
        this.genderPreference = genderPreference;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }
    public String checkMargins() {
        if (country != null && !country.trim().equals("") &&
                city != null && !city.trim().equals("") &&
                gender != null && !gender.trim().equals("") &&
                children != null && !children.trim().equals("") &&
                genderPreference != null && genderPreference.length != 0) {

            return "goToQuestion_3";
        }

        sendMessage("Заполнены не все поля");
        return null;
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, message, null));
    }

}
