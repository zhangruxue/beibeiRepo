package com.xianghuangqi.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
public class CalTest {

	@Test
	public void testAdd() {
//	 assertEquals(7, new Cal().add(1, 7));
		int result = new Cal().add(1, 7);
//		assertEquals("不相等", 7, result);
		assertTrue(result > 5);
		assertThat(result, is(8));
	}
	
	@Test(expected=java.lang.ArithmeticException.class,timeout=1200)
	public void testDivide(){
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = new Cal().divide(8, 0);
	}
	

}
