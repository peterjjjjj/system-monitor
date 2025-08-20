package org.example.server.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {
    //Start SpringBoot.
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        System.out.println("Spring Boot Application Started.");
    }

}
