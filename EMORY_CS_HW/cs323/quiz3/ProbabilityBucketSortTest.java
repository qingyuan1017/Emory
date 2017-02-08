package sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import utils.DSUtils;



public class ProbabilityBucketSortTest
{
	@Test
	public void test()
	{
		final int ITERATIONS = 10;
		final int SIZE = 100;
		
		
	
		test(ITERATIONS, SIZE, new ProbabilityBucketSort());
		
	}
	
	void test(final int ITERATIONS, final int SIZE, AbstractSort<Double> engine)
	{
		final Random rand = new Random(0);
		Double[] original, sorted;
		
		for (int i=0; i<ITERATIONS; i++)
		{
			original =getRandomDoubleArray(rand, SIZE);
			sorted = Arrays.copyOf(original, SIZE);
			
			
			
			engine.sort(original);
			Arrays.sort(sorted);
		
			assertTrue(DSUtils.equals(original, sorted));
		}
	}
	
	
	
	static public Double[] getRandomDoubleArray(Random rand, int size)
	{
		Double[] array = new Double[size];
		
		for (int i=0; i<size; i++)
			array[i] = rand.nextDouble();
		
		return array;
	}
	
	

}
