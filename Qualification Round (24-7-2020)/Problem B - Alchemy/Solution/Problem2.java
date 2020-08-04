import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int z = 1 ; z <= t ; z++ )
		{
			int n = sc.nextInt();
			String s = sc.next();
			int a = 0;
			System.out.print("Case #" + z + ": ");
			for(int i = 0 ; i < n ; i++ )
			{
				char ch = s.charAt(i);
				if(ch == 'A')
					a++;
				if(ch == 'B')
					a--;
				
			}
			if(a < 3 && a > -3 )
				System.out.println("Y");
			else
				System.out.println("N");
			
		}
		sc.close();
	}

}


/*
ip : 


6
3
BAB
3
BBB
5
AABBA
7
BAAABAA
11
BBBAABAAAAB
11
BABBBABBABB


*/
