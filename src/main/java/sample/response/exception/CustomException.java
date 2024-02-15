package sample.response.exception;

import java.util.AbstractMap;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;

import lombok.Getter;
import sample.response.model.ErrorCode;

@Getter
public class CustomException extends RuntimeException {
	private final ErrorCode errorCode;
	private final String message;
	private final Map.Entry<String, Object> data;

	public CustomException(ErrorCode errorCode, String message, Object data) {
		this.errorCode = errorCode;
		this.message = message;
		this.data = new AbstractMap.SimpleEntry<>(data.getClass().getSimpleName(), data);
	}

	public String getMessage() {
		if (Strings.isBlank(message)) {
			return errorCode.getMessage();
		}
		return message;
	}
}
