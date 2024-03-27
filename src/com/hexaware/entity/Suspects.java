package com.hexaware.entity;

import java.util.Date;
/**
 * The Suspects class represents information about suspects involved in incidents.
 * It includes attributes such as suspect ID, first name, last name, date of birth,
 * gender, and contact information.
 */
public class Suspects {
 private int SuspectID;
 private String FirstName;
 private String LastName;
 private Date DateOfBirth;
 private String Gender;
 private String ContactInformation; 
 /**
  * Constructs a Suspects object with the specified parameters.
  * @param SuspectID The unique identifier for the suspect.
  * @param FirstName The first name of the suspect.
  * @param LastName The last name of the suspect.
  * @param DateOfBirth The date of birth of the suspect.
  * @param Gender The gender of the suspect.
  * @param ContactInformation The contact information of the suspect.
  */
 public Suspects(int SuspectID, String FirstName, String LastName, Date DateOfBirth,
                String Gender, String ContactInformation) {
     this.SuspectID = SuspectID;
     this.FirstName = FirstName;
     this.LastName = LastName;
     this.DateOfBirth = DateOfBirth;
     this.Gender = Gender;
     this.ContactInformation = ContactInformation;
 }


 public int getSuspectID() {
     return SuspectID;
 }

 public void setSuspectID(int SuspectID) {
     this.SuspectID = SuspectID;
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

 public Date getDateOfBirth() {
     return DateOfBirth;
 }

 public void setDateOfBirth(Date DateOfBirth) {
     this.DateOfBirth = DateOfBirth;
 }


 public String getGender() {
     return Gender;
 }

 
 public void setGender(String Gender) {
     this.Gender = Gender;
 }


 public String getContactInformation() {
     return ContactInformation;
 }

 public void setContactInformation(String ContactInformation) {
     this.ContactInformation = ContactInformation;
 }

 @Override
 public String toString() {
     return "Suspect{" +
             "SuspectID=" + SuspectID +
             ", FirstName='" + FirstName + '\'' +
             ", LastName='" + LastName + '\'' +
             ", DateOfBirth=" + DateOfBirth +
             ", Gender='" + Gender + '\'' +
             ", ContactInformation='" + ContactInformation + '\'' +
             '}';
 }
}

