package com.emrehoumi.springbootmongodb.controller;

import com.emrehoumi.springbootmongodb.bean.Student;
import com.emrehoumi.springbootmongodb.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService strudentService;

    @GetMapping
    public List<Student> fetchAllStudents() {
        return strudentService.fetchAllStudents();
    }


}
