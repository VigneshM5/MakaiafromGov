package tests;

import org.testng.annotations.Test;

public class SampleParallel {
	@Test
	public void methodAdd() {
		System.out.println("Addition = "+(20+30));
	}
	
	@Test
	public void methodSub() {
		System.out.println("Subtraction = "+(30-10));
	}

}
