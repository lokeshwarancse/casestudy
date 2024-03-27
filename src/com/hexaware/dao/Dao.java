package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.hexaware.controller.Controller;
import com.hexaware.myexceptions.IncidentNumberNotFoundException;
import com.hexaware.util.DBUtil;
import com.hexaware.entity.*;
/**
 * The Dao class provides methods to interact with the database for Incidents and Reports.
 */
public class Dao {
	
	static Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	private List<Incidents> availableIncidents;
	 /**
     * Adds an incident to the database.
     *
     * @param incident The incident to add
     * @throws SQLException if a database access error occurs
     */
	public void addIncident(Incidents Incidents) throws IncidentNumberNotFoundException, SQLException {
		con = DBUtil.getDBConn();
        String query = "INSERT INTO Incidents (IncidentID, IncidentType, IncidentDate,Latitude,Longitude,Description, Status, VictimID, SuspectID, AgencyID) VALUES (?, ?, ?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = con.prepareStatement(query)) {
        	statement.setInt(1, Incidents.getID());
            statement.setString(2, Incidents.getType());
            statement.setString(3, Incidents.getDate());
            statement.setDouble(4, Incidents.getLati());
            statement.setDouble(5, Incidents.getLongi());
            statement.setString(6, Incidents.getDes());
            statement.setString(7, Incidents.getStatus());

            
        	statement.setInt(8, Incidents.getVicID());
        	statement.setInt(9, Incidents.getSuspID());
        	statement.setInt(10, Incidents.getAgencyID());


            

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new incident was added!");
            }
        }
    }
	 /**
     * Removes an incident from the database.
     * 
     * @param id The ID of the incident to remove
     * @throws SQLException if a database access error occurs
     */
	public void removeInci(String id) throws SQLException {
		con = DBUtil.getDBConn();
        String query = "DELETE FROM Incidents WHERE IncidentID = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The name was removed!");
            }
        }
    }
	
	 /**
     * Retrieves a list of all available incidents from the database.
     * 
     * @return A list of available incidents
     * @throws SQLException if a database access error occurs
     */


public List<Incidents> listAvailable() throws SQLException {
	con = DBUtil.getDBConn();
    List<Incidents> availableIncidents = new ArrayList<>();
    String query = "SELECT * FROM Incidents ";
    try (PreparedStatement statement = con.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
            Incidents incident = new Incidents(resultSet.getInt("IncidentID"), resultSet.getString("IncidentType"), resultSet.getString("IncidentDate"), resultSet.getDouble("Latitude"), resultSet.getDouble("Longitude"), resultSet.getString("Description"), resultSet.getString("Status"), resultSet.getInt("VictimID"), resultSet.getInt("SuspectID"), resultSet.getInt("AgencyID"));
            incident.setID(resultSet.getInt("IncidentID"));
            incident.setType(resultSet.getString("IncidentType"));
            incident.setDate(resultSet.getString("IncidentDate"));
            incident.setLati(resultSet.getDouble("Latitude"));
            incident.setLongi(resultSet.getDouble("Longitude"));
            incident.setDes(resultSet.getString("Description"));
            incident.setStatus(resultSet.getString("Status"));
            incident.setVicID(resultSet.getInt("VictimID"));
            incident.setSuspID(resultSet.getInt("SuspectID"));
            incident.setAgencyID(resultSet.getInt("AgencyID"));
            
            availableIncidents.add(incident);
        }
    }
    return availableIncidents;
}
/**
 * Searches for an incident by its ID in the database.
 * 
 * @param incidentID The ID of the incident to search for
 * @return The incident with the specified ID, or null if not found
 * @throws SQLException if a database access error occurs
 */

	public static Incidents searchIncidentByID(int incidentID) throws SQLException {
 Incidents incident = null;
 con = DBUtil.getDBConn();
 String query = "SELECT * FROM Incidents WHERE IncidentID = ?";
 try (PreparedStatement statement = con.prepareStatement(query)) {
     statement.setInt(1, incidentID);
     try (ResultSet resultSet = statement.executeQuery()) {
         if (resultSet.next()) {
             incident = new Incidents(resultSet.getInt("IncidentID"),
                                      resultSet.getString("IncidentType"),
                                      resultSet.getString("IncidentDate"),
                                      resultSet.getDouble("Latitude"),
                                      resultSet.getDouble("Longitude"),
                                      resultSet.getString("Description"),
                                      resultSet.getString("Status"),
                                      resultSet.getInt("VictimID"),
                                      resultSet.getInt("SuspectID"),
                                      resultSet.getInt("AgencyID"));
         }
     }
 }
 return incident;
	}
	
	 /**
     * Generates a list of reports for a given incident from the database.
     * 
     * @param incident The incident for which reports are to be generated
     * @return A list of reports related to the incident
     * @throws SQLException if a database access error occurs
     */
	 public List<Reports> generateIncidentReport(Incidents incident)throws SQLException {
	        List<Reports> reports = new ArrayList<>();

	        try {
	            // Define the SQL query to retrieve incident report data
	            String sql = "SELECT * FROM reports WHERE IncidentID = ?";
	            
	            // Create a PreparedStatement
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            
	            // Set the incident ID parameter
	            preparedStatement.setInt(1, incident.getID());
	            
	            // Execute the query
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            // Iterate through the result set and map each row to a Report object
	            while (resultSet.next()) {
	                int reportId = resultSet.getInt("ReportID");
	                // Retrieve other report attributes similarly
	                
	                // Create a Report object
	                Reports report = new Reports(resultSet.getInt("ReportID"),
                            resultSet.getInt("IncidentID"),
                            resultSet.getString("ReportingOfficer"),
                            resultSet.getDate("ReportDate"),
                            resultSet.getString("ReportDetails"),
                            resultSet.getString("Status"));
	               
	                
	                // Add the report to the list
	                reports.add(report);
	            }
	            
	            // Close the resources
	            resultSet.close();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace(); // Handle the exception properly
	        }

	        return reports;
	    }
	 
	 public void addCase(Case newCase) throws SQLException {
	        con = DBUtil.getDBConn();
	        String query = "INSERT INTO Cases (CaseDescription) VALUES (?)";
	        try (PreparedStatement statement = con.prepareStatement(query)) {
	            statement.setString(1, newCase.getCaseDescription());
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("A new case was added!");
	            }
	        }
	    }
	 public Case getCaseById(int caseID) {
		    Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    Case caseObj = null;

		    try {
		        con = DBUtil.getDBConn();
		        String query = "SELECT * FROM Case1 WHERE CaseID = ?";
		        ps = con.prepareStatement(query);
		        ps.setInt(1, caseID);
		        rs = ps.executeQuery();

		        if (rs.next()) {
		            int retrievedCaseId = rs.getInt("CaseID");
		            String caseDescription = rs.getString("CaseDescription");
		            // Assuming you have a method to retrieve incidents associated with a case
		            Collection<Incidents> incidents = getIncidentsForCase(retrievedCaseId);
		            caseObj = new Case(retrievedCaseId, caseDescription, incidents);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace(); // Handle the exception properly
		    } finally {
		        // Close resources
		        try {
		            if (rs != null) {
		                rs.close();
		            }
		            if (ps != null) {
		                ps.close();
		            }
		            if (con != null) {
		                con.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace(); // Handle the exception properly
		        }
		    }

		    return caseObj;
		}
	 public Collection<Incidents> getIncidentsForCase(int caseId) throws SQLException {
		    Collection<Incidents> incidents = new ArrayList<>();
		    String query = "SELECT * FROM Incidents WHERE CaseID = ?";
		    try (PreparedStatement statement = con.prepareStatement(query)) {
		        statement.setInt(1, caseId);
		        try (ResultSet resultSet = statement.executeQuery()) {
		            while (resultSet.next()) {
		                // Retrieve incident details and create Incidents objects
		                int incidentId = resultSet.getInt("IncidentID");
		                String incidentType = resultSet.getString("IncidentType");
		                // Populate other incident attributes similarly
		                Incidents incident = new Incidents(resultSet.getInt("IncidentID"), resultSet.getString("IncidentType"), resultSet.getString("IncidentDate"), resultSet.getDouble("Latitude"), resultSet.getDouble("Longitude"), resultSet.getString("Description"), resultSet.getString("Status"), resultSet.getInt("VictimID"), resultSet.getInt("SuspectID"), resultSet.getInt("AgencyID"));
		                incidents.add(incident);
		            }
		        }
		    }
		    return incidents;
		}
	


	




}