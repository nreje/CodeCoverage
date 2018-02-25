package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import core.CodeCoverage;

class CodeCoverageTest {
	
	@Test
	void testRedirectErrorStream() {
		System.out.println("ERROR 1");
		System.out.println("#CC# 2");
		CodeCoverage cc = new CodeCoverage(null);
		System.out.println("ERROR 3");
		System.out.println("#CC# 4");
		cc.resetOutputStream();
	}

	@Test
	void testGetResult() {
		System.out.println("#CC# HMM?");
		CodeCoverage cc = new CodeCoverage(null);
		System.out.println("#CC# 2");
		System.out.println("#CC# 67");
		
		for(String s : cc.getResult()) {
			System.out.println("Line "+s);
		}
		System.out.println("#CC# HMM2?");
	}

	@Test
	void testResetErrorStream() throws InterruptedException {
		System.out.println("#CC# 66");
		CodeCoverage cc = new CodeCoverage(null);
		System.out.println("#CC# 2");
		cc.resetOutputStream();
		System.out.println("#CC# 3");
	}
	
	@Test
	void testWriteToFile() throws IOException {
		CodeCoverage cc = new CodeCoverage("testFile.txt");
		System.out.println("#CC# testLine");
		cc.writeToFile("TestMethod");
	}

}
