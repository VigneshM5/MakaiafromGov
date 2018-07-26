package tests;

import org.testng.annotations.Test;

public class SampleParallel1 {
	@Test
	public void multiply() {
		System.out.println("Multiply = "+4*12);
	}
	
	@Test
	public void divide() {
		System.out.println("Divide = "+12/4);
	}
}
