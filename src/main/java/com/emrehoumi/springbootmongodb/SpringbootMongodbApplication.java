package com.emrehoumi.springbootmongodb;

import com.emrehoumi.springbootmongodb.bean.Address;
import com.emrehoumi.springbootmongodb.bean.Gender;
import com.emrehoumi.springbootmongodb.bean.Student;
import com.emrehoumi.springbootmongodb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringbootMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address("Morocco", "Marrakesh", "Ne4");
            Student student = new Student("El Mehdi", "REHOUMI", "emrehoumi@gmail.com", Gender.FEMALE, address, List.of("React"), BigDecimal.TEN, LocalDateTime.now());

            // usingMongoTemplate(student, studentRepository, mongoTemplate);

            studentRepository
                    .findStudentByEmail("emrehoumi@gmail.com")
                    .ifPresentOrElse(s -> System.out.println(s.getFirstName() + " " + s.getLastName()), () -> studentRepository.insert(student)
            );
        };
    }

    private static void usingMongoTemplate(Student student, StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is("emrehoumi@gmail.com").and("firstName").is("El Mehdi"));
        List<Student> students = mongoTemplate.find(query, Student.class);
        if (students.isEmpty()) studentRepository.insert(student);
        for (Student s : students) System.out.println(s.getFirstName() + " " + s.getLastName());
    }
}
