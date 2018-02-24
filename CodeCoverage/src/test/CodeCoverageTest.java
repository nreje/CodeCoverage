package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import core.CodeCoverage;

class CodeCoverageTest {
	
	@Test
	void testRedirectErrorStream() {
		System.err.println("ERROR 1");
		System.err.println("#CC# 2");
		CodeCoverage cc = new CodeCoverage();
		System.err.println("ERROR 3");
		System.err.println("#CC# 4");
		cc.resetErrorStream();
	}

	@Test
	void testGetResult() {
		System.err.println("#CC# HMM?");
		CodeCoverage cc = new CodeCoverage();
		System.err.println("#CC# 2");
		System.err.println("#CC# 67");
		
		for(String s : cc.getResult()) {
			System.out.println("Line "+s);
		}
		//cc.resetErrorStream();
	}

	@Test
	void testResetErrorStream() throws InterruptedException {
		System.err.println("#CC# 66");
		CodeCoverage cc = new CodeCoverage();
		System.err.println("#CC# 2");
		cc.resetErrorStream();
		System.err.println("#CC# 3");
	}

}
