package com.example.demo;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class AdministrationPage {

    @Inject
    private RegistrationRepository registrationRepository;

    private Registration registrationForDelete;

    public Registration getRegistrationForDelete() {
        return registrationForDelete;
    }

    public void setRegistrationForDelete(Registration registrationForDelete) {
        //registrationRepository.deleteById(registrationForDelete.getId());
        registrationRepository.delete(registrationForDelete);
    }

    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }
}
