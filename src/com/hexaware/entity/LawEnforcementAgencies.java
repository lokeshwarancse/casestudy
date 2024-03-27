package com.hexaware.entity;

import java.util.List;
/**
 * The LawEnforcementAgencies class represents a law enforcement agency entity.
 * It contains information such as agency ID, name, jurisdiction, contact information,
 * and a list of officers associated with the agency.
 */
public class LawEnforcementAgencies {
 private int AgencyID; 
 private String AgencyName;
 private String Jurisdiction;
 private String ContactInformation;
 private List<Officers> Officers; 
 /**
  * Constructs a LawEnforcementAgencies object with the specified parameters.
  * @param AgencyID The unique identifier for the agency.
  * @param AgencyName The name of the agency.
  * @param Jurisdiction The jurisdiction area covered by the agency.
  * @param ContactInformation The contact information of the agency.
  * @param Officers The list of officers associated with the agency.
  */
 public LawEnforcementAgencies(int AgencyID, String AgencyName, String Jurisdiction,
                               String ContactInformation, List<Officers> Officers) {
     this.AgencyID = AgencyID;
     this.AgencyName = AgencyName;
     this.Jurisdiction = Jurisdiction;
     this.ContactInformation = ContactInformation;
     this.Officers = Officers;
 }

 public int getAgencyID() {
     return AgencyID;
 }

 public void setAgencyID(int AgencyID) {
     this.AgencyID = AgencyID;
 }

 public String getAgencyName() {
     return AgencyName;
 }

 public void setAgencyName(String AgencyName) {
     this.AgencyName = AgencyName;
 }

 public String getJurisdiction() {
     return Jurisdiction;
 }

 public void setJurisdiction(String Jurisdiction) {
     this.Jurisdiction = Jurisdiction;
 }

 public String getContactInformation() {
     return ContactInformation;
 }

 public void setContactInformation(String ContactInformation) {
     this.ContactInformation = ContactInformation;
 }

 public List<Officers> getOfficers() {
     return Officers;
 }

 public void setOfficers(List<Officers> Officers) {
     this.Officers = Officers;
 }

 @Override
 public String toString() {
     return "LawEnforcementAgencies{" +
             "AgencyID=" + AgencyID +
             ", AgencyName='" + AgencyName + '\'' +
             ", Jurisdiction='" + Jurisdiction + '\'' +
             ", ContactInformation='" + ContactInformation + '\'' +
             ", Officers=" + Officers +
             '}';
 }
}
