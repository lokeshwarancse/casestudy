package com.hexaware.entity;

import java.util.Date;
/**
 * The Reports class represents a report entity associated with an incident.
 * It contains information such as report ID, incident ID, reporting officer,
 * report date, report details, and status.
 */
public class Reports {
 private int ReportID; 
 private int IncidentID; 
 private String ReportingOfficer; 
 private Date ReportDate;
 private String ReportDetails;
 private String Status; 
 /**
  * Constructs a Reports object with the specified parameters.
  * @param ReportID The unique identifier for the report.
  * @param IncidentID The ID of the incident associated with the report.
  * @param ReportingOfficer The name or ID of the reporting officer.
  * @param ReportDate The date when the report was created.
  * @param ReportDetails The details or description provided in the report.
  * @param Status The status of the report.
  */

 public Reports(int ReportID, int IncidentID, String ReportingOfficer, Date ReportDate,
                String ReportDetails, String Status) {
     this.ReportID = ReportID;
     this.IncidentID = IncidentID;
     this.ReportingOfficer = ReportingOfficer;
     this.ReportDate = ReportDate;
     this.ReportDetails = ReportDetails;
     this.Status = Status;
 }

 public int getReportID() {
     return ReportID;
 }

 public void setReportID(int ReportID) {
     this.ReportID = ReportID;
 }

 public int getIncidentID() {
     return IncidentID;
 }

 public void setIncidentID(int IncidentID) {
     this.IncidentID = IncidentID;
 }

 public String getReportingOfficer() {
     return ReportingOfficer;
 }

 public void setReportingOfficer(String ReportingOfficer) {
     this.ReportingOfficer = ReportingOfficer;
 }

 public Date getReportDate() {
     return ReportDate;
 }

 public void setReportDate(Date ReportDate) {
     this.ReportDate = ReportDate;
 }

 public String getReportDetails() {
     return ReportDetails;
 }

 public void setReportDetails(String ReportDetails) {
     this.ReportDetails = ReportDetails;
 }

 public String getStatus() {
     return Status;
 }

 public void setStatus(String Status) {
     this.Status = Status;
 }

 @Override
 public String toString() {
     return "Reports{" +
             "ReportID=" + ReportID +
             ", IncidentID=" + IncidentID +
             ", ReportingOfficer=" + ReportingOfficer +
             ", ReportDate=" + ReportDate +
             ", ReportDetails='" + ReportDetails + '\'' +
             ", Status='" + Status + '\'' +
             '}';
 }
}
