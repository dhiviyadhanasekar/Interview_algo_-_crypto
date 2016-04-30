package Dynamic;

import java.util.ArrayList;
import java.util.Comparator;

public class CakeThief {


	public ArrayList<Cake> steal(ArrayList<Cake> cakeList, int maxWt)
	{
		//Part 1: Sort the cakes according to their weights
		cakeList.sort(new Comparator<Cake>(){
			@Override
			public int compare(Cake c1, Cake c2) {
				return c1.weight - c2.weight;
			}
		});

		//Part 2: Computer max value for a given number of items in an array
		int[][] sack = new int[cakeList.size()+1][maxWt+1];
		for(int i= 0; i< cakeList.size()+1; i++)
		{
			for(int j= 0; j < maxWt+1; j++)
			{
				if(i==0 || j==0) sack[i][j] = 0;
				else 
				{
					int wt = cakeList.get(i-1).weight;
					if(wt <= j)
					{
						int price = cakeList.get(i-1).price;
						sack[i][j] = Math.max(price + sack[i][j-wt], sack[i-1][j]);
					}
					else sack[i][j] = sack[i-1][j];
				}
				System.out.print(sack[i][j]);
			}
			System.out.println();
		}

		//Part 3: see which cakes form the optimal solution
		ArrayList<Cake> result = new ArrayList<Cake>();
		int i = cakeList.size();
		int j = maxWt;
		while(i>= 1 && j>= 0)
		{
			if(sack[i][j] > sack[i-1][j])
			{
				result.add(cakeList.get(i-1));
				j = j - cakeList.get(i-1).weight;
			} 
			i = i-1;
		}
		return result;
	}

	public void printCakeArray(ArrayList<Cake> stolen)
	{
		for(int i= 0; i < stolen.size(); i++)
		{
			System.out.println("(" +  stolen.get(i).weight 
					+ ", " + stolen.get(i).price + ")");
		}
	}

	public static void main(String[] args) {
		ArrayList<Cake> cakeList = new ArrayList<Cake>();
		cakeList.add(new Cake(1,1));
		cakeList.add(new Cake(3,4));
		cakeList.add(new Cake(5,7));
		cakeList.add(new Cake(4,5));

		CakeThief thief = new CakeThief();
		ArrayList<Cake> stolen = thief.steal(cakeList, 7);
		thief.printCakeArray(stolen);
	}
}
