package org.launchcode.techjobs.oo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;



    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId ++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }



    // TODO: Add custom equals and hashCode methods.
    //  Consider two Job objects "equal" when their id fields match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }



    // Override Method for toString()

    @Override
    public String toString() {
        String newline = System.lineSeparator();
        String emptyField = "Data not available";

        ArrayList<String> jobFields = new ArrayList<>();
        jobFields.add(name);
        jobFields.add(employer.toString());
        jobFields.add(location.toString());
        jobFields.add(positionType.toString());
        jobFields.add(coreCompetency.toString());

        for (String field : jobFields) {
            if (field.isBlank()) {
                jobFields.set(jobFields.indexOf(field), emptyField);
            }
        }

        return newline +
                "ID: " + id + newline +
                "Name: " + jobFields.get(0) + newline +
                "Employer: " + jobFields.get(1) + newline +
                "Location: " + jobFields.get(2) + newline +
                "Position Type: " + jobFields.get(3) + newline +
                "Core Competency: " + jobFields.get(4) + newline;
    }



    // TODO: Add getters for each field EXCEPT nextId.
    //  Add setters for each field EXCEPT nextID and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }






}
