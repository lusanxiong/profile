package com.job528.util.exception;

import java.io.IOException;

/**
 * 上传图片异常
 * @author Sunday
 */
@SuppressWarnings("serial")
public class ImageException extends IOException {

	public ImageException() {
		super();
	}

	public ImageException(String message) {
		super(message);
	}

	public ImageException(Throwable cause) {
		super(cause);
	}

	public ImageException(String message, Throwable cause) {
		super(message, cause);
	}

}
