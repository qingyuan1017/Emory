package sort;

import java.util.Arrays;

public class IntroSort<T extends Comparable<T>> extends AbstractSort<T>{



	public void sort(T[] array)
	{
		introSortLoop(array, 0, array.length-1, 2 * floor_lg(array.length));
	} 


	

	private  void introSortLoop(T[] array, int beginIndex, int endIndex, int depth_limit) {


		while(beginIndex < endIndex){

			if (depth_limit == 0)
			{
				T[] copy = Arrays.copyOfRange(array, beginIndex, endIndex);


				Heapsort(copy);


				for(int i= 0;i< copy.length;i++){

					array[i+beginIndex] = copy[i];
				}
				return;
			}

			else{
				depth_limit--;

				int middleIndex = partition(array, beginIndex, endIndex);

				introSortLoop(array, middleIndex+1, endIndex,depth_limit);

				endIndex = middleIndex;
			}
		}
	}


	
	private int partition(T[] array, int beginIndex, int endIndex)
	{
		int fst = beginIndex, snd = endIndex + 1;

		while (true)
		{
			while (compareTo(array, beginIndex, ++fst) >= 0 && fst < endIndex);		// fst > pivot
			while (compareTo(array, beginIndex, --snd) <= 0 && snd > beginIndex);	// snd < pivot
			if (fst >= snd) break;
			swap(array, fst, snd);
		}

		swap(array, beginIndex, snd);
		return snd;
	}


	public void Heapsort(T[] array)
	{
		int endIndex = array.length - 1;

		for (int k=getParentIndex(endIndex); k>=0; k--)
			sink(array, k, endIndex);

		while (endIndex > 0)
		{
			swap(array, 0, endIndex--);
			sink(array, 0, endIndex);
		}
	}

	private void sink(T[] array, int k, int endIndex)
	{
		for (int i=getLeftChildIndex(k); i<=endIndex; k=i,i=getLeftChildIndex(k))
		{
			if (i < endIndex && compareTo(array, i, i+1) < 0) i++;
			if (compareTo(array, k, i) >= 0) break;
			swap(array, k, i);
		}
	}

	private int getParentIndex(int k)
	{
		return (k+1)/2 - 1; 
	}

	private int getLeftChildIndex(int k)
	{
		return 2*k + 1;
	}


	private static int floor_lg(int a)
	{
		return (int)(Math.floor(Math.log(a)/Math.log(2)));
	}

}