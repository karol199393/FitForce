-- Tworzenie tabeli users
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    role VARCHAR(255),
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    phoneNumber VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(255),
    postalCode VARCHAR(255),
    country VARCHAR(255),
    instagram VARCHAR(255),
    trainings VARCHAR(255)
);

-- Tworzenie sekwencji user_seq
CREATE SEQUENCE user_seq START 1;

-- Tworzenie tabeli trainings
CREATE TABLE trainings (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    type VARCHAR(255),
    level VARCHAR(255),
    duration VARCHAR(255),
    equipment VARCHAR(255),
    exercises VARCHAR(255),
    imageUrl VARCHAR(255),
    trainer VARCHAR(255),
    category VARCHAR(255),
    calories VARCHAR(255),
    comments VARCHAR(255),
    date VARCHAR(255),
    time VARCHAR(255),
    location VARCHAR(255),
    price VARCHAR(255),
    status VARCHAR(255),
    participants VARCHAR(255),
    maxParticipants VARCHAR(255),
    rating VARCHAR(255),
    reviews VARCHAR(255),
    trainerId VARCHAR(255)
);

-- Tworzenie sekwencji trainings_seq
CREATE SEQUENCE trainings_seq START 1;
