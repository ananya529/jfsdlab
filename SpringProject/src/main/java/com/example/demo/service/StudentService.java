package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Add a Student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Update Student by ID
    public Student updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }

    // Delete Student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
