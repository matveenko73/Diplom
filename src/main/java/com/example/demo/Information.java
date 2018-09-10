package com.example.demo;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Information {

    @Inject
    private Qestion_1 question1;

    @Inject
    private Qestion_2 question2;

    @Inject
    private Qestion_3 question3;
}
