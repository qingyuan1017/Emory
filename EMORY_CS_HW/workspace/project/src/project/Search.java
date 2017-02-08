package project;

public class Search {
	private Node root;
	private class Node {
	        private String key;           
	        private Profile data;         
	        private Node left, right;  
public Node(String key, Profile data,int N) {
	            this.key = key;
	            this.data = data;	         
	        }

	    }


	public Search (){
	root = null;
	}

	 

	public  Profile find (String key){
	Node x  = root;
	while(x!=null){
	int cmp = key.compareTo(x.key);
	if (cmp <0) x=x.left;
	else if(cmp >0) x=x.right;
	else return x.data;
	}
	return null;
	}

	
	public void insert (Profile data){
	String key = data.Name;
	root = put(root,key,data);	 	
	}

	private Node put(Node x, String key, Profile data) {

	        if (x == null) return new Node(key, data, 1);
	        int cmp = key.compareTo(x.key);
	        if      (cmp < 0) x.left  = put(x.left,  key, data);
	        else if (cmp > 0) x.right = put(x.right, key, data);
	        else              x.data   = data;
	        return x;

	   

	}
}
