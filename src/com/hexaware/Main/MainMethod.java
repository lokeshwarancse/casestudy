package com.hexaware.Main;
import java.util.*;


import java.sql.SQLException;

import com.hexaware.myexceptions.IncidentNumberNotFoundException;
import com.hexaware.controller.Controller;
import com.hexaware.dao.Dao;
import com.hexaware.entity.*;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.Reports;


/**
 * The MainMethod class provides a command-line interface for interacting with the Crime Analysis System.
 */
public class MainMethod {
	 private static Dao incidentController = new Dao();
	 /**
	     * The main method is the entry point of the application.
	     * 
	     * @param args The command-line arguments
	     * @throws SQLException if a database access error occurs
	     * @throws IncidentNumberNotFoundException if an incident number is not found
	     */

	public static void main(String[] args) throws SQLException, IncidentNumberNotFoundException {
		
        Scanner scanner = new Scanner(System.in);
        Dao crimeDao = new Dao();
        

        int choice = 0;

        do {
            System.out.println("1. Add an Incident");
            System.out.println("2. Remove an Incident");
            System.out.println("3. list all Incidents");
            System.out.println("4. Search by Incident id");
            System.out.println("5. generate report");
            System.out.println("6. add case");
            System.out.println("7. get a specific case");
            System.out.println("8. List all cases");
            System.out.println("9. Exit");





           






            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                

                switch (choice) {
                    case 1:
                        System.out.println("Enter incident details:");
                        System.out.print("Incident ID: ");
                        int incidentID = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Incident Type: ");
                        String incidentType = scanner.nextLine();
                        System.out.print("Incident Date: ");
                        String incidentDate = scanner.nextLine();
                        System.out.print("Latitude: ");
                        float latitude = scanner.nextFloat();
                        System.out.print("Longitude: ");
                        float longitude = scanner.nextFloat();
                        scanner.nextLine(); 
                        System.out.print("Description: ");
                        String description = scanner.nextLine();
                        System.out.println("Status: ");
                        String status = scanner.nextLine();
                        System.out.println("Victim ID: ");
                        int victimID = scanner.nextInt();
                        System.out.println("Suspect ID: ");
                        int suspectID = scanner.nextInt();
                        System.out.println("Agency ID: ");
                        int agencyID = scanner.nextInt();

                        Incidents incident = new Incidents(incidentID, incidentType, incidentDate, latitude, longitude, description, status, victimID, suspectID, agencyID);
                        crimeDao.addIncident(incident);
                        System.out.println("Incident added successfully!");
                        break;
                        
                    case 2:
                        
                        System.out.println("Enter the ID to remove:");
                        String NameToRemove = scanner.nextLine();

                        
                        crimeDao.removeInci(NameToRemove);
                        
                        System.out.println("name: '" + NameToRemove + "' has been removed.");
                        break;
                        
                    case 3:
                        
                        List<Incidents> availableIncidents = crimeDao.listAvailable();

                        if (availableIncidents.isEmpty()) {
                            System.out.println("No incidents");
                        } else {
                            System.out.println("Available Incidents");
                            for (Incidents incidents : availableIncidents) {
                            	System.out.println("Id: " + incidents.getID());
                            	System.out.println("Type: " + incidents.getType());
                            	System.out.println("Incident Date: " + incidents.getDate());
                            	System.out.println("Latitude: " + incidents.getLati());
                            	System.out.println("Longitude: " + incidents.getLongi());
                            	System.out.println("Description: " + incidents.getDes());
                            	System.out.println("Status: " + incidents.getStatus());
                            	System.out.println("VictimId: " + incidents.getVicID());
                            	System.out.println("SuspectID: " + incidents.getSuspID());
                            	System.out.println("AgencyID: " + incidents.getAgencyID());

                                
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Enter Incident ID to search:");
                        System.out.print("Incident ID: ");
                        int searchIncidentID = Integer.parseInt(scanner.nextLine());
                        Incidents foundIncident = Dao.searchIncidentByID(searchIncidentID);
                        if (foundIncident != null) {
                            System.out.println("Incident found:");
                            System.out.println(foundIncident);
                        } else {
                            System.out.println("Incident with ID " + searchIncidentID + " not found.");
                        }
                        break;
                        
                    
                        
                    case 5:
                        System.out.println("Enter Incident ID to generate report:");

                        System.out.println("Incident ID: ");
                        int IncidentID = Integer.parseInt(scanner.nextLine());
                        Incidents incident1 = crimeDao.searchIncidentByID(IncidentID);
                        if (incident1 != null) {
                            List<Reports> reportsList = crimeDao.generateIncidentReport(incident1);
                            for (Reports report : reportsList) {
                                System.out.println(report);
                            }
                        } else {
                            System.out.println("Incident with ID " + IncidentID + " not found.");
                        }
                        break;
                        
                    case 6:
                        System.out.println("Exiting...");
                    case 7:
                        System.out.println("Enter the case ID to retrieve details:");
                        System.out.print("Case ID: ");
                        int caseID = Integer.parseInt(scanner.nextLine());
                        Case retrievedCase = crimeDao.getCaseById(caseID);
                        if (retrievedCase != null) {
                            System.out.println("Case Details:");
                            System.out.println("ID: " + retrievedCase.getIncidents());
                            System.out.println("Description: " + retrievedCase.getCaseDescription());
                        } else {
                            System.out.println("Case with ID " + caseID + " not found.");
                        }
                        break;
                        

                        
                    


                    default:
                        System.out.println("Invalid choice. Please enter 1 to add an incident.");
                }
            } catch (IncidentNumberNotFoundException e) {
                System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.nextLine(); 
            }
        } while (choice != 6);

        scanner.close();
    }
}
