package logistics.networkservice.shortestpath;

import logistics.networkservice.interfaces.NetworkGraph;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;

import java.util.*;

/**
 * Created by uchennafokoye on 5/2/16.
 */
public class DijkstraImpl implements ShortestPathStrategy
{
    private HashMap<String, Integer> dist;
    private HashMap<String, String> parentHash;
    private NetworkGraph netGraph;

    public NetworkGraph getNetGraph() 
    {
		return netGraph;
	}

	public void setNetGraph(NetworkGraph graph) 
	{
		netGraph = graph;
	}

	public DijkstraImpl(NetworkGraph graph, String start) throws NullParameterException, FacilityNotFoundInNetworkException 
    {
        validateGraph(graph);
        validateVertexExists(graph, start);
        dijkstra(graph, start);
        setNetGraph(graph);
    }

    public Collection<String> shortestPathTo(String destination) throws FacilityNotFoundInNetworkException 
    {
        validateVertexExists(getNetGraph(), destination);
        Collection<String> path = recursivePathTo(destination, new ArrayList<>());
        if (path.isEmpty())
        {
            return null;
        }
        return path;
    }

    public int distanceTo(String destination) throws FacilityNotFoundInNetworkException 
    {
        validateVertexExists(netGraph, destination);
        return dist.get(destination);
    }

    private void dijkstra(NetworkGraph graph, String start) 
    {
        try 
        {
            dist = new HashMap<>();
            parentHash = new HashMap<>();
            Collection<String> vertices = graph.vertices();
            for (String vertex : vertices)
            {
                dist.put(vertex, Integer.MAX_VALUE);
                parentHash.put(vertex, null);
            }

            dist.put(start, 0);
            PriorityQueue<String> queue = new PriorityQueue<>();
            queue.add(start);

            while (!queue.isEmpty()) 
            {
                String parent = queue.poll();
                Iterator<String> adj = graph.neighbors(parent);
                while (adj.hasNext()) 
                {
                    String neighbor = adj.next();

                    int newDistance = dist.get(parent) + graph.distanceToNeighbor(parent, neighbor);
                    int currentDistance = dist.get(neighbor);
                    if (currentDistance > newDistance)
                    {
                        dist.put(neighbor, newDistance);
                        parentHash.put(neighbor, parent);
                        queue.add(neighbor);
                    }
                }
            }

        } 
        catch (FacilityNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        } 
        catch (NeighborNotFoundInNetworkException e) 
        {
            e.printStackTrace();
        }
    }

    private Collection<String> recursivePathTo(String facility, Collection<String> path)
    {
        if (facility == null) 
        {
            return path;
        }
        String parent = parentHash.get(facility);
        recursivePathTo(parent, path);
        path.add(facility);

        return path;
    }

    private void validateVertexExists(NetworkGraph graph, String facility) throws FacilityNotFoundInNetworkException 
    {
        if (!graph.contains(facility)) 
        {
            throw new FacilityNotFoundInNetworkException("The Facility: " + facility + " cannot be found in the Network");
        }
    }

    private void validateGraph(NetworkGraph graph) throws NullParameterException 
    {
        if (graph == null)
        {
            throw new NullParameterException("Graph cannot be null");
        }
    }
}
