package Tries;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import utils.StringUtils;



public class TrieRun
{
	private IAutocomplete<List<String>> t_auto;
	
	public TrieRun()
	{
		t_auto = new ZhangAutocomplete();
	}
	
	public void putDictionary(InputStream in) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		
		while ((line = reader.readLine()) != null)
			t_auto.put(line.trim(), null);
	}
	
	public void run() throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<String> candidates;
		String prefix, pick;
		
		do 
		{
			System.out.print("Enter a prefix: ");
			prefix = reader.readLine();
			
			// TODO: print out the top 10 candidates
			candidates = t_auto.getCandidates(prefix);
			if (candidates == null){
				candidates =  new ArrayList<>();
				candidates.add("no words found,but we put it in the trie");
				t_auto.put(prefix, new ArrayList<String>());
			}
			if(candidates.size()>=20)
				candidates=candidates.subList(0,20);
			
			System.out.println(StringUtils.join(candidates, "\n"));
			
			System.out.print("Pick: ");
			pick = reader.readLine();
			
			// TODO: update your Trie with this pick.
			t_auto.pickCandidate(prefix, pick);
			System.out.println("\""+pick+"\" is learned.\n");
		}
		while (true);
	}
	
	static public void main(String[] args) throws Exception
	{
		String dictFile = "/Users/Qingyuan/dict.txt";
		TrieRun tr = new TrieRun();
		
		tr.putDictionary(new FileInputStream(dictFile));
		tr.run();
	}
}
