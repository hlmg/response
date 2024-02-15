package sample.response.model;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {
	OK(2000, "OK", HttpStatus.OK),
	BAD_REQUEST(500, "BAD REQUEST", HttpStatus.OK),
	;

	private final int code;
	private final String message;
	private final HttpStatus httpStatus;

	ErrorCode(int code, String message, HttpStatus httpStatus) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}
}
