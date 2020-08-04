import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int z = 1 ; z <= t ; z++)
		{
			
			int n = sc.nextInt();
			String in = sc.next();
			String out = sc.next();
				
			System.out.println("Case #"+ z + ":");	
			for(int i = 0 ; i < n  ; i++ )
			{
				char[] arr = new char[n];
				arr[i] = 'Y';
				boolean right = true;
				boolean left = true ;
				for(int j = i+1 ; j < n ; j++)
				{
					if(right && out.charAt(j-1) == 'Y' && in.charAt(j) == 'Y'  )
					{
						arr[j] = 'Y' ;
					}
					else
					{
						arr[j]='N';
						right = false;
					}
				}
				for(int j = i-1 ; j >= 0 ; j--)
				{
					if(left && out.charAt(j+1) == 'Y' && in.charAt(j) == 'Y'  )
					{
						arr[j] = 'Y' ;						
					}
					else
					{
						arr[j]='N';
						left = false;
					}
					
				}
				System.out.println(arr);
			}
		}
		sc.close();
	}

}


/*
ip :-


5
2
YY
YY
2
NY
YY
2
NN
YY
5
YNNYY
YYYNY
10
NYYYNNYYYY
YYNYYNYYNY

*/
