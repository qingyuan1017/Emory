

import java.util.ArrayList;
import java.util.List;

public class ZhangSequence extends Sequence {
	List<String> l_words;
	 double  d_total;
	
	public ZhangSequence()
	{
		l_words = new ArrayList<>();
		d_total = 0;
	}
	
	public ZhangSequence(ZhangSequence sequence)
	{
		l_words = new ArrayList<>(sequence.l_words);
		d_total = sequence.d_total;
	}
	
	public void add(String word, double likelihood)
	{
		l_words.add(word);
		d_total += Math.log(likelihood);
	}
	
	public String getPreviousWord()
	{
		return l_words.isEmpty() ? null : l_words.get(l_words.size()-1);
	}
	
	public List<String> getSequence()
	{
		return l_words;
	}
	
	public double getMaximumLikelihood()
	{
		return d_total / l_words.size();
	}
	
	@Override
	public int compareTo(Sequence o)
	{
		return (int)Math.signum(getMaximumLikelihood() - o.getMaximumLikelihood()); 
	}
}
