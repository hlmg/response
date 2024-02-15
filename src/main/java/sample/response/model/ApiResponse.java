package sample.response.model;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
	private final Status status;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private MetaData metadata;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<T> results;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Object data;

	public ApiResponse(T result) {
		this(Collections.singletonList(result));
	}

	public ApiResponse(List<T> results) {
		this.status = new Status(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
		this.metadata = new MetaData(results.size());
		this.results = results;
	}

	public ApiResponse(int code, String message, Object data) {
		this.status = new Status(code, message);
		this.data = data;
	}

	@Getter
	@AllArgsConstructor
	private static class Status {
		private final int code;
		private final String message;
	}

	@Getter
	@AllArgsConstructor
	private static class MetaData {
		private final int resultCount;
	}
}
