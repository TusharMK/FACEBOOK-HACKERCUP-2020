//Actually this problem is solved by dynamic programming.I used a bruteforce method here...

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Timber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<Tree> list = new ArrayList<Tree>();
		for(int z = 1 ; z <= t ; z++ )
		{
			list.clear();
			int n = sc.nextInt();
			Tree tree;
			for(int i = 0 ; i < n ; i++ )
			{
				int p = sc.nextInt();
				int h = sc.nextInt();
				tree = new Tree(p,h);
				list.add(tree);
				
			}
			Collections.sort(list , new Comparator<Tree>() {

				@Override
				public int compare(Tree o1, Tree o2) {
					return o1.pos - o2.pos ;
				}
				
			});
			
			int max = 0;
			for(int i = 0 ; i < n ; i++ )
			{
				int h = list.get(i).height ;
				int p = list.get(i).pos;
				int f = forwardMax(list, p );
				int b = backwardMax(list, p);
				int f1 = h + checkForForward(list, p - h );
				int b1 = h + checkForBackward(list, p + h );
				int lh = Math.max(f1 + b, f +b1 );
				
				
				int[] temp = new int[3];
				temp[0] = f ;
				temp[1] = b ;
				temp[2] = h ;
				Arrays.sort(temp);
				max = Math.max(max, Math.max( lh , temp[1]+ temp[2]));
				
			}
			
			System.out.println("Case #" + z + ": "+max);
		}
		sc.close();
	}
	private static int checkForForward(List<Tree> list, int val) {
		
		int max = 0;
		int n = list.size();
		//checking forward
		for(int i = 0 ; i < n ; i++)
		{
			int len = 0;
			int j = i;
			while(j < n)
			{
				int h = list.get(j).height;
				int p = list.get(j).pos;
				len += h;
				int k;
				if(p + h == val )
				{
					max = Math.max(max, len);
				}
				
				for(k = j+1 ; k < n ; k++ )
				{
					int temp =list.get(k).pos;
					if(temp == p+h  )
					{
						j = k;
						break;
					}
				}
				if(k >= n)
				{
					j = n ;
				}
			}
			
		}
		return max;
	}
	private static int checkForBackward(List<Tree> list, int val) {
		int n = list.size();
		int max = 0;
		for(int i = n-1 ; i >= 0 ; i-- )
		{
			int len = 0;
			int j = i;
			while(j >= 0)
			{
				int h = list.get(j).height;
				int p = list.get(j).pos;
				len += h;
				if(p - h == val )
				{
					max = Math.max(max, len);
				}
				int k;
				for(k = j-1 ; k >= 0 ; k-- )
				{
					int temp =list.get(k).pos;
					if(temp == p-h)
					{
						j = k;
						break;
					}
				}
				if(k < 0)
				{
					j = -1 ;
				}
				
			}
		}
		return max;
	}
	private static int  backwardMax( List <Tree> list  , int position)
	{
		int max = 0;
		int n = list.size();
		//checking backward
		for(int i = n-1 ; i >= 0 ; i-- )
		{
			int len = 0;
			int j = i;
			
			while(j >= 0)
			{
				int h = list.get(j).height;
				int p = list.get(j).pos;
				len += h;
				int k;
				
				for(k = j-1 ; k >= 0 ; k-- )
				{
					int temp =list.get(k).pos;
					if(temp == p-h)
					{
						if(temp == position)
						{
							max = Math.max(max, len);
						}
						j = k;
						break;
					}
				}
				if(k < 0)
				{
					j = -1 ;
				}
			}
			
			
		}
		return max ;
	}
	
	private static int  forwardMax( List <Tree> list  , int position)
	{
		int max = 0;
		int n = list.size();
		//checking forward
		for(int i = 0 ; i < n ; i++)
		{
			int len = 0;
			int j = i;
			while(j < n)
			{
				int h = list.get(j).height;
				int p = list.get(j).pos;
				len += h;
				int k;
				
				for(k = j+1 ; k < n ; k++ )
				{
					int temp =list.get(k).pos;
					if(temp == p+h  )
					{
						if(temp == position)
						{
							max = Math.max(max, len);
						}
						j = k;
						break;
					}
				}
				if(k >= n)
				{
					j = n ;
				}
			}				
			
		}
			
	
		return max ;
	}


}



/*
ip : 

8
2
0 5
5 4
2
0 5
9 4
3
0 5
9 3
2 6
5
3 2
2 8
-4 5
8 5
1 4
6
-15 15
-9 9
-3 3
5 5
9 9
18 18
8
10 20
20 20
30 20
40 20
50 20
60 20
70 20
80 20
12
13 8
-14 5
2 19
33 10
-31 9
15 21
5 3
-22 16
-6 11
25 12
-40 24
21 18
2
-500000000 500000000
500000000 500000000






*/




