package com.dilip.daggerexample

class UserRegistrationService(private val userRepository: UserRepository,
                              private val emailService: EmailService) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "abc@gmail.com", "User registered")
    }
}

/*
Unit testing
Single responsibility
Lifetime of these objects
Extensible
*/