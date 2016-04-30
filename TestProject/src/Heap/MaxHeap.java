package Heap;

public class MaxHeap extends Heap{

	int maxHeapify(int cur)
	{
		while(cur!=0 && getParent(cur) < heap.get(cur))
		{
			swap(parentIndex(cur), cur);
			cur = parentIndex(cur);
		}
		
		return cur;
	}
	
	void insert(int[] a)
	{
		int index = heap.size() - 1;
		for(int i=0; i<a.length; i++)
		{
			heap.add(a[i]); index++;
			maxHeapify(index);
		}
	}
	
	boolean remove(int pos)
	{
		if(!validIndex(pos)) return false;
		if(pos == (heap.size()-1)) {
			heap.remove(pos);
			return true;
		}
		swap(pos, heap.size()-1);
		heap.remove(heap.size()-1);
		
		pos = maxHeapify(pos);
		siftDown(pos);
		return true;
	}
	
	void siftDown(int index) {

		int rightIndex, maxIndex; 
		
		while(getLeftIndex(index) < heap.size()) //leftIndex exists
		{
			maxIndex = getLeftIndex(index);
			rightIndex = getRightIndex(index);
			if(validIndex(rightIndex) && heap.get(rightIndex) > heap.get(maxIndex))
			{
				maxIndex = rightIndex;
			}
			
			if(heap.get(index) < heap.get(maxIndex)) swap(maxIndex, index);
			else break;
			
			index = maxIndex;
		}
	}

	int getKLargest(int k)
	{
		if(k > heap.size()) return -1;
		if(k == 1) return heap.get(0);
		remove(0);
		return getKLargest(k-1);
	}
	
	public static void main(String[] args) {

		int[] a = {1,2,3,4,5};
		MaxHeap obj = new MaxHeap();
		obj.insert(a);
		obj.remove(1);
	}

}
