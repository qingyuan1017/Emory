package graph;

public class Edge implements Comparable<Edge>
{
private int i_source;
private int i_target;
private double d_weight;
public Edge(int source, int target, double weight)
{
setSource(source);
setTarget(target);
setWeight(weight);
}
public int getSource()
{
return i_source;
}
public int getTarget()
{
return i_target;
}
public double getWeight()
{
return d_weight;
}
public void setSource(int vertex)
{
i_source = vertex;
}
public void setTarget(int vertex)
{
i_target = vertex;
}
public void setWeight(double weight)
{
d_weight = weight;
}
@Override
public int compareTo(Edge edge)
{
double diff = d_weight - edge.d_weight;
if (diff > 0)	return 1;
else if (diff < 0)	return -1;
else	return 0;
}
}