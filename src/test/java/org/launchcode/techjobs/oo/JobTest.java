package org.launchcode.techjobs.oo;

import org.junit.Test;

// Added jupiter.api dependencies to import the following
import static org.junit.jupiter.api.Assertions.*;


public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();

        assertNotEquals(jobOne,jobTwo);
    }


    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(jobThree instanceof Job);
        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertTrue(jobThree.getLocation() instanceof Location);
        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", jobThree.getName());
        assertEquals("ACME", jobThree.getEmployer().getValue());
        assertEquals("Desert", jobThree.getLocation().getValue());
        assertEquals("Quality control", jobThree.getPositionType().getValue());
        assertEquals("Persistence", jobThree.getCoreCompetency().getValue());
    }


    @Test
    public void testJobsForEquality() {
        Job jobFour = new Job("Student IA", new Employer("LaunchCode"), new Location("STL"), new PositionType("IA"), new CoreCompetency("Persistence"));
        Job jobFive = new Job("Student IA", new Employer("LaunchCode"), new Location("STL"), new PositionType("IA"), new CoreCompetency("Persistence"));

        assertFalse(jobFour.getId() == jobFive.getId());
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobSix = new Job("Student IA", new Employer("LaunchCode"), new Location("STL"), new PositionType("IA"), new CoreCompetency("Persistence"));
        String newline = System.lineSeparator();

        assertEquals(true, jobSix.toString().startsWith(newline));
        assertEquals(true, jobSix.toString().endsWith(newline));
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobSix = new Job("Student IA", new Employer("LaunchCode"), new Location("STL"), new PositionType("IA"), new CoreCompetency("Persistence"));

        assertTrue(jobSix.toString().contains("ID: " + jobSix.getId()));
        assertTrue(jobSix.toString().contains("Name: " + jobSix.getName()));
        assertTrue(jobSix.toString().contains("Employer: " + jobSix.getEmployer()));
        assertTrue(jobSix.toString().contains("Location: " + jobSix.getLocation()));
        assertTrue(jobSix.toString().contains("Position Type: " + jobSix.getPositionType()));
        assertTrue(jobSix.toString().contains("Core Competency: " + jobSix.getCoreCompetency()));
    }


    @Test
    public void testToStringHandlesEmptyField() {
        Job jobSix = new Job("Student IA", new Employer(""), new Location("STL"), new PositionType("IA"), new CoreCompetency("Persistence"));
        String newline = System.lineSeparator();

//        String expected = "\nID: 1\nName: Student IA\nEmployer: \nLocation: STL\nPosition Type: IA\nCore Competency: Persistence\n";
        String expected = newline +
                "ID: " + jobSix.getId() + newline +
                "Name: Student IA" + newline +
                "Employer: Data not available" + newline +
                "Location: STL" + newline +
                "Position Type: IA" + newline +
                "Core Competency: Persistence" + newline;

        assertEquals(expected, jobSix.toString());

    }

}
