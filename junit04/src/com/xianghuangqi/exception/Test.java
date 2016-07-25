package com.xianghuangqi.exception;

public class Test {

	public static void main(String[] args) {
		try{
		new CustomerRegister().register("jac hkjhk");
		}catch(IllegalNameException e){
			System.out.println(e.getMessage());
		}
	}

}
