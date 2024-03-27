package com.hexaware.entity;

import java.util.List;
/**
 * The Evidence class represents evidence related to an incident.
 */
public class Evidence {
 private int EvidenceID; 
 private String Description;
 private String LocationFound;
 private int IncidentID; 

 /**
  * Constructs a new Evidence object with the specified parameters.
  * 
  * @param EvidenceID the ID of the evidence
  * @param Description the description of the evidence
  * @param LocationFound the location where the evidence was found
  * @param IncidentID the ID of the incident associated with the evidence
  */

public void createEvidence(int EvidenceID, String Description, String LocationFound, int IncidentID) {
     this.EvidenceID = EvidenceID;
     this.Description = Description;
     this.LocationFound = LocationFound;
     this.IncidentID = IncidentID;
 }

 
public void Evidence(int EvidenceID, String Description, String LocationFound, int IncidentID) {
    this.EvidenceID = EvidenceID;
    this.Description = Description;
    this.LocationFound = LocationFound;
    this.IncidentID = IncidentID;
}
/**
 * Retrieves the ID of the evidence.
 * 
 * @return the evidence ID
 */
 public int getEvidenceID() {
     return EvidenceID;
 }
 /**
  * Sets the ID of the evidence.
  * 
  * @param EvidenceID the evidence ID to set
  */

 public void setEvidenceID(int EvidenceID) {
     this.EvidenceID = EvidenceID;
 }
 /**
  * Retrieves the description of the evidence.
  * 
  * @return the evidence description
  */
 public String getDescription() {
     return Description;
 }
 /**
  * Sets the description of the evidence.
  * 
  * @param Description the evidence description to set
  */

 public void setDescription(String Description) {
     this.Description = Description;
 }
 /**
  * Retrieves the location where the evidence was found.
  * 
  * @return the location where the evidence was found
  */
 public String getLocationFound() {
     return LocationFound;
 }
 /**
  * Sets the location where the evidence was found.
  * 
  * @param LocationFound the location where the evidence was found to set
  */
 public void setLocationFound(String LocationFound) {
     this.LocationFound = LocationFound;
 }
 /**
  * Retrieves the ID of the incident associated with the evidence.
  * 
  * @return the incident ID associated with the evidence
  */
 public int getIncidentID() {
     return IncidentID;
 }
 /**
  * Sets the ID of the incident associated with the evidence.
  * 
  * @param IncidentID the incident ID associated with the evidence to set
  */
 public void setIncidentID(int IncidentID) {
     this.IncidentID = IncidentID;
 }
 /**
  * Returns a string representation of the evidence object.
  * 
  * @return a string representation of the evidence
  */
 @Override
 public String toString() {
     return "Evidence{" +
             "EvidenceID=" + EvidenceID +
             ", Description='" + Description + '\'' +
             ", LocationFound='" + LocationFound + '\'' +
             ", IncidentID=" + IncidentID +
             '}';
 }
 /**
  * Retrieves a list of all evidence.
  * 
  * @return a list of all evidence
  */
public static List<Evidence> getAllEvidence() {
	// TODO Auto-generated method stub
	return null;
}

}
