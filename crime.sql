create database crime;
use crime;
select * from Incidents;
create TABLE Incidents (
    IncidentID INT PRIMARY KEY,
    IncidentType VARCHAR(50),
    IncidentDate varchar(100),
    Latitude double,
    Longitude double,
    Description VARCHAR(255),
    Status VARCHAR(20),
    VictimID INT,
    SuspectID INT,
    AgencyID INT
);

drop table Incidents;
alter table Incidents add  FOREIGN KEY (VictimID) REFERENCES Victims(VictimID);
alter table Incidents add  FOREIGN KEY (SuspectID) REFERENCES Suspects(SuspectID);
alter table Incidents add FOREIGN KEY (AgencyID) REFERENCES LawEnforcementAgencies(AgencyID);

CREATE TABLE Victims (
    VictimID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    Gender VARCHAR(10),
    ContactInformation VARCHAR(255)
);

CREATE TABLE Suspects (
    SuspectID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    Gender VARCHAR(10),
    ContactInformation VARCHAR(255)
);

CREATE TABLE LawEnforcementAgencies (
    AgencyID INT PRIMARY KEY,
    AgencyName VARCHAR(100),
    Jurisdiction VARCHAR(100),
    ContactInformation VARCHAR(100)
);

CREATE TABLE Officers (
    OfficerID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    BadgeNumber VARCHAR(20),
    Ranks VARCHAR(50),
    ContactInformation VARCHAR(50),
    AgencyID INT
    
);

ALTER TABLE OFFICERS ADD FOREIGN KEY (AgencyID) REFERENCES LawEnforcementAgencies(AgencyID);


CREATE TABLE Evidence (
    EvidenceID INT PRIMARY KEY,
    Description VARCHAR(50),
    LocationFound VARCHAR(50),
    IncidentID INT
    
);
insert into Evidence values(123, "watch", "chair",1);
ALTER TABLE EVIDENCE ADD FOREIGN KEY (IncidentID) REFERENCES Incidents(IncidentID);

CREATE TABLE Reports (
    ReportID INT PRIMARY KEY,
    IncidentID INT,
    ReportingOfficer Varchar(100),
    ReportDate DATE,
    ReportDetails varchar(100),
    Status VARCHAR(20)
    );
    drop table reports;
    
    insert into Reports values(234,1,"lokesh","2024-02-28","Murder","pending");
        insert into Reports values(235,2,"ravi","2024-02-19","robbery","pending");
            insert into Reports values(236,3,"ragu","2024-01-08","kidnap","pending");


    select * from Reports;
ALTER TABLE REPORTS ADD FOREIGN KEY (IncidentID) REFERENCES Incidents(IncidentID);
ALTER TABLE REPORTS ADD FOREIGN KEY (ReportingOfficer) REFERENCES Officers(OfficerID);