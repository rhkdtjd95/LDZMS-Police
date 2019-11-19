package kr.go.police;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = -5076833498282338928L;

	private String code;
	private String message;

	public Message() {
	}

	public Message(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
