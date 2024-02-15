package sample.response.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sample.response.dto.SaveRequestDto;
import sample.response.model.Student;
import sample.response.repository.StudentRepository;

@RequiredArgsConstructor
@Service
public class StudentService {
	private final StudentRepository studentRepository;

	public Student save(SaveRequestDto requestDto) {
		Student student = new Student(requestDto.name(), requestDto.grade());
		studentRepository.save(student);
		return student;
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public List<Student> findByGrade(int grade) {
		return studentRepository.findByGrade(grade);
	}
}
