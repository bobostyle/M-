package com.main.java.exception;

 /**
 * NumberFaultException.java
 * 2016年11月13日上午12:26:12
 * @author cbb
 * TODO 如果传入的牌数量不是三张,那么抛出异常
 */
public class NumberFaultException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumberFaultException(){
		super();
	}
	
	public NumberFaultException(String s){
		super(s);
	}
	
	public NumberFaultException(String s, Throwable throwable){
		super(s, throwable);
	}
}
