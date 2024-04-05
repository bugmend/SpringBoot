package de.applo.Applo.model;


//to model immutable data. It is an excellent choice for carrying data without having to write boilerplate code.
public record Book(Integer id, String name, Genre genre) {
}
