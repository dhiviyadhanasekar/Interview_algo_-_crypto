package Heap;

import java.util.ArrayList;

public class Heap {

	ArrayList<Integer> heap = new ArrayList<Integer>(); 
	
	int parentIndex(int index)	{
		return (index-1)/2;
	}
	
	int getParent(int index) 	{
		return heap.get(parentIndex(index));
	}
	
	int getLeftIndex(int index)	{
		return (2*index + 1);
	}
	
	int getRightIndex(int index)	{
		return (2*index + 2);
	}
	
	boolean validIndex(int index){
		return (index>=0 && index<heap.size()) ? true: false;
	}
	
	void swap(int index1, int index2) 	{
		int temp = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}
	
	void printHeap()
	{
		System.out.println(heap);
	}
	
}
