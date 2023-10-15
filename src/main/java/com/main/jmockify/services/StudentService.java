package com.main.jmockify.services;

import org.springframework.stereotype.Service;

import com.main.jmockify.entities.Student;
import com.main.jmockify.reposotory.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student getStudentById(int id) {
		return studentRepository.findById(id).orElse(null);
	}
}
