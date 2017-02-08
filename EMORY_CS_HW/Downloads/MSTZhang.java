package graph.span;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import utils.DSUtils;

public class MSTZhang implements MSTAll
{

	public SpanningTree getMinimumSpanningTree(Graph graph)
	{
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		SpanningTree tree = new SpanningTree();
		Set<Integer> set = new HashSet<>();
		Edge edge;
		
		add(queue, set, graph, 0);
		
		while (!queue.isEmpty())
		{
			edge = queue.poll();
			
			if (!set.contains(edge.getSource()))
			{
				tree.addEdge(edge);
				if (tree.size()+1 == graph.size()) break;
				add(queue, set, graph, edge.getSource());
			}
		}
		
		return tree;
	}
	
	private void add(PriorityQueue<Edge> queue, Set<Integer> visited, Graph graph, int target)
	{
		visited.add(target);
		for(Edge edge: graph.getIncomingEdges(target)){
			if(!visited.contains(edge.getSource())){
				queue.add(edge);
			}
		}
	}
	
	
	@Override
	public List<SpanningTree> getMinimumSpanningTrees(Graph graph) {
		List<SpanningTree> result = new ArrayList<SpanningTree>();
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		SpanningTree tree = new SpanningTree();
		Set<Integer> set = new HashSet<>();
		
		add(queue, set, graph, 0);
		getMinimumSpanningTreesAux(graph,tree,queue,set,result);
		
		
		
		return result;
		// TODO Auto-generated method stub
	}
	
	public void getMinimumSpanningTreesAux(Graph graph, SpanningTree tree,PriorityQueue<Edge> queue,Set<Integer> set,List<SpanningTree> trees){
		
		if (tree.size()+1 == graph.size()){
			trees.add(tree);
			
			return;
		}
		
		
		if(clean(queue,set)){
			return;
					}
		
		Edge edge;
		SpanningTree copytree;
		PriorityQueue<Edge> copyqueue;
		Set<Integer> copyset;
		
		
		do{
			
			edge = queue.poll();
			
			copytree = new SpanningTree(tree);
		   copyqueue = new PriorityQueue<Edge>(queue);
		    copyset = new HashSet<Integer>(set);
			copytree.addEdge(edge);
			add(copyqueue, copyset, graph, edge.getSource());
			getMinimumSpanningTreesAux(graph,copytree,copyqueue,copyset,trees);
			}
		
		
		while(!queue.isEmpty()&& edge.compareTo(queue.peek())==0);
		
	
			   
			   
			   
			
			
	}
	
	private boolean clean(PriorityQueue<Edge> queue,Set<Integer> set){
		List<Edge> remove = new ArrayList<Edge>();
		for(Edge edge: queue)
		{
			if(set.contains(edge.getSource()))
					remove.add(edge);		
		}
		 queue.removeAll(remove);
		 return queue.isEmpty();
	}


	
}