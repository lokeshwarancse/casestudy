package com.hexaware.entity;

/**
 * The Officers class represents a law enforcement officer entity.
 * It contains information such as officer ID, first name, last name, badge number,
 * rank, contact information, and the agency ID to which the officer belongs.
 */
public class Officers {
 private int OfficerID; 
 private String FirstName;
 private String LastName;
 private String BadgeNumber;
 private String Rank;
 private String ContactInformation;
 private int AgencyID; 
 /**
  * Constructs an Officers object with the specified parameters.
  * @param OfficerID The unique identifier for the officer.
  * @param FirstName The first name of the officer.
  * @param LastName The last name of the officer.
  * @param BadgeNumber The badge number of the officer.
  * @param Rank The rank of the officer.
  * @param ContactInformation The contact information of the officer.
  * @param AgencyID The ID of the agency to which the officer belongs.
  */
 public Officers(int OfficerID, String FirstName, String LastName, String BadgeNumber,
                 String Rank, String ContactInformation, int AgencyID) {
     this.OfficerID = OfficerID;
     this.FirstName = FirstName;
     this.LastName = LastName;
     this.BadgeNumber = BadgeNumber;
     this.Rank = Rank;
     this.ContactInformation = ContactInformation;
     this.AgencyID = AgencyID;
 }

 public int getOfficerID() {
     return OfficerID;
 }

 public void setOfficerID(int OfficerID) {
     this.OfficerID = OfficerID;
 }

 public String getFirstName() {
     return FirstName;
 }

 public void setFirstName(String FirstName) {
     this.FirstName = FirstName;
 }

 public String getLastName() {
     return LastName;
 }

 public void setLastName(String LastName) {
     this.LastName = LastName;
 }

 public String getBadgeNumber() {
     return BadgeNumber;
 }

 public void setBadgeNumber(String BadgeNumber) {
     this.BadgeNumber = BadgeNumber;
 }

 public String getRank() {
     return Rank;
 }

 public void setRank(String Rank) {
     this.Rank = Rank;
 }

 public String getContactInformation() {
     return ContactInformation;
 }

 public void setContactInformation(String ContactInformation) {
     this.ContactInformation = ContactInformation;
 }

 public int getAgencyID() {
     return AgencyID;
 }

 public void setAgencyID(int AgencyID) {
     this.AgencyID = AgencyID;
 }

 @Override
 public String toString() {
     return "Officers{" +
             "OfficerID=" + OfficerID +
             ", FirstName='" + FirstName + '\'' +
             ", LastName='" + LastName + '\'' +
             ", BadgeNumber='" + BadgeNumber + '\'' +
             ", Rank='" + Rank + '\'' +
             ", ContactInformation='" + ContactInformation + '\'' +
             ", AgencyID=" + AgencyID +
             '}';
 }
}
