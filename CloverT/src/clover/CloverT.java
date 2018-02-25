package clover;

public class CloverT {
	public int a() {
		int a = 0;
		System.out.println("#CC# a 1");
		
		if(a != 0) {
			System.out.println("#CC# a 2");
		}
		
		if(a == 0) {
			System.out.println("#CC# a 3");
		}
		
		System.out.println("#CC# a 4");
		
		
		return b(a) + 1;
	}
	
	public int b(int a) {
		System.out.println("#CC# b 1");
		while(a < 4) {
			a++;
			System.out.println("#CC# b 2");
		}
		System.out.println("#CC# b 3");
		return 1;
	}
}
