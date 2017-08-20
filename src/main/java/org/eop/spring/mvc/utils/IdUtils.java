package org.eop.spring.mvc.utils;

import java.util.Random;

/**
 * @author lixinjie
 * @since 2017-08-19
 */
public class IdUtils {

	public static Long getRandomUserId() {
		Long id = Math.abs(new Random().nextLong() % 10000);
		if (id < 1000) {
			return id + 1000;
		}
		return id;
	}
	
	public static void main(String[] args) {
		System.out.println(getRandomUserId());
		System.out.println(getRandomUserId());
		System.out.println(getRandomUserId());
		System.out.println(getRandomUserId());
	}
}
