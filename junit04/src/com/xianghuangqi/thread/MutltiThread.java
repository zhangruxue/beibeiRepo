package com.xianghuangqi.thread;

public class MutltiThread {

	public static void main(String[] args) {
		new MutltiThread().init();

	}
	private void init(){
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			public void run() {
				while(true){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				outputer.output("zhangsan");
			   }
				}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				while(true){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				outputer.output("lisi");
			}
			}
		}).start();
	}
	
	class Outputer{
		
		public synchronized void output(String name){
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
		
	}

}
