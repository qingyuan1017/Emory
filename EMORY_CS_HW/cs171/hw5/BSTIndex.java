   /*

      THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING

      CODE WRITTEN BY OTHER STUDENTS. Qingyuan Zhang

      */
public class BSTIndex {

private Node root;

private class Node {

        private String key;           

        private MovieInfo data;         

        private Node left, right;  

                    


        public Node(String key, MovieInfo data, int N) {

            this.key = key;

            this.data = data;

            

        }

    }


public BSTIndex (){

root = null;

 

}

 

public MovieInfo findExact (String key){

Node x  = root;

while(x!=null){

int cmp = key.compareToIgnoreCase(x.key);

if (cmp <0) x=x.left;

else if(cmp >0) x=x.right;

else return x.data;

}

return null;

}

public MovieInfo findPrefix (String prefix){

Node x = root;

prefix = prefix.substring(0,prefix.indexOf('*'));

int n = prefix.length();

 

while(x!=null){

String c = x.key;

if(x.key.length()>n)	c = c.substring(0,n);

int cmp = prefix.compareToIgnoreCase(c);

if (cmp <0) x=x.left;

else if(cmp >0) x=x.right;

else return x.data;

}

return null;

}

 

 

public void insert (MovieInfo data){

String key = data.shortName;

root = put(root,key,data);

 

 

}

private Node put(Node x, String key, MovieInfo data) {

        if (x == null) return new Node(key, data, 1);

        int cmp = key.compareTo(x.key);

        if      (cmp < 0) x.left  = put(x.left,  key, data);

        else if (cmp > 0) x.right = put(x.right, key, data);

        else              x.data   = data;

        return x;

   

}


}
