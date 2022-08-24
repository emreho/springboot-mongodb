package com.emrehoumi.springbootmongodb.service;

import com.emrehoumi.springbootmongodb.bean.Student;
import com.emrehoumi.springbootmongodb.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }
}
