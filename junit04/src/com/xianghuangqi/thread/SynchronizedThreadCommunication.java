package com.xianghuangqi.thread;

/**
 * 实现子线程10次，主线程100，依次循环
 * @author zhangruxue
 *
 */
public class SynchronizedThreadCommunication {

	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			
			public void run() {
				for (int i = 1; i <= 50; i++) {
					business.sub(i);
				}
			}
		}).start();
		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}
	}


}
class Business{
	private boolean isSub = true;
	public synchronized void sub(int j){
		while(!isSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 1; i <= 10; i++) {
			System.out.println("sub is "+i+" total "+j+" loop");
		}
		isSub = false;
		this.notify();
	}
	
	public synchronized void main(int j){
		while(isSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 1; i <= 100; i++) {
			System.out.println("main is "+i+" total "+j+" loop");
		}
		isSub = true;
		this.notify();
	}
}
