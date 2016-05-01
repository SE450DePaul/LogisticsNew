package logistics.networkservice.implementation;

import logistics.facilityservice.Facility;
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

  private Collection<Facility> facilities;
  private HashMap<Facility, FacilityVertex> facilityHashMap;



  public NetworkGraphImpl() {
    facilities = new ArrayList<>();
    facilityHashMap = new HashMap<>();
  }

  @Override
  public void addFacility(Facility facility) throws IllegalParameterException {
      validateFacility(facility);
      FacilityVertex facilityVertex = FacilityVertexFactory.build(facility);
      facilityHashMap.put(facility, facilityVertex);
  }

  @Override
  public void addNeighbor(Facility facility, Facility neighbor, int distance) throws FacilityNotFoundInNetworkException, IllegalParameterException, SelfLoopNetworkException {
      validateAddNeighbor(facility, neighbor);
      FacilityVertex facilityVertex = facilityHashMap.get(facility);
      FacilityVertex neighborVertex = facilityHashMap.get(neighbor);
      facilityVertex.addNeighbor(neighbor, distance);
      neighborVertex.addNeighbor(facility, distance);
  }

  @Override
  public Iterator<Facility> neighbors(Facility facility) {
    FacilityVertex facilityVertex = facilityHashMap.get(facility);
    return facilityVertex.neighbor();
  }

  @Override
  public int distanceToNeighbor(Facility facility, Facility neighbor) throws FacilityNotFoundInNetworkException {
    validateFacilityExists(facility);
    FacilityVertex facilityVertex = facilityHashMap.get(facility);
    return facilityVertex.distanceTo(neighbor);
  }

  @Override
  public int noOfVertices() {
    return facilities.size();
  }

  private void validateFacility(Facility fac) throws IllegalParameterException {
    if (fac == null){
      throw new IllegalParameterException("Facility cannot be null");
    }
  }

  private void validateFacilityExists(Facility fac) throws FacilityNotFoundInNetworkException {
    if (!facilityHashMap.containsKey(fac)) {
      throw new FacilityNotFoundInNetworkException("Please add facility before add neighbors");
    };
  }

  private void validateSelfLoop(Facility fac, Facility neighbor) throws SelfLoopNetworkException {
    if (fac == neighbor){
      throw new SelfLoopNetworkException("Facility cannot be neighbors to itself");
    }
  }

  private void validateAddNeighbor(Facility facility, Facility neighbor) throws FacilityNotFoundInNetworkException, SelfLoopNetworkException {
    validateFacilityExists(facility);
    validateFacilityExists(neighbor);
    validateSelfLoop(facility, neighbor);
  }

}
