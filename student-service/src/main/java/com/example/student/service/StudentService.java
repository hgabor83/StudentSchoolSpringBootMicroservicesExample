package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    public Student findStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(()->new RuntimeException("No such id"));
    }
}
