package Tries;

import java.util.ArrayList;
import java.util.List;


public class ZhangAutocomplete extends Trie<List<String>> implements IAutocomplete<List<String>>
{



	public List<String> put(String words, List<String> value)
	{
		char[] array = words.toCharArray();
		
		TrieNode<List<String>> node = getRoot();

		for (int i=0; i<words.length() ; i++)
		{
			value = new ArrayList<String>();
			node = node.addChild(array[i]);

			if (!node.hasValue())
				node.setValue(value);

			List<String> copy = node.getValue();

			copy.add(words);
			node.setValue(copy);

		}

		return node.getValue();
	}


	@Override
	public List<String> getCandidates(String prefix) 
	{
		
		return get(prefix);

	}


	@Override
	public void pickCandidate(String prefix, String candidate) {
		// TODO Auto-generated method stub
		if (this.getCandidates(prefix).contains(candidate))
		{
			

			int index = this.getCandidates(prefix).indexOf(candidate);
			this.getCandidates(prefix).add(0,candidate);
			this.getCandidates(prefix).remove(index+1);
		} else 
		{
			int condition = 0;

			if (prefix.length() > candidate.length())
			{    
				condition = 1;
			} else
			{    
				for (int j=0; j < prefix.length(); j++)
				{
					if (prefix.charAt(j) != candidate.charAt(j))
						condition = 1;
				}    
			}

			if(condition == 1)
			{
				

				

				this.put(candidate, new ArrayList<String>());


				this.getCandidates(prefix).add(0,candidate);


			} else
			{    
				

				this.put(candidate, new ArrayList<String>());

				int index = this.getCandidates(prefix).indexOf(candidate);
				this.getCandidates(prefix).add(0,candidate);
				this.getCandidates(prefix).remove(index+1);
			}    
		}
	}
}
