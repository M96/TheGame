package main;

public class Map {

	boolean taken[][];
	
	Map()
	{
		taken = new boolean[5000][5000];
		for(int i = 0; i < 5000;i++)
		{
			for(int j = 0; j <5000;j++)
			{
				taken[i][j] = false;
			}
		}
	}
}
