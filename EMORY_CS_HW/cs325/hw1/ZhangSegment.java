

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.ngrams.Bigram;
import main.ngrams.Unigram;
import main.ngrams.model.ILanguageModel;


public class ZhangSegment extends AbstractSegment
{

	Unigram z_unigram;
	Bigram z_bigram;
	public ZhangSegment(ILanguageModel model,Unigram unigram,Bigram bigram)
	{
		super(model);
		z_unigram = unigram;
		Bigram z_bigram;
	}

	@Override
	public ZhangSequence segment(String s)
	{
		List<ZhangSequence> list = new ArrayList<>();

		segmentAux(list, s, 0, new ZhangSequence());
		for(ZhangSequence i:list){

			int count =0;
			List<String> words = i.getSequence();
			for(int j=0; j<words.size()-1;j++){
				String string1 =words.get(j);
				String string2 = words.get(j+1);
				
				if(l_model.getLikelihood(string1,string2)>0.0001){
					count ++;
				}
			}
			if(count==0){
				//System.out.println(i.getSequence()+"aa");

				i.d_total = i.d_total*1000;
				//System.out.println(i.d_total);

				//System.out.println(i.d_total+"aa");
			}	
			else if(count>0){
				
				
				double x = count;
				double y = words.size();
				
				//System.out.println(y/x);
				//System.out.println(i.d_total*(count/words.size()));

				i.d_total= i.d_total*(y/x);
				
				//System.out.println(i.d_total+"bb");
			}

		}
		
		System.out.println(l_model.getLikelihood("oi","she"));
		return Collections.max(list);
	}

	private void segmentAux(List<ZhangSequence> list, String s, int beginIndex, ZhangSequence sequence)
	{
		if (beginIndex == s.length())
		{
			list.add(sequence);
			return;
		}
        if(sequence.d_total<-15){
        	return;
        }

		String word1= sequence.getPreviousWord();
		int endIndex, len = s.length();
		double likelihood;
		ZhangSequence copy;
		String word2;
		
		for (endIndex=beginIndex+1; endIndex<=len; endIndex++)
		{

            
			word2 = s.substring(beginIndex, endIndex);
			if(z_unigram.getLikelihood(word2)>0.0000004){
				
				
				copy = new ZhangSequence(sequence);
				copy.add(word2, 5);
				segmentAux(list, s, endIndex, copy);
			}
			
			
			
			likelihood = l_model.getLikelihood(word1, word2);
			copy = new ZhangSequence(sequence);
			copy.add(word2, likelihood);

			segmentAux(list, s, endIndex, copy);
		}
	}
	

}
