package com.glaucus.fms.responses.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.glaucus.fms.enums.FmsResponseCode;

@JsonInclude(Include.NON_NULL)
public class BaseApiResponse<T> {

	protected boolean error;
	protected String code;
	protected T data;
	protected String message;
	protected String detailMessage;
	protected List<String> fieldErrors;

	public BaseApiResponse() {
	};

	public BaseApiResponse(boolean error, String code, T data, String message) {
		this.error = error;
		this.code = code;
		this.data = data;
		this.message = message;
	}

	public BaseApiResponse(boolean error, String code, T data, String message, String detailedMessage) {
		this(error, code, data, message);
		this.detailMessage = detailedMessage;
	}

	public BaseApiResponse(boolean error, FmsResponseCode lavaOssResponseCode) {
		this(error, lavaOssResponseCode.getCode(), null, lavaOssResponseCode.getMessage());
	}

	public BaseApiResponse(boolean error, T data, FmsResponseCode lavaOssResponseCode) {
		this(error, lavaOssResponseCode.getCode(), data, lavaOssResponseCode.getMessage());
	}

	public BaseApiResponse(boolean error, T data, FmsResponseCode lavaOssResponseCode, String detailMessage) {
		this(error, lavaOssResponseCode.getCode(), data, lavaOssResponseCode.getMessage(), detailMessage);
	}

	public BaseApiResponse(boolean error, T data, FmsResponseCode lavaOssResponseCode, List<String> fieldErrors) {
		this(error, lavaOssResponseCode.getCode(), data, lavaOssResponseCode.getMessage());
		this.fieldErrors = fieldErrors;
	}

	public BaseApiResponse(String code, String message, T object) {
		this.code = code;
		this.message = message;
		this.data = object;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public List<String> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

}
