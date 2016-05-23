package logistics.networkservice.implementation;

/**
 * This class represents the implementation of a Network Graph
 * whose Vertexes are Facilities and whose Edges represent the distance
 * between two Facilities.
 * 
 * It provides methods for adding new Facilities to the Graph, adding new
 * neighbors to those Facilities, and determining the distance between a 
 * Facility and its neighbor.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.networkservice.factory.FacilityVertexFactory;
import logistics.networkservice.interfaces.FacilityVertex;
import logistics.networkservice.interfaces.NetworkGraph;
import logistics.utilities.exceptions.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class NetworkGraphImpl implements NetworkGraph {

  private HashMap<String, FacilityVertex> facilityHashMap;

  /*
   * Creates a new Facility Network Graph.
   */
  public NetworkGraphImpl() {
    facilityHashMap = new HashMap<>();
  }

  /*
   * Adds a Facility to the Network Graph given the Facility's name.
   */
  public void addFacility(String facility) throws NullParameterException {
      validateFacility(facility);
      FacilityVertex facilityVertex = FacilityVertexFactory.build(facility);
      facilityHashMap.put(facility, facilityVertex);
  }

  /*
   * Adds a new Neighbor to a Facility given the Facility's name,
   * the Neighbor's name, and the Distance between them.
   */
  public void addNeighbor(String facility, String neighbor, int distance) throws FacilityNotFoundInNetworkException, NullParameterException, SelfLoopNetworkException, NegativeOrZeroParameterException {
      validateAddNeighbor(facility, neighbor);
      FacilityVertex facilityVertex = facilityHashMap.get(facility);
      facilityVertex.addNeighbor(neighbor, distance);
  }

  /*
   * Returns a list of all Neighbors of a Facility given the Facility's name.
   */
  public Iterator<String> neighbors(String facility) throws FacilityNotFoundInNetworkException {
    validateFacilityExists(facility);
    FacilityVertex facilityVertex = facilityHashMap.get(facility);
    return facilityVertex.neighbors();
  }

  /*
   * Returns the Distance between a Facility and its Neighbor given the
   * names both Facility and Neighbor.
   */
  public int distanceToNeighbor(String facility, String neighbor) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException {
    validateFacilityExists(facility);
    FacilityVertex facilityVertex = facilityHashMap.get(facility);
    return facilityVertex.distanceTo(neighbor);
  }

  /*
   * Returns True if a Facility is present in the 
   * Network Graph of Facilities, otherwise returns False.
   */
  public boolean contains(String facility) {
    return facilityHashMap.containsKey(facility);
  }

  /*
   * Returns a list of all Facilities present in the Network
   * Graph.
   */
  public Collection<String> vertices() {
    return new TreeSet<>(facilityHashMap.keySet());
  }

  /* 
   * Helper method that validates if a Facility is null.
   */
  private void validateFacility(String fac) throws NullParameterException {
    if (fac == null){
      throw new NullParameterException("Facility cannot be null");
    }
  }

  /*
   * Helper method that validates if a Facility exists in the Network Graph.
   */
  private void validateFacilityExists(String fac) throws FacilityNotFoundInNetworkException {
    if (!facilityHashMap.containsKey(fac)) {
      throw new FacilityNotFoundInNetworkException("Please add facility before add neighbors");
    };
  }

  /*
   * Helper method that validates if a Facility and its Neighbor are
   * in a Loop.
   */
  private void validateSelfLoop(String fac, String neighbor) throws SelfLoopNetworkException {
    if (fac.equals(neighbor)){
      throw new SelfLoopNetworkException("Facility cannot be neighbors to itself");
    }
  }

  /* 
   * Helper method that validates if a Facility, with the given Facility name,
   *  already exists in the Network Graph, and if it does not then is the given Facility
   *  in a Loop with the given Neighbor.
   */
  private void validateAddNeighbor(String facility, String neighbor) throws FacilityNotFoundInNetworkException, SelfLoopNetworkException {
    validateFacilityExists(facility);
    validateSelfLoop(facility, neighbor);
  }
}
