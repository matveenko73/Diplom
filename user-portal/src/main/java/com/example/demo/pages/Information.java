package com.example.demo.pages;

import com.example.demo.pages.Qestion_1;
import com.example.demo.pages.Qestion_3;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Information {

    @Inject
    private Qestion_1 question1;

    @Inject
    private Qestion_3 question3;
}
