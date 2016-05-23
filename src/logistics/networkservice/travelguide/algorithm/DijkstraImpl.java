package logistics.networkservice.travelguide.algorithm;

/**
 * This class represents the Shortest path implementation for the Logistics 
 * application. The implementation is based on the Dijkstra algorithm used
 * for calculating the shortest path to a Facility in a Graph network of Facilities. 
 * 
 * @author Uchenna F. Okoye
 */

import logistics.networkservice.interfaces.NetworkGraph;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;
import java.util.*;

public class DijkstraImpl implements ShortestPathAlgorithm {

    private HashMap<String, Integer> dist;
    private HashMap<String, String> parentHash;
    private NetworkGraph graph;

    /*
     * Given a starting point in a given Network Graph computes the 
     * Shortest Path.
     */
    public DijkstraImpl(NetworkGraph g, String start) throws NullParameterException, FacilityNotFoundInNetworkException {
        validateGraph(g);
        validateVertexExists(g, start);
        dijkstra(g, start);
        graph = g;
    }

    /*
     * Returns a list of the Shortest Paths to a given Destination.
     * 
     */
    public Collection<String> shortestPathTo(String destination) throws FacilityNotFoundInNetworkException {
        validateVertexExists(graph, destination);
        Collection<String> path = recursivePathTo(destination, new ArrayList<>());
        if (path.isEmpty()){
            return null;
        }
        return path;
    }

    /*
     * Returns the Distance to a given Facility destination.
     * 
     */
    public int distanceTo(String destination) throws FacilityNotFoundInNetworkException {
        validateVertexExists(graph, destination);
        return dist.get(destination);
    }

    /*
     * Helper method that computes the Shortest Path given a Network 
     * Graph and a starting point on the graph.
     */
    private void dijkstra(NetworkGraph graph, String start) {

        try {
            dist = new HashMap<>();
            parentHash = new HashMap<>();
            Collection<String> vertices = graph.vertices();
            for (String vertex : vertices){
                dist.put(vertex, Integer.MAX_VALUE);
                parentHash.put(vertex, null);
            }

            dist.put(start, 0);
            PriorityQueue<String> queue = new PriorityQueue<>();
            queue.add(start);

            while (!queue.isEmpty()) {
                String parent = queue.poll();
                Iterator<String> adj = graph.neighbors(parent);
                while (adj.hasNext()) {

                    String neighbor = adj.next();

                    int newDistance = dist.get(parent) + graph.distanceToNeighbor(parent, neighbor);
                    int currentDistance = dist.get(neighbor);
                    if (currentDistance > newDistance){
                        dist.put(neighbor, newDistance);
                        parentHash.put(neighbor, parent);
                        queue.add(neighbor);
                    }

                }
            }
        } catch (FacilityNotFoundInNetworkException e) {
            e.printStackTrace();
        } catch (NeighborNotFoundInNetworkException e) {
            e.printStackTrace();
        }
    }

    /*
     * Helper method that recursively returns a list of paths to a given 
     * Facility given a collection of paths. 
     */
    private Collection<String> recursivePathTo(String facility, Collection<String> path){

        if (facility == null) {
            return path;
        }
        String parent = parentHash.get(facility);
        recursivePathTo(parent, path);
        path.add(facility);
        return path;
    }

    /*
     * Helper method that validates that a given Facility exists in the
     * Network Graph of Facilities.
     */
    private void validateVertexExists(NetworkGraph g, String facility) throws FacilityNotFoundInNetworkException {
        if (!g.contains(facility)) {
            throw new FacilityNotFoundInNetworkException();
        }
    }
    
    /*
     * Helper method that validates that a given Network Graph is not Null.
     */
    private void validateGraph(NetworkGraph g) throws NullParameterException {
        if (g == null){
            throw new NullParameterException("Graph cannot be null");
        }
    }
}
