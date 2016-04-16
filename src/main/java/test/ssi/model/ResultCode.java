package test.ssi.model;

public enum ResultCode {
	
	SUCCESS(0, "success"),
	
	SERVER_ERROR(-1, "server error!"),
	
	PARAMETER_ERROR(-2, "parameter error!"),
	
	USER_NOT_EXISTS(1001, "用户不存在!"),
	
	USER_PASSWORD_ERROR(1002, "密码错误!");
	
	private ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	private int code;
	
	private String message;
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
