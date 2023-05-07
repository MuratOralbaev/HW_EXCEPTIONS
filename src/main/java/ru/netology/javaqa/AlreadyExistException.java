package ru.netology.javaqa;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String e) {
        super(e);
    }
}
