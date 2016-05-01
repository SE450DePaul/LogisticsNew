package logistics.networkservice.implementation;

import logistics.networkservice.factory.FacilityVertexFactory;
import logistics.networkservice.interfaces.FacilityVertex;
import logistics.networkservice.interfaces.NetworkGraph;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.SelfLoopNetworkException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by uchennafokoye on 4/29/16.
 */
public class NetworkGraphImpl implements NetworkGraph {

  private Collection<String> facilities;
  private HashMap<String, FacilityVertex> facilityHashMap;



  public NetworkGraphImpl() {
    facilities = new ArrayList<>();
    facilityHashMap = new HashMap<>();
  }

  @Override
  public void addFacility(String facility) throws IllegalParameterException {
      validateFacility(facility);
      FacilityVertex facilityVertex = FacilityVertexFactory.build(facility);
      facilityHashMap.put(facility, facilityVertex);
  }

  @Override
  public void addNeighbor(String facility, String neighbor, int distance) throws FacilityNotFoundInNetworkException, IllegalParameterException, SelfLoopNetworkException {
      validateAddNeighbor(facility, neighbor);
      FacilityVertex facilityVertex = facilityHashMap.get(facility);
//      FacilityVertex neighborVertex = facilityHashMap.get(neighbor);
      facilityVertex.addNeighbor(neighbor, distance);
//      neighborVertex.addNeighbor(facility, distance);
  }

  @Override
  public Iterator<String> neighbors(String facility) {
    FacilityVertex facilityVertex = facilityHashMap.get(facility);
    return facilityVertex.neighbor();
  }

  @Override
  public int distanceToNeighbor(String facility, String neighbor) throws FacilityNotFoundInNetworkException {
    validateFacilityExists(facility);
    FacilityVertex facilityVertex = facilityHashMap.get(facility);
    return facilityVertex.distanceTo(neighbor);
  }

  @Override
  public int noOfVertices() {
    return 0;
  }

  private void validateFacility(String fac) throws IllegalParameterException {
    if (fac == null){
      throw new IllegalParameterException("Facility cannot be null");
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
//    validateFacilityExists(neighbor);
    validateSelfLoop(facility, neighbor);
  }

}
