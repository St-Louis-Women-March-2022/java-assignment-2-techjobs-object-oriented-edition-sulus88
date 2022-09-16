package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(aJob.getName(), "Product tester");
        assertEquals(aJob.getEmployer().getValue(), "ACME");
        assertEquals(aJob.getLocation().getValue(), "Desert");
        assertEquals(aJob.getPositionType().getValue(), "Quality control");
        assertEquals(aJob.getCoreCompetency().getValue(), "Persistence");
        assertTrue(new Employer("ACME") instanceof Employer);
        assertTrue(new Location("Desert") instanceof Location);
        assertTrue(new PositionType("Quality control") instanceof PositionType);
        assertTrue(new CoreCompetency("Persistence") instanceof CoreCompetency);
        assertTrue(new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"))
                instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job secondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(firstJob.getId() == secondJob.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String toString = aJob.toString();
        assertEquals(toString.charAt(0), '\n');
        assertEquals(toString.charAt(toString.length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job exampleJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(exampleJob.toString(), "\n" + "ID: " + exampleJob.getId() + "\n" +
                "Name: " + exampleJob.getName() + "\n" +
                "Employer: " + exampleJob.getEmployer() + "\n" +
                "Location: " + exampleJob.getLocation() + "\n" +
                "Position Type: " + exampleJob.getPositionType() + "\n" +
                "Core Competency: " + exampleJob.getCoreCompetency() + "\n");
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job exampleJob = new Job("", new Employer("ACME"), new Location(""),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(exampleJob.toString(), "\n" + "ID: " + exampleJob.getId() + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + exampleJob.getEmployer() + "\n" +
                "Location: " + "Data not available" + "\n" +
                "Position Type: " + exampleJob.getPositionType() + "\n" +
                "Core Competency: " + exampleJob.getCoreCompetency() + "\n");

    }

}

