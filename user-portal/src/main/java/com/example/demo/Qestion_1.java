package com.example.demo;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("question_1")
public class Qestion_1 {
    private String name;
    private String surname;
    private String age;
    private String familyStatus;
    private String[] preference;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String[] getPreference() {
        return preference;
    }

    public void setPreference(String[] preference) {
        this.preference = preference;
    }


    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String checkMargins() {
        if (name != null && !name.trim().equals("") &&
                surname != null && !surname.trim().equals("") &&
                age != null && !age.trim().equals("") &&
                familyStatus != null && !familyStatus.trim().equals("") &&
                preference != null && preference.length != 0) {

            return "goToQuestion_2";
        }

        sendMessage("Заполнены не все поля");
        return null;
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, message, null));
    }
}
