package com.qa.BlackJack;

import static org.junit.Assert.*;

import org.junit.Test;

public class blackJackTest {

	@Test
	public void test() {

		blackJack bljk = new blackJack();

		assertEquals("What do you mean?", 10, bljk.blackJack(10, 22));
		assertEquals("What do you mean?", 9, bljk.blackJack(22, 9));
		assertEquals("What do you mean?", 0, bljk.blackJack(22, 22));
		assertEquals("What do you mean?", 10, bljk.blackJack(10, 7));
		assertEquals("What do you mean?", 19, bljk.blackJack(1, 19));

	}

}