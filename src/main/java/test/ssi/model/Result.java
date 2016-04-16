package test.ssi.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Result<T> {

	private int code;
	
	private T data;
	
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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
	
	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.BrowserCompatible);
	}
	
	public static <T> Result<T> valueOfOK(T data) {
		Result<T> result = new Result<T>();
		result.setCode(ResultCode.SUCCESS.getCode());
		result.setData(data);
		
		return result;
	}
	
	public static Result<Object> valueOfError(ResultCode resultCode) {
		Result<Object> result = new Result<Object>();
		result.setCode(resultCode.getCode());
		result.setMessage(resultCode.getMessage());
		
		return result;
	}
	
	public static Result<Object> valueOfError(int code, String message) {
		Result<Object> result = new Result<Object>();
		result.setCode(ResultCode.SUCCESS.getCode());
		result.setMessage(message);
		
		return result;
	}
}
