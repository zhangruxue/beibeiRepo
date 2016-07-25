package com.xianghuangqi.thread;

import java.util.Random;

public class ThreadLocalTest {

	public static void main(String[] args) {
		for(int i = 0; i < 2; i++){
		new Thread(new Runnable() {
			public void run() {
				int data = new Random().nextInt();
				MyThreadLocal myData = MyThreadLocal.getThreadInstance();
				myData.setAge(data);
				myData.setName("name"+data);
				System.out.println("main put data : name:"+myData.getName()+" age "+myData.getAge());
				new A().get();
				new B().get();
			}
		}).start();
	}
	}
	static class A{
		public void get(){
			MyThreadLocal local = MyThreadLocal.getThreadInstance();
			System.out.println("A get data : name:"+local.getName()+" age"+local.getAge());
		}
		
	}
	static class B{
		public void get(){
			MyThreadLocal local = MyThreadLocal.getThreadInstance();
			System.out.println("B get data : name:"+local.getName()+" age"+local.getAge());
		}
		
	}
}


class MyThreadLocal{
	private static ThreadLocal<MyThreadLocal> myLocal = new ThreadLocal<MyThreadLocal>();
	private MyThreadLocal(){}
	public static MyThreadLocal getThreadInstance(){
		MyThreadLocal threadInstance = myLocal.get();
		if(threadInstance == null){
			threadInstance = new MyThreadLocal();
			myLocal.set(threadInstance);
		}
		return threadInstance;
	}
	
	
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}