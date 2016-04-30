package myPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class TestClass {


	final static List<MyModel> modelList = new ArrayList<MyModel>();

	static MyModel studentRecord;

	private static void init () {

		for(int id=0; id < 10; id++)
		{
			studentRecord = new MyModel("dd" + id, id);
			modelList.add(studentRecord);
		}
	}

	List<Integer> syncList = new ArrayList<Integer>();

	public enum e {
		mon {
			public String toString()
			{
				return "MON";
			};
		}, tues, wed;
	}

	public <T> void print(T temp)
	{
		System.out.println(temp);
	}

	static void quickSort(int[] a, int low, int high)
	{
		if(low < high)
		{
			int pivot = partition(a, low, high);
			quickSort(a, low, pivot-1);
			quickSort(a, pivot+1, high);
		}
	}
	
	private static int partition(int[] a, int low, int high) {
		
		int p = a[high];
		int m = low;
		
		for(int i = low; i<=high-1 ; i++)
		{
			if(a[i] < p)
			{
//				m++;
				swap(a,m++, i);
			}
			System.out.println("iteration " + i + ": " +Arrays.toString(a));
		}
		swap(a, m, high);
		System.out.println("Before sending pivot: " +Arrays.toString(a));
		System.out.println("pivot: " + (m+1));
		return (m);
	}

	private static void swap(int[] a, int m, int i) {
		int temp = a[m];
		a[m] = a[i];
		a[i] = temp;
	}

	static void quickSortTest()
	{
		int[] a = {7, 5, 6, 8, 1, 2, 4, 3}; 
		System.out.println("Before sort:" + Arrays.toString(a));
		int low = 0;
		int high = a.length - 1;
		quickSort(a, low, high);
		System.out.println("After sort:" + Arrays.toString(a));
	}
	public static void main(String[] args) throws IOException {

//		quickSortTest();
		testSort();
	}

	
	
	static void testSort()
	{
		Integer[] a = {55,2,39}; //a.length
		List<Integer> list = Arrays.asList(a);
		
		Iterator<Integer> test = list.iterator();
	Collections.sort(list);
//		list.sort(new Comparator<Integer>(){
//
//			public int compare(Integer o1, Integer o2) {
//			
//				return o1-o2;
//			}
//			
//		});
		System.out.println(list);
		
		
		System.out.println("ab".compareTo("ba"));
		System.out.println("b".compareTo("a"));
		System.out.println("Dhiviya".compareTo("Sujan"));
	}
	void testGenerics()
	{
		int i = 10;
		new TestClass().print(i);
	}
	void testEnum()
	{
		e day = e.mon;
		System.out.println(day.toString());
	}

	void testStack()
	{
		int[] arr = {0,10,123,0123};
		//		Vector<Integer> v = new Vector<Integer>(arr);
		//		v.addAll();
		List<Integer> aList = new ArrayList<Integer>();

		Stack s = new Stack();
		s.push(42);
		int a = (int) s.pop();
		System.out.println(a);
		System.out.println("another pop = " + s.pop());
	}

	void testInheritance()
	{
		InheritedModel m = new InheritedModel();
	}
	void testArrays()
	{
		int[] arr = new int[]{1,0,10};
		int[] arr1 = {1,2,3};

		List<Integer> intList = Arrays.asList(1,6,7,8,8);
		intList.forEach(System.out::println);

		int [] arr2 = new int[10];
		Arrays.fill(arr2, 100);
	}
	void testThreads()
	{
		MyThread t1 = new MyThread("Thread 1");
		t1.start();
	}
	public static void testCode()
	{
		//		MyModel temp = new MyModel();
		//		System.out.println(temp.toString());
		final int arr[] = new int[11];
		//		arr[1] = 0;

		testArray(arr);

		System.out.println(arr[1]);
	}
	public static void testArray(int[] arr)
	{
		arr = new int[10];
		arr[2] =1;
		System.out.println("new= " + arr[2]);
	}

	public void splitStrings()
	{

		String temp = "abc-pqr-bfjhbr-knfjwnje";
		String[] splitStrings = temp.split("-");
		for(int i = 0; i < splitStrings.length; i++)
		{
			System.out.println(splitStrings[i]);
		}
	}


	public void scannerSplit()
	{
		String temp = "abc-pqr";
		Scanner s = new Scanner(temp);
		s.useDelimiter("-");
		while(s.hasNext())
		{
			System.out.println(s.next());
		}
		s.close();
	}

	public void readUsingScanner() throws FileNotFoundException
	{
		//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("Output.txt"));
		String a;

		while(sc.hasNextLine())
		{
			a = sc.nextLine();
			System.out.println("Got = " + a);
		};
		sc.close();
	}

	public void writeOrAppend()
	{
		init();

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter("file.txt", true);
			bufferedWriter = new BufferedWriter(fileWriter);

			for(MyModel model : modelList)
			{
				bufferedWriter.write(model.toString());
				bufferedWriter.newLine();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{

			if(bufferedWriter != null)
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			if(fileWriter!=null)
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


		}
	}

	public void writeToNewFile()
	{


		File outputFile = new File("Output.txt");
		PrintWriter fileWriter = null; 

		try 
		{

			//			if(!outputFile.exists()) 
			//			{
			//				throw new FileNotFoundException("File doesn't exist");
			//			}

			fileWriter = new PrintWriter(outputFile);

			for(MyModel model : modelList)
			{
				fileWriter.println(model.toString());
			}


		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(fileWriter != null)
			{
				fileWriter.close();
			}
		}

		System.out.println(outputFile.getAbsolutePath());
	}

}
