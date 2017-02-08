package main.tagger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.utils.DSUtils;
import main.classifier.AbstractClassifier;
import main.classifier.Prediction;
import main.classifier.StringFeature;

public class QingTagger extends AbstractTagger {

	final int k;

	public QingTagger(AbstractClassifier classifier, int k)
	{
		super(classifier);
		this.k = k;
	}

	@Override
	public List<TagList> decode(List<String> words)
	{
		TagList tags = new TagList();

		List<StringFeature> features;
		int i, size = words.size();

		for (i=0; i<size; i++)
		{
			features = getFeatures(words, tags, i);
			tags.add(Collections.max(classifier.predict(features)));
		}

		List<TagList> list = new ArrayList<>(1);
		list.add(tags);
		return list;
	}


	protected List<StringFeature> getFeatures(List<String> words, TagList tags, int index)
	{
		List<StringFeature> features = new ArrayList<>();
		String t;

		// current word form
		String curr = null;
		curr = words.get(index);
		features.add(new StringFeature("f0", curr));
		// current word form
		features.add(new StringFeature("f1", words.get(index)));

		// next word

		String next = null;
		if(index+1 < words.size()) next = words.get(index+1);
		features.add(new StringFeature("f"+(1+1), next));

		// prev  word

		String prev = null;
		if(index-1 > 0) prev = words.get(index-1-1);
		if(prev!=null)features.add(new StringFeature("f1"+1, prev));



		// previous  tag

		t = (index-1 < 0) ? null : tags.getTag(index-1);
		features.add(new StringFeature("f" +(2+1+1), t));



		// numbers
		Boolean b1 = words.get(index).matches(".*\\d+.*");
		features.add(new StringFeature("f43", b1.toString()));

		// upper case
		Boolean b2 = (words.get(index).charAt(0) >= 'A' && words.get(index).charAt(0) <= 'Z');
		features.add(new StringFeature("f44", b2.toString()));

	

		// common suffixes
		Boolean b4 = words.get(index).matches(".*ing");
		features.add(new StringFeature("f46", b4.toString()));

		Boolean b5 = words.get(index).matches(".*ed");
		features.add(new StringFeature("f47", b5.toString()));

		b5 = words.get(index).matches(".*en");
		features.add(new StringFeature("f48", b5.toString()));

		b5 = words.get(index).matches(".*er");
		features.add(new StringFeature("f49", b5.toString()));

		b5 = words.get(index).matches(".*est");
		features.add(new StringFeature("f50", b5.toString()));

		b5 = words.get(index).matches(".*ful");
		features.add(new StringFeature("f51", b5.toString()));

		b5 = words.get(index).matches(".*ness");
		features.add(new StringFeature("f52", b5.toString()));

		b5 = words.get(index).matches(".*able");
		features.add(new StringFeature("f53", b5.toString()));

		b5 = words.get(index).matches(".*ment");
		features.add(new StringFeature("f54", b5.toString()));

		b5 = words.get(index).matches(".*less");
		features.add(new StringFeature("f55", b5.toString()));

		b5 = words.get(index).matches(".*tion");
		features.add(new StringFeature("f56", b5.toString()));

		b5 = words.get(index).matches(".*es");
		features.add(new StringFeature("f57", b5.toString()));

		b5 = words.get(index).matches(".*ly");
		features.add(new StringFeature("f58", b5.toString()));

		b5 = words.get(index).matches(".*s");
		features.add(new StringFeature("f59", b5.toString()));

		b5 = words.get(index).matches(".*al");
		features.add(new StringFeature("f60", b5.toString()));

		b5 = words.get(index).matches(".*ism");
		features.add(new StringFeature("f61", b5.toString()));

		b5 = words.get(index).matches(".*ty");
		features.add(new StringFeature("f62", b5.toString()));

		b5 = words.get(index).matches(".*ive");
		features.add(new StringFeature("f63", b5.toString()));

		b5 = words.get(index).matches(".*ous");
		features.add(new StringFeature("f64", b5.toString()));


		// common prefixes

		Boolean b6 = words.get(index).matches("anti+.*");
		features.add(new StringFeature("f70", b6.toString()));

		b6 = words.get(index).matches("de+.*");
		features.add(new StringFeature("f71", b6.toString()));

		b6 = words.get(index).matches("dis+.*");
		features.add(new StringFeature("f72", b6.toString()));

		b6 = words.get(index).matches("en+.*");
		features.add(new StringFeature("f73", b6.toString()));

		b6 = words.get(index).matches("fore+.*");
		features.add(new StringFeature("f74", b6.toString()));

		b6 = words.get(index).matches("in+.*");
		features.add(new StringFeature("f75", b6.toString()));

		b6 = words.get(index).matches("mid+.*");
		features.add(new StringFeature("f76", b6.toString()));

		b6 = words.get(index).matches("mis+.*");
		features.add(new StringFeature("f77", b6.toString()));

		b6 = words.get(index).matches("non+.*");
		features.add(new StringFeature("f78", b6.toString()));

		b6 = words.get(index).matches("over+.*");
		features.add(new StringFeature("f79", b6.toString()));

		b6 = words.get(index).matches("pre+.*");
		features.add(new StringFeature("f80", b6.toString()));

		b6 = words.get(index).matches("re+.*");
		features.add(new StringFeature("f81", b6.toString()));

		b6 = words.get(index).matches("semi+.*");
		features.add(new StringFeature("f82", b6.toString()));

		b6 = words.get(index).matches("sub+.*");
		features.add(new StringFeature("f83", b6.toString()));

		b6 = words.get(index).matches("un+.*");
		features.add(new StringFeature("f84", b6.toString()));

		b6 = words.get(index).matches("trans+.*");
		features.add(new StringFeature("f85", b6.toString()));
		return features;
	}
}
