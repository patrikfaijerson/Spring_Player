package com.example.inlupp3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.inlupp3.Book;

import org.junit.jupiter.api.Test;

class BookTest {

	/**
	 * Check that the isbn 10 chars is correct
	 */
	
	@Test
	void verifyIsbnTenDigitsIsOK() {
		Book book1 = new Book();
		boolean isIsbnOk = book1.checkIban("1234567890");
		assertTrue(isIsbnOk);
	}
	/**
	 * Check that the isbn 13 chars is correct
	 */
		@Test
		void verifyIsbnThirteenDigitsIsOK() {
			Book book1 = new Book();
			boolean isIsbnOk = book1.checkIban("1234567890123");
			assertFalse(isIsbnOk);
	
	}

	/**
	 * Check that the isbn 11 chars is not correct
	 */
	@Test
	void verifyIsbnElevenDigitsIsNotOK() {
		Book book1 = new Book();
		boolean isIsbnOk = book1.checkIban("12345678901");
		assertFalse(isIsbnOk);

}

}
