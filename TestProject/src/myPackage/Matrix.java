package myPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Matrix {

	
	public int[][] rotate90(int[][] matrix)
	{
		
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		int [][] res = new int[colLength][rowLength];
		int col=0;
		for(int i=rowLength-1; i>=0; i--, col++)
		{
			for(int j=0, row=0; j<colLength; j++, row++)
			{
				res[row][col] = matrix[i][j];
			}
		}
		return res;
	}
	
	
	private int[][] replaceRowCol0(int[][] matrix)
	{
		boolean[] rowsToSetZero = new boolean[matrix.length];
		boolean[] colsToSetZero = new boolean[matrix[0].length];
		
		int i,j;
		for(i = 0; i < matrix.length; i++)
		{
			for(j=0; j< matrix[i].length; j++)
			{
				if(matrix[i][j] == 0)
				{
					rowsToSetZero[i] = true;
					colsToSetZero[j] = true;
				}
			}
		}	
		
		
		for(i=0; i< rowsToSetZero.length; i++)
		{
			for(j=0; j< colsToSetZero.length; j++)
			{
				if(rowsToSetZero[i] && colsToSetZero[j])
				{
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}
	
	public void printMatrix(int[][] output){
		for(int i=0; i<output.length; i++){
			for(int j=0; j<output[i].length; j++){
				System.out.print(output[i][j]);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
	}
	public static void main(String[] args) {
		Matrix obj = new Matrix();
		int[][] test = {{1,2,3}, {6,5,4},{7,8,9}};
		int[][] output = obj.rotate90(test);		
		obj.printMatrix(output);
	}
}
