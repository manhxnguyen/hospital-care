package org.example;

import org.example.model.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PAMSApp {
    public static void main(String[] args) {
        // Create array of Patient objects
        Patient[] patients = {
            new Patient(1, "Daniel", "Agar", "(641) 123-0009", "dagar@m.as", "1 N Street", LocalDate.of(1987, 1, 19)),
            new Patient(2, "Ana", "Smith", null, "amsith@te.edu", null, LocalDate.of(1948, 12, 5)),
            new Patient(3, "Marcus", "Garvey", "(123) 292-0018", null, "4 East Ave", LocalDate.of(2001, 9, 18)),
            new Patient(4, "Jeff", "Goldbloom", "(999) 165-1192", "jgold@es.co.za", null, LocalDate.of(1995, 2, 28)),
            new Patient(5, "Mary", "Washington", null, null, "30 W Burlington", LocalDate.of(1932, 5, 31))
        };

        // Sort patients by age in descending order (oldest first)
        List<Patient> patientList = Arrays.asList(patients);
        patientList.sort(Comparator.comparingInt(Patient::getAge).reversed());

        // Convert to JSON and write to file
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            File outputFile = new File("patients.json");
            mapper.writeValue(outputFile, patientList);

            System.out.println("Patient data successfully written to patients.json");
            System.out.println("Patients sorted by age (oldest first):");

            for (Patient patient : patientList) {
                System.out.printf("%s %s - Age: %d%n",
                    patient.getFirstName(), patient.getLastName(), patient.getAge());
            }

        } catch (IOException e) {
            System.err.println("Error writing JSON file: " + e.getMessage());
        }
    }
}