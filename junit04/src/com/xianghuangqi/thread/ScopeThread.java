package com.xianghuangqi.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ScopeThread {

	private static int data = 0;
	private static Map<Thread, Integer> threadDat = new HashMap<Thread, Integer>();
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			
		new Thread(new Runnable() {
			
			public void run() {
//				data = new Random().nextInt();//2个线程之间共享数据
				int data = new Random().nextInt();//不共享
				threadDat.put(Thread.currentThread(), data);
				System.out.println("main "+Thread.currentThread().getName()+" put data "+data);
				new A().get();
			    new B().get();
			}
		}).start();
		
		}
		
		
	}
	static class A{
		public void get(){
			int data = threadDat.get(Thread.currentThread());
			System.out.println("A "+Thread.currentThread().getName()+" get data "+data);
		}
		
	}

	static class B{
		public void get(){
			int data = threadDat.get(Thread.currentThread());
			System.out.println("A "+Thread.currentThread().getName()+" get data "+data);
		}
	}
}


