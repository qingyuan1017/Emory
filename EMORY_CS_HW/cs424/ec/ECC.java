/*
Then program need a input file for the pyB language and a test file for the test String whether it is accept by the PDA
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.*;





	public class ECC {

		public static Stack<String> PDAstack = new Stack<String>();

		public static ArrayList<String> variables = new ArrayList<String>();

		
		
		public static HashMap<String, ArrayList<String>> table = new HashMap<String,ArrayList<String>>();



		public static ArrayList<String> tokens;

		public static void main(String [] args) throws IOException{



			FileInputStream file = new FileInputStream("CFG.txt");
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(file));

			String line = keyboard.readLine();
			StringTokenizer st = new StringTokenizer(line," ");

			String start = st.nextToken();
			PDAstack.push("$");
			PDAstack.push(start);

			FileInputStream testfile = new FileInputStream("token.txt");
			BufferedReader testReader = new BufferedReader(new InputStreamReader(testfile));


			tokens = settoken();
			setEntry();			
			transformtable();
			String token = testReader.readLine();
			
			//System.out.println(tokens);
			//System.out.println(table);
			while(true){
				//System.out.println(PDAstack);
				//System.out.println("Token ="+ token);
				
				String top = PDAstack.pop();
				//System.out.println("top ="+ top);
				if (top.equals("$")){
					System.err.println("Accept");
					break;}
				if(token == null){
					System.err.println("Error! Cannot identify this language");
					break;
				}
	
				
				Entry entry =  lookup(token,top);
				//System.out.println("e_change"+entry.e_change);
				//System.out.println(entry.e_action);
				if(entry == null){
					System.err.println("Error! Cannot identify this language");
					break;
				}
				else{
					if(entry.e_change != null){
					Stack<String> copy =StringtoStack(entry.e_change);
					//System.out.println(copy);
					PDAstack.addAll(copy);
					
					}
					//System.out.println(entry.e_action);
					
					if(Entry.e_action == true){
						//System.out.println(entry.e_action);
						//System.out.println("aa");
						token = testReader.readLine();
						//System.out.println(token);
						}
				}
				//System.out.println(token);

			}
	
		

		}



		public static ArrayList<String> settoken() throws IOException{

			FileInputStream file = new FileInputStream("CFG.txt");
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(file));

			String line = null;


			ArrayList<String> variableterminals = new ArrayList<String>();

			while ((line = keyboard.readLine()) != null) {


				StringTokenizer st = new StringTokenizer(line," ");

				String variable = st.nextToken();

				if(!variables.contains(variable)){
					variables.add(variable);
				}

				String rule = st.nextToken();

				while(st.hasMoreTokens()){
					String v = st.nextToken();
					if(!variableterminals.contains(v)){
						variableterminals.add(v);
					}

				}


			}

			variableterminals.removeAll(variables);

			//System.out.println(variables);





			return variableterminals;


		}


		public static void setEntry() throws IOException{

			FileInputStream file = new FileInputStream("CFG.txt");
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(file));

			String line = null;


			while ((line = keyboard.readLine()) != null) {

				StringTokenizer st = new StringTokenizer(line," ");

				String variable = st.nextToken();

				String rule = st.nextToken();

				StringBuilder add = new StringBuilder(); 

				while(st.hasMoreTokens()){

					add.append(st.nextToken()+ " ");

				}
				
				if(table.containsKey(variable)){
					ArrayList<String> right = table.get(variable);
					right.add(add.toString());
					table.put(variable,right);
					
					
				}
				
				else{
					ArrayList<String> right = new ArrayList<String>();
					right.add(add.toString());
					table.put(variable,right);
				}


			}

		}
		
		
		public static void transformtable(){
			
			
			Set<String> variable = table.keySet();
			
			
			for(String v : variable){
				ArrayList<String> right = table.get(v);
				for(int i=0;i< right.size();i++){
					String r = right.get(i);
					StringTokenizer st = new StringTokenizer(r," ");
					
					String firstC = st.nextToken();
					String left = null;
					while(st.hasMoreTokens()){
						if(left == null)
							left = st.nextToken()+" ";
						else
						left = left+st.nextToken()+" ";
					}
					//System.err.println(left);
					
					if(variables.contains(firstC)){
						
						ArrayList<String> update = search(firstC);
						ArrayList<String> copy = new ArrayList<String>(update);
						
						right.remove(r);
						for(int j =0; j< update.size();j++){
							String rf = update.get(j);
							
							copy.remove(rf);
						
							if(left != null){
								rf = rf+left;
							}
							//System.err.println(rf);
							copy.add(rf);
						}
						//System.err.println(copy);
						right.addAll(copy);
					}
					
				}
				
				table.put(v,right);
				//System.out.println(table);
			}
			
			
		}
		
		
		public static ArrayList<String> search(String v){
			//System.out.println(v);
			ArrayList<String> next = table.get(v);
			//System.out.println(next);
			for(int i=0;i< next.size();i++){
				String x = next.get(0);
				
				StringTokenizer st = new StringTokenizer(x," ");
				
				String firstC = st.nextToken();
				
				String left = null;
				
				while(st.hasMoreTokens()){
					if(left == null)
						left = st.nextToken()+" ";
					else
					left = left+st.nextToken()+" ";
				}
				
				
				
				if(variables.contains(firstC)){
					ArrayList<String> update = search(firstC);
					ArrayList<String> copy = new ArrayList<String>(update);
					next.remove(x);
				
				
				for(int j =0; j< update.size();j++){
					String rf = update.get(j);
					
					copy.remove(rf);
				
					if(left != null){
						rf = rf+left;
					}
					
					copy.add(rf);
				}
				
				next.addAll(copy);
				}
				
			}
			return next;
			
			
			
		}


	
		public static Entry lookup(String token, String top){

			boolean b = false;
			
			ArrayList<String> replacement = table.get(top);
			
			if(tokens.contains(top)){
				Pattern p;
				
				if(top.equals("(")){
					p = Pattern.compile("\\(");
				}
				else if(top.equals(")")){
					p = Pattern.compile("\\)");

				}
				else if(top.equals("{")){
					p = Pattern.compile("\\{");

				}

				else if(top.equals("}")){
					p = Pattern.compile("\\}");

				}
				else{
					p = Pattern.compile(top);
				}
				Matcher m = p.matcher(token);
				b = m.matches();
				
				if(b == true){
					//System.out.println(token);
					Entry result = new Entry(null,true);
							return result;
				}
				
				
				
			}
			else{

			for(int i = 0; i< replacement.size(); i++){
				//System.out.println(replacement.get(i));
				String x =  replacement.get(i);
				StringTokenizer st = new StringTokenizer(x," ");
				
				String y = st.nextToken();
				
				Pattern p;
				if(y.equals("(")){
					
					//p = Pattern.compile(tokens.get(i).replace("(", "\\("));
					p = Pattern.compile("\\(");
					
				}
				else if(y.equals(")")){
					p = Pattern.compile("\\)");

				}
				else if(y.equals("{")){
					p = Pattern.compile("\\{");

				}

				else if(y.equals("}")){
					p = Pattern.compile("\\}");

				}
				else{
					p = Pattern.compile(y);
				}
				Matcher m = p.matcher(token);
				b = m.matches();
				//System.out.println(b);

				if(b == true){
					//System.out.println(x);
					Entry result = new Entry(x,false);
							return result;
				}

			}
			
			
			
			}


			return null;



		}
		
		public static Stack<String> StringtoStack (String s){
			ArrayList<String> copy = new ArrayList<String>();
			Stack<String> replacement = new Stack<String>();
			StringTokenizer st = new StringTokenizer(s," ");
			while(st.hasMoreTokens()){
				copy.add(st.nextToken());		
			}
			for(int i = copy.size()-1; i>=0;i--){
				replacement.push(copy.get(i));
			}
			
			return replacement;
			
		}



	}


