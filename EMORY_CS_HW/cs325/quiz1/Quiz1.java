package main.ngrams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import main.ngrams.smoothing.NoSmoothing;
import main.utils.IOUtils;;

public class Quiz1 {
	
	public static void main(String[] args) throws FileNotFoundException {
	
	Unigram unigram = new Unigram(new NoSmoothing());
	Bigram bigram = new Bigram(new NoSmoothing());

	
	IOUtils.readUnigrams(unigram, new FileInputStream("C:\\Users\\Qingyuan\\workspace\\cs325\\src\\main\\ngrams\\1grams.txt"));
	IOUtils.readBigrams (bigram , new FileInputStream("C:\\Users\\Qingyuan\\workspace\\cs325\\src\\main\\ngrams\\2grams.txt"));
	

	String[] w = {"he","came","to","my","school","to","study"};
	double p = 1;

	double [] prob = new double [7];
	
	 prob [0] = unigram.getLikelihood(w[0]);
	 
	 for (int i = 1; i <=6; i++){
		 
	 prob[i] = bigram.getLikelihood(w[i-1],w[i]);
	 
	 }
	 
	 for(int j = 0; j<=6;j++){
		 p = p * prob[j];
	 }
	
	// to be filled.    

	System.out.println(p);
	}

}
