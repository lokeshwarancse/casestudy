package com.hexaware.entity;

import java.util.Collection;

public class Case {
    private String caseDescription;
    private Collection<Incidents> incidents;
	private int caseId;

    public Case(int caseId ,String caseDescription, Collection<Incidents> incidents) {
        this.caseDescription = caseDescription;
        this.incidents = incidents;
        this.caseId=caseId;
    }

    // Getters and setters for caseDescription and incidents
    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }
    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public Collection<Incidents> getIncidents() {
        return incidents;
    }

    public void setIncidents(Collection<Incidents> incidents) {
        this.incidents = incidents;
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseDescription='" + caseDescription + '\'' +
                ", incidents=" + incidents +
                '}';
    }
}
