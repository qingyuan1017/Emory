package graph.flow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import graph.Edge;
import graph.Graph;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MaximumFlowZhang extends MaximumFlow
{
	/**
	 * @param graph a graph.
	 * @param source the source vertex.
	 * @param target the target vertex.
	 * @return the maximum flow from the source to the target vertices.
	 */
	public MaxFlow getMaximumFlow(Graph graph, int source, int target)
	{
		MaxFlow mf = new MaxFlow(graph);
		List<Edge> path;
		double min;
		//System.out.println(graph.getAllEdges());

		while ((path = getPathDF(graph, mf, new ArrayList<Edge>(), new HashSet<Integer>(), source, target)) != null)
		{   
			min = getMin(mf, path);
			List<Edge> allEdges = graph.getAllEdges();

			for (Edge Edge1: allEdges){

				for(Edge Edge2 : path){
					if(Edge1.getSource() == Edge2.getTarget() && Edge2.getSource() == Edge1.getTarget())
						mf.updateResidual(Edge1, -min);
				}
			}

			mf.updateResidual(path, min);

		}

		return mf;
	}



	private double getMin(MaxFlow mf, List<Edge> path)
	{
		double min = mf.getResidual(path.get(0));
		int i, size = path.size();

		for (i=1; i<size; i++)
			min = Math.min(min, mf.getResidual(path.get(i)));

		return min;
	}

	private List<Edge> getPathDF(Graph graph, MaxFlow mf, List<Edge> path, Set<Integer> visited, int source, int target) 
	{
		if (source == target) return path;
		Set<Integer> set;
		List<Edge> list;

		for (Edge edge : graph.getIncomingEdges(target))
		{
			if (visited.contains(edge.getSource())) continue;	// cycle
			if (mf.getResidual(edge) <= 0) continue;			// no capacity
			list = new ArrayList<Edge>(path);
			set  = new HashSet<Integer>(visited);
			add(list, set, edge);

			list = getPathDF(graph, mf, list, set, source, edge.getSource());
			if (list != null) return list;
		}

		return null;
	}

	private void add(List<Edge> path, Set<Integer> visited, Edge edge)
	{
		path.add(edge);
		visited.add(edge.getSource());
	}


}