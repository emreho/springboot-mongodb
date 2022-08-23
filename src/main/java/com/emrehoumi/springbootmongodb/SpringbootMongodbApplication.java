package com.emrehoumi.springbootmongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringbootMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository) {
        return args -> {
            Address address = new Address("Morocco", "Marrakesh", "Ne4");
            Student student = new Student("El Mehdi", "REHOUMI", "emrehoumi@gmail.com", Gender.FEMALE, address, List.of("React"), BigDecimal.TEN, LocalDateTime.now());
            studentRepository.insert(student);
        };
    }

}
