package com.xianghuangqi.thread;

public class ThreadTest {

	public static void main(String[] args) {

			Thread thread =  new Thread(){
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
				
			};
			thread.start();
	}

}
