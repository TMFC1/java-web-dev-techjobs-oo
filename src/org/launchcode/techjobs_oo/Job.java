package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId() &&
                Objects.equals(getName(), job.getName()) &&
                Objects.equals(getEmployer(), job.getEmployer()) &&
                Objects.equals(getLocation(), job.getLocation()) &&
                Objects.equals(getPositionType(), job.getPositionType()) &&
                Objects.equals(getCoreCompetency(), job.getCoreCompetency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmployer(), getLocation(), getPositionType(), getCoreCompetency());
    }

    public int getId() {
        return id;
    }

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

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append(" \n");
        builder.append("ID: " + id + "\n");
        builder.append("Name: " + (name == null || name.isBlank() ? "Data not available" : name) + "\n");
        builder.append("Employer: " + (employer == null || employer.toString().isBlank() ? "Data not available" : employer) + "\n");
        builder.append("Location: " + (location == null || location.toString().isBlank() ? "Data not available" : location) + "\n");
        builder.append("Position Type: " + (positionType == null || positionType.toString().isBlank() ? "Data not available" : positionType) + "\n");
        builder.append("Core Competency: " + (coreCompetency == null || coreCompetency.toString().isBlank() ? "Data not available" : coreCompetency) + "\n");
        builder.append(" \n");

        return builder.toString();
    }
}
