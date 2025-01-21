package ua.ithillel.jakartaee.service;

public class HelloService {
    public String sayHello() {
        return "Hello World!";
    }

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
