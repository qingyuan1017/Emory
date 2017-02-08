package span;

import java.util.ArrayList;
import java.util.List;
import graph.Edge;
import utils.MathUtils;
/**
* @author Jinho D. Choi ({@code jinho.choi@emory.edu})
*/
public class SpanningTree
{
private List<Edge> l_edges;
private double d_weight;
public SpanningTree()
{
l_edges = new ArrayList<>();
}
public int size()
{
return l_edges.size();
}
public double getTotalWeight()
{
return d_weight;
}
public void addEdge(Edge edge)
{
l_edges.add(edge);
d_weight += edge.getWeight();
}
@Override
public String toString()
{
StringBuilder build = new StringBuilder();
int size = MathUtils.getMaxBit(size());
for (Edge edge : l_edges)
build.append(String.format("\n%"+size+"d <- %"+size+"d : %f", edge.getTarget(), edge.getSource(), edge.getWeight()));
return build.substring(1);
}
}