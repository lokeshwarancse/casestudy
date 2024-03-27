package com.hexaware.entity;
import java.util.Date;


import java.util.*;
/**
 * Represents an incident entity.
 */
public class Incidents {
	public   int IncidentID;
	public   String IncidentType;
	private String IncidentDate;
	private double Latitude;
	private double Longitude;
	private String Description;
	private String Status;
	private int VictimID;
	private int SuspectID;
	private int AgencyID;
	/**
     * Constructs an Incident object with the specified parameters.
     *
     * @param IncidentID    The unique identifier of the incident.
     * @param IncidentType  The type of the incident.
     * @param IncidentDate  The date when the incident occurred.
     * @param Latitude      The latitude coordinate of the incident location.
     * @param Longitude     The longitude coordinate of the incident location.
     * @param Description   The description of the incident.
     * @param Status        The status of the incident.
     * @param VictimID      The ID of the victim involved in the incident.
     * @param SuspectID     The ID of the suspect involved in the incident.
     * @param AgencyID      The ID of the agency responsible for handling the incident.
     */
	public Incidents(int IncidentID, String IncidentType,String IncidentDate,
			double Latitude ,double Longitude, String Description,String Status,int VictimID,
			int SuspectID,int AgencyID) {
		super();
		this.IncidentID =IncidentID;
		this.IncidentType =IncidentType;
		this.IncidentDate = IncidentDate;
		this.Latitude=Latitude;
		this.Longitude=Longitude;
		this.Description=Description;
		this.Status=Status;
		this.VictimID=VictimID;
		this.SuspectID=SuspectID;
		this.AgencyID=AgencyID;
		
	}
	public   int getID() {
		return IncidentID;
	}
	public void setID(int IncidentID) {
		this.IncidentID = IncidentID;
	}
	
	public   String getType() {
		return IncidentType;
	}
	public void setType(String IncidentType) {
		this.IncidentType = IncidentType;
	}
	
	public String getDate() {
		return IncidentDate;
	}
	public void setDate(String IncidentDate) {
		this.IncidentDate = IncidentDate;
	}
	public double getLati() {
		return Latitude;
	}
	public void setLati(double Latitude) {
		this.Latitude = Latitude;
	}
	public double getLongi() {
		return Longitude;
	}
	public void setLongi(double Longitude) {
		this.Longitude = Longitude;
	}
	public String getDes() {
		return Description;
	}
	public void setDes(String Description) {
		this.Description = Description;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String Status) {
		this.Status = Status;
	}
	public int getVicID() {
		return VictimID;
	}
	public void setVicID(int VictimID) {
		this.VictimID = VictimID;
	}
	public int getSuspID() {
		return SuspectID;
	}
	public void setSuspID(int SuspectID) {
		this.SuspectID = SuspectID;
	}
	public int getAgencyID() {
		return AgencyID;
	}
	public void setAgencyID(int AgencyID) {
		this.AgencyID = AgencyID;
	}
	@Override
	public String toString() {
		return "Incidents [Id=" + IncidentID + ", Type=" + IncidentType + ", Date=" + IncidentDate + 
				",Latitude=" + Latitude +" ,Longitude=" + Longitude +",Description=" + Description +", status=" + Status +
						", victimID=" + VictimID + " SuspectID=" + SuspectID +"]";
	}
	
}
