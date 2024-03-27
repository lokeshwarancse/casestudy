/**
 * The Controller class provides functionalities to manage incidents and evidence.
 * It implements the ICrimeAnalysisService interface.
 */
package com.hexaware.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.dao.Dao;
import com.hexaware.entity.*;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.Reports;

public abstract class Controller<IncidentID> implements ICrimeAnalysisService {

    private List<Incidents> availableIncidents;

    /**
     * Constructor to initialize the availableIncidents list.
     */
    public Controller() {
        availableIncidents = new ArrayList<>();
    }

    /**
     * Adds an incident to the list of available incidents.
     * 
     * @param incident The incident to add
     */
    public void addIncidents(Incidents incident) {
        availableIncidents.add(incident);
        System.out.println("Added to the list of available incidents: " + incident.toString());
    }

    /**
     * Removes an incident from the list of available incidents.
     * 
     * @param incident The incident to remove
     */
    public void removeIncidents(Incidents incident) {
        availableIncidents.remove(incident);
        System.out.println("Removed from the list of available incidents: " + incident.toString());
    }

    /**
     * Lists all available incidents.
     */
    public void listAvailable() {
        if (availableIncidents.isEmpty()) {
            System.out.println("No incidents found.");
        } else {
            System.out.println("Available incidents:");
            for (Incidents incident : availableIncidents) {
                System.out.println(incident);
            }
        }
    }

    /**
     * Searches for an incident by its ID.
     * 
     * @param incidentID The ID of the incident to search
     * @return The incident if found, null otherwise
     */
    public Incidents searchIncidentByID(int incidentID) {
        try {
            return Dao.searchIncidentByID(incidentID);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Generates a report for the given incident.
     * 
     * @param incident The incident for which to generate the report
     */
    public void generateIncidentReport(Incidents incident) {
        List<Reports> reports = ICrimeAnalysisService.generateIncidentReport(incident);
        if (reports.isEmpty()) {
            System.out.println("No reports found for the incident.");
        } else {
            System.out.println("Incident Reports:");
            for (Reports report : reports) {
                System.out.println(report);
            }
        }
    }
    
    public void addCase(String caseDescription) {
        try {
            Dao dao = new Dao();
            Case newCase = new Case(0, caseDescription, availableIncidents);
            dao.addCase(newCase);
            System.out.println("New case added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add case: " + e.getMessage());
        }
    

    // Method to get a specific case by ID
   // public Case getCase(int caseID) {
//        try {
//            Dao dao = new Dao();
//            return dao.getCaseByID(caseID);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//     Method to list all cases
//    public void listCases() {
//        try {
//            Dao dao = new Dao();
//            List<Case> cases = dao.listCases();
//            if (cases.isEmpty()) {
//                System.out.println("No cases found.");
//            } else {
//                System.out.println("List of Cases:");
//                for (Case caseObj : cases) {
//                    System.out.println(caseObj);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
// 
}
}