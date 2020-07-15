package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class JobTest {

    @Test
    public void testIdIncrementing() {
        Job test_job1 = new Job();
        Job test_job2 = new Job();
        assertFalse(test_job1.getId() == test_job2.getId());
    }

    @Test
    public void testSettingJobId() {
        Job testId = new Job();
        assertFalse(testId.getId() == 0);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(test_job3.getEmployer() instanceof Employer && test_job3.getCoreCompetency() instanceof CoreCompetency && test_job3.getLocation() instanceof Location && test_job3.getPositionType() instanceof PositionType);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testJobToStringBlankLines() {
        Job test_job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String job = test_job1.toString();
        String[] jobLines = job.split("\n");
        assertTrue(jobLines[0].isBlank());
        assertTrue(jobLines[jobLines.length - 1].isBlank());
    }

    @Test
    public void testJobToStringContainsLabelsAndValues() {
        Job test_job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String job = test_job1.toString();
        String[] jobLines = job.split("\n");
        assertEquals(jobLines[1], "ID: " + test_job1.getId());
        assertEquals(jobLines[2], "Name: Product tester");
        assertEquals(jobLines[3], "Employer: ACME");
        assertEquals(jobLines[4], "Location: Desert");
        assertEquals(jobLines[5], "Position Type: Quality control");
        assertEquals(jobLines[6], "Core Competency: Persistence");
    }
    @Test
    public void testJobToStringEmptyFieldReturnsDataNotAvailable() {
        Job test_job1 = new Job();
        String job = test_job1.toString();
        String[] jobLines = job.split("\n");
        assertEquals(jobLines[1], "ID: " + test_job1.getId());
        assertEquals(jobLines[2], "Name: Data not available");
        assertEquals(jobLines[3], "Employer: Data not available");
        assertEquals(jobLines[4], "Location: Data not available");
        assertEquals(jobLines[5], "Position Type: Data not available");
        assertEquals(jobLines[6], "Core Competency: Data not available");
    }
}
