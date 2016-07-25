package com.xianghuangqi.exception;

public class CustomerRegister {
	
	public void register(String username) throws IllegalNameException{
		if(username.length() < 6){
			throw new IllegalNameException("用户名长度低于6位！");
		}
		System.out.println("注册成功！");
	}

}
