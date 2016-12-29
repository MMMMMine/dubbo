package com.aust.boot;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {

	private static ClassPathXmlApplicationContext context;

	public static void main(String[] args) throws Exception {
		context = new ClassPathXmlApplicationContext(
				new String[] { "core/application-context.xml", "core/application-dubbo.xml" });
		context.start();
		System.out.println("dubbo提供方启动...");

		try {
			Object lock = new Object();
			synchronized (lock) {
				while (true) {
					lock.wait();
				}
			}
		} catch (InterruptedException ex) {
			System.out.println("ignore interruption");
		}
	}
}
