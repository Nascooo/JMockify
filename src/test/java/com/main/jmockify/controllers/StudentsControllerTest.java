package com.main.jmockify.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.main.jmockify.entities.Student;
import com.main.jmockify.reposotory.StudentRepository;
import com.main.jmockify.services.StudentService;

@SpringBootTest
class StudentsControllerTest {

	@Mock
	StudentRepository studentRepository;

	@InjectMocks
	StudentService studentService;

	@Test
	void testGetStudent() {
		//Given
		Student mockStudent = Instancio.create(Student.class);
		//When
		Integer id = mockStudent.getId();
		when(studentRepository.findById(id)).thenReturn(Optional.of(mockStudent));

		Student result = studentService.getStudentById(id);

		assertNotNull(result);
		assertEquals(mockStudent.getId(), result.getId());
		assertEquals(mockStudent.getAddress(), result.getAddress());
	}
}