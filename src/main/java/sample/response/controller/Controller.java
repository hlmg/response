package sample.response.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sample.response.dto.SaveRequestDto;
import sample.response.model.Student;
import sample.response.service.StudentService;

@RequiredArgsConstructor
@RestController
public class Controller {
	private final StudentService studentService;

	@PostMapping("/students")
	public Student save(@RequestBody SaveRequestDto requestDto) {
		return studentService.save(requestDto);
	}

	@GetMapping("/students")
	public List<Student> findAll() {
		return studentService.findAll();
	}

	@GetMapping("/students/{grade}")
	public List<Student> findAll(@PathVariable String grade) {
		return studentService.findByGrade(Integer.parseInt(grade));
	}
}
