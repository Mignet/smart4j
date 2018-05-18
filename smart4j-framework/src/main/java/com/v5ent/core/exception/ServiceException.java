package com.v5ent.core.exception;

/**
 * ServiceException : 服务层发生的异常
 *
 * @author Mignet
 * @since 2014-09-27 18:09
 */
public class ServiceException extends GenericException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8554025843930995042L;

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
