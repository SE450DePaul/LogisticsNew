package logistics.networkservice.implementation;

import logistics.networkservice.factory.FacilityVertexFactory;
import logistics.networkservice.interfaces.FacilityVertex;
import logistics.networkservice.interfaces.NetworkGraph;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;
import logistics.utilities.exceptions.SelfLoopNetworkException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by uchennafokoye on 4/29/16.
 */
public class NetworkGraphImpl implements NetworkGraph {

  private HashMap<String, FacilityVertex> facilityHashMap;



  public NetworkGraphImpl() {
    facilityHashMap = new HashMap<>();
  }

  @Override
  public void addFacility(String facility) throws NullParameterException {
      validateFacility(facility);
      FacilityVertex facilityVertex = FacilityVertexFactory.build(facility);
      facilityHashMap.put(facility, facilityVertex);
  }

  @Override
  public void addNeighbor(String facility, String neighbor, int distance) throws FacilityNotFoundInNetworkException, NullParameterException, SelfLoopNetworkException {
      validateAddNeighbor(facility, neighbor);
      FacilityVertex facilityVertex = facilityHashMap.get(facility);
      facilityVertex.addNeighbor(neighbor, distance);
  }

  @Override
  public Iterator<String> neighbors(String facility) throws FacilityNotFoundInNetworkException {
    validateFacilityExists(facility);
    FacilityVertex facilityVertex = facilityHashMap.get(facility);
    return facilityVertex.neighbors();
  }

  @Override
  public int distanceToNeighbor(String facility, String neighbor) throws FacilityNotFoundInNetworkException, NeighborNotFoundInNetworkException {
    validateFacilityExists(facility);
    FacilityVertex facilityVertex = facilityHashMap.get(facility);
    return facilityVertex.distanceTo(neighbor);
  }

  @Override
  public boolean contains(String facility) {
    return facilityHashMap.containsKey(facility);
  }

  @Override
  public Collection<String> vertices() {
    return new TreeSet<>(facilityHashMap.keySet());
  }

  private void validateFacility(String fac) throws NullParameterException {
    if (fac == null){
      throw new NullParameterException("Facility cannot be null");
    }
  }

  private void validateFacilityExists(String fac) throws FacilityNotFoundInNetworkException {
    if (!facilityHashMap.containsKey(fac)) {
      throw new FacilityNotFoundInNetworkException("Please add facility before add neighbors");
    };
  }

  private void validateSelfLoop(String fac, String neighbor) throws SelfLoopNetworkException {
    if (fac == neighbor){
      throw new SelfLoopNetworkException("Facility cannot be neighbors to itself");
    }
  }

  private void validateAddNeighbor(String facility, String neighbor) throws FacilityNotFoundInNetworkException, SelfLoopNetworkException {
    validateFacilityExists(facility);
    validateSelfLoop(facility, neighbor);
  }

}
