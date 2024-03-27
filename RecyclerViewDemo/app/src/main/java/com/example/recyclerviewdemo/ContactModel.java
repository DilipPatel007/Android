package com.example.recyclerviewdemo;

import java.util.ArrayList;

public class ContactModel {
    int img; // An integer representing the image resource ID
    String name; // A string to store the contact name
    String number; // A string to store the contact phone number

    // Constructor: Initializes the ContactModel with image, name, and number
    ContactModel(int img, String name, String number) {
        this.img = img; // Assign the provided image resource ID to the 'img' field
        this.name = name; // Assign the provided name to the 'name' field
        this.number = number; // Assign the provided phone number to the 'number' field
    }

    ContactModel(String name, String number) {
        this.name = name; // Assign the provided name to the 'name' field
        this.number = number; // Assign the provided phone number to the 'number' field
    }
}
