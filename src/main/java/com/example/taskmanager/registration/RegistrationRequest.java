package com.example.taskmanager.registration;

import jakarta.persistence.Column;
import org.hibernate.annotations.NaturalId;

public record RegistrationRequest(
        String firstname,
        String lastname,
        String email,
        long phonenumber,
        String password) {
}
