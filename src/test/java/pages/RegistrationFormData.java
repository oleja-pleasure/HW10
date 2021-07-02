package pages;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RegistrationFormData {
    Faker faker = new Faker(new Locale("ru"));

    String fn = faker.name().firstName(),
            ln = faker.name().lastName(),
            email = faker.cat().name() + "@gmail.com",
            gender = "Other",
            mobile = faker.number().digits(10),
            monthOfBirth = "March",
            yearOfBirth = "1994",
            dayOfBirth = "12",
            subject = "Maths",
            hobby = "Reading",
            path = "img/",
            file = "HW#1.jpg",
            addr = faker.address().city(),
            state = "Haryana",
            city = "Panipat";
}
