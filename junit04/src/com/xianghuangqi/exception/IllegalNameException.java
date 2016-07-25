package com.xianghuangqi.exception;

public class IllegalNameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalNameException(){}
	
	public IllegalNameException(String msg){
		super(msg);
	}
}
