package clover;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import core.CodeCoverage;

class CloverTest {

	@Test
	void testA() {
		CodeCoverage cc = new CodeCoverage();
		CloverT c = new CloverT();
		assertEquals(c.a(),2);
		System.out.println("TESTA");
		for(String s : cc.getResult()) {
			System.out.println("Line "+s);
		}
		
	}

	@Test
	void testB() {
		CodeCoverage cc = new CodeCoverage();
		CloverT c = new CloverT();
		assertEquals(c.b(2),1);
		System.out.println("TESTB");
		for(String s : cc.getResult()) {
			System.out.println("Line "+s);
		}
	}

}
