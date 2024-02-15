package sample.response.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import sample.response.dto.SaveRequestDto;
import sample.response.exception.CustomException;
import sample.response.model.ApiResponse;
import sample.response.model.Student;
import sample.response.service.StudentService;

@RequiredArgsConstructor
@RestController
public class Controller {
	private final StudentService studentService;

	@PostMapping("/students")
	public ApiResponse<Student> save(@RequestBody SaveRequestDto requestDto) {
		return new ApiResponse<>(studentService.save(requestDto));
	}

	@GetMapping("/students")
	public ApiResponse<Student> findAll() {
		return new ApiResponse<>(studentService.findAll());
	}

	@GetMapping("/students/{grade}")
	public ApiResponse<Student> findAll(@PathVariable String grade) {
		return new ApiResponse<>(studentService.findByGrade(Integer.parseInt(grade)));
	}

	@ExceptionHandler(CustomException.class)
	public ApiResponse<?> customExceptionHandler(CustomException e, HttpServletResponse response) {
		response.setStatus(e.getErrorCode().getHttpStatus().value());
		return new ApiResponse<>(e.getErrorCode().getCode(), e.getMessage(), e.getData());
	}
}
