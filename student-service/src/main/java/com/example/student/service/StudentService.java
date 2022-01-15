package com.example.student.service;

import com.example.student.VO.ResponseTemplateVO;
import com.example.student.VO.School;
import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /* If it's a bean
    @Autowired
    private RestTemplate restTemplate;
     */

    public Student save(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    public Student findStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("No such id"));
    }

    public ResponseTemplateVO getStudentWithSchool(Integer studentId) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        RestTemplate restTemplate=new RestTemplate();

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("No such id"));
        School school = restTemplate.getForObject("http://localhost:8081/schools/" + student.getSchoolId(), School.class);

        responseTemplateVO.setStudent(student);
        responseTemplateVO.setSchool(school);

        return responseTemplateVO;
    }
}
