package main.tagger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import main.feature.AbstractFeatureExtractor;
import main.feature.ZhangFeatureExtractor;
import main.perceptron.AbstractPerceptron;
import main.perceptron.SubgradientPerceptron;
import main.token.NERToken;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class ZhangNERecognizer extends AbstractNERecognizer
{	@Override
	public AbstractFeatureExtractor<NERToken> collect(InputStream in) throws Exception
	{
		AbstractFeatureExtractor<NERToken> extractor = new ZhangFeatureExtractor();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		List<NERToken> tokens;
		int i;
		
		while (!(tokens = getNERTokens(reader)).isEmpty())
		{
			for (i=0; i<tokens.size(); i++)
				extractor.collect(tokens, i);
		}
		
		in.close();
		return extractor;
	}
	@Override
	public void train(AbstractFeatureExtractor<NERToken> extractor, AbstractPerceptron perceptron, InputStream in) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		List<NERToken> tokens;
		NERToken token;
		int i, y;
		int[] x;
		
		while (!(tokens = getNERTokens(reader)).isEmpty())
		{
			for (i=0; i<tokens.size(); i++)
			{
				token = tokens.get(i);
				x = extractor.getFeatureIndices(tokens, i);
				y = extractor.getLabelIndex(token.getLabel());
				
				perceptron.train(x, y);
			}
		}
	}
	
	static public void main(String[] args) throws Exception
	{
		final String TRN_FILE = "C:\\Users\\Qingyuan\\workspace\\cs325\\src\\trn.ner";
		final String DEV_FILE = "C:\\Users\\Qingyuan\\workspace\\cs325\\src\\dev.ner";
		final double ALPHA = 0.000001;
		final int MAX_ITER = 50;
		
		ZhangNERecognizer ner = new ZhangNERecognizer();
		
		AbstractFeatureExtractor<NERToken> ex = ner.collect(new FileInputStream(TRN_FILE));
		AbstractPerceptron perceptron = new SubgradientPerceptron(ALPHA, ex.getFeatureSize(), ex.getLabelSize());
		double score;

		for (int i=0; i<MAX_ITER; i++)
		{
			ner.train(ex, perceptron, new FileInputStream(TRN_FILE));
			score = ner.evaluate(ex, perceptron, new FileInputStream(DEV_FILE));
			System.out.printf("%3d: %5.2f\n", i, score);
		}
	}
}