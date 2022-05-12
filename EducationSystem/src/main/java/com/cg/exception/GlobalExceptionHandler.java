package com.cg.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.payload.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceAlreadyExistException.class)
	public ResponseEntity<ErrorInfo> handleCourseAlreadyExistException(Exception e, HttpServletRequest req) {

		String uri = req.getRequestURI().toString();

		ErrorInfo errorInfo = new ErrorInfo(uri, e.getMessage());

		ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<>(errorInfo, HttpStatus.ALREADY_REPORTED);
		return responseEntity;
	}

	@ExceptionHandler(AuthenticationFailureException.class)
	public ResponseEntity<ErrorInfo> handleAuthenticationException(Exception e, HttpServletRequest req) {

		String uri = req.getRequestURI().toString();

		ErrorInfo errorInfo = new ErrorInfo(uri, e.getMessage());

		ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<>(errorInfo, HttpStatus.UNAUTHORIZED);
		return responseEntity;
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleProductNotExistingException(Exception e, HttpServletRequest req) {

		String uri = req.getRequestURI().toString();

		ErrorInfo errorInfo = new ErrorInfo(uri, e.getMessage());

		ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> handleException(Exception e, HttpServletRequest req) {

		String uri = req.getRequestURI().toString();

		ErrorInfo errorInfo = new ErrorInfo(uri, e.getMessage());

		ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
//		body.put("timestamp", new Date());
		body.put("status", status.value());

		// Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);
	}

}
