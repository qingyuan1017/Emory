package main.feature;


import java.util.ArrayList;
import java.util.List;

import main.token.NERToken;


public class ZhangFeatureExtractor extends AbstractFeatureExtractor<NERToken>
{
	@Override
	public List<StringFeature> getStringFeatures(List<NERToken> tokens, int index)
	{
		List<StringFeature> features = new ArrayList<>();

		// current word form
		features.add(new StringFeature("f0", tokens.get(index).getWord()));
		
		// previous label
		if (index-1 >= 0)
			features.add(new StringFeature("f1", tokens.get(index-1).getLabel()));
		
		if (index-2 >= 0)
			features.add(new StringFeature("f2", tokens.get(index-2).getLabel()));
		
		if (index-3 >= 0)
			features.add(new StringFeature("f3", tokens.get(index-3).getWord()));
		
		if (index-4 >= 0)
			features.add(new StringFeature("f4", tokens.get(index-4).getWord()));
		
		if (index-5 >= 0)
			features.add(new StringFeature("f5", tokens.get(index-5).getWord()));
		
		if (index-6 >= 0)
			features.add(new StringFeature("f6", tokens.get(index-6).getWord()));
		
		if (index-7 >= 0)
			features.add(new StringFeature("f7", tokens.get(index-7).getWord()));
		
		
		if (index+1 < tokens.size())
			features.add(new StringFeature("f8", tokens.get(index+1).getWord()));
		
		if (index+2 < tokens.size())
			features.add(new StringFeature("f9", tokens.get(index+2).getWord()));
		
		if (index+3 < tokens.size())
			features.add(new StringFeature("f10", tokens.get(index+3).getWord()));
		
		// current position
		features.add(new StringFeature("f10", tokens.get(index).getPOSTag()));
		
		if (index-1 >= 0)
			features.add(new StringFeature("f11", tokens.get(index-1).getPOSTag()));
		
		if (index-2 >= 0)
			features.add(new StringFeature("f12", tokens.get(index-2).getPOSTag()));
		
		if (index-3 >= 0)
			features.add(new StringFeature("f13", tokens.get(index-3).getPOSTag()));
		
		
		if (index+1 < tokens.size())
			features.add(new StringFeature("f14", tokens.get(index+1).getPOSTag()));
		
		if (index+2 < tokens.size())
			features.add(new StringFeature("f15", tokens.get(index+2).getPOSTag()));
		
		if (index+3 < tokens.size())
			features.add(new StringFeature("f16", tokens.get(index+3).getPOSTag()));
		
		
				
		return features;
	}
}