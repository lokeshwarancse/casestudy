
package com.hexaware.controller;
import java.sql.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.hexaware.entity.Evidence;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.*;

public interface ICrimeAnalysisService {

    /**
     * Adds an incident.
     * 
     * @param incident The incident to add
     */
    public void addIncident(Incidents incident);
    

    /**
     * Removes an incident.
     * 
     * @param incident The incident to remove
     */
    public void removePet(Incidents incident);

    /**
     * Lists all available incidents.
     */
    public void listAvailable();

    /**
     * Searches for incidents.
     * 
     * @return A collection of incidents
     */
    public Collection<Incidents> searchIncidents();

    /**
     * Generates an incident report.
     * 
     * @param incident The incident for which to generate the report
     * @return A list of reports
     */
    public static List<Reports> generateIncidentReport(Incidents incident) {
        // TODO: Implement this method
        return null;
    }
    
    public void addEvidence(Evidence incident11);
	
	 
	 

}