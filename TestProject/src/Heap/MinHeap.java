package Heap;

public class MinHeap extends Heap{

	int minHeapify(int index)
	{
		while(index!=0 && getParent(index) > heap.get(index))
		{
			swap(parentIndex(index), index);
			index = parentIndex(index);
		}
		return index;
	}

	void insert(int[] input)
	{
		int index=heap.size() -1;
		for(int i=0; i<input.length; i++)
		{
			heap.add(input[i]); index++;
			minHeapify(index);
		}
	}

	void siftDown(int pos)
	{
		int minIndex, rightIndex;
		while(validIndex(getLeftIndex(pos)))
		{
			minIndex = getLeftIndex(pos);
			rightIndex = getRightIndex(pos);
			if(validIndex(rightIndex) && heap.get(rightIndex) < heap.get(minIndex))
			{
				minIndex = rightIndex;
			}
			if(heap.get(pos) > heap.get(minIndex))
			{
				swap(pos, minIndex);
				pos = minIndex;
			}
			else break;
		}
	}

	boolean remove(int pos)
	{
		if(!validIndex(pos)) return false;
		if(pos == (heap.size()-1)) {
			heap.remove(pos);
			return true;
		}
		swap(pos, heap.size() -1);
		heap.remove(heap.size()-1);
		pos = minHeapify(pos);
		siftDown(pos);
		return true;
	}
	
	int getKthMin(int k)
	{
		if(k > heap.size()) return -1;
		if(k == 1) return heap.get(0);
		remove(0);
		return getKthMin(k-1);
	}

	public static void main(String[] args) {

		int[] input = {4,6,10,9,8,1,0};
		MinHeap obj = new MinHeap();
		obj.insert(input);
		obj.printHeap();
//		obj.remove(6);
		System.out.println(obj.getKthMin(4));
	}

}
