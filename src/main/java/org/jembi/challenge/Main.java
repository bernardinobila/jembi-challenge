package org.jembi.challenge;

import java.net.MalformedURLException;
import java.util.Collection;

import org.jembi.challenge.model.Patient;
import org.jembi.challenge.service.FileUtil;
import org.jembi.challenge.service.PatientService;
import org.jembi.challenge.service.PatientServiceImpl;

public class Main {

	public static void main(String[] args) {

		final String url = "https://www.mockaroo.com/04de5930/download?count=1000&key=e27814e0";
		try {
			new FileUtil(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		PatientService patientService = new PatientServiceImpl();
		Collection<Patient> patients = null;
		try {
			patients = patientService.savePatients(FileUtil.getPatients());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Registered Patients: "+patients.size());
		System.out
				.println("------------------------------------------------------------------------");
		for (Patient patient : patients) {
			System.out
					.println("---------------------------------------------------------------------------------------------");
			System.out.print("Identity Number: " + patient.getIdentityNumber()
					+ ", ");
			System.out.print("Identity Number: " + patient.getFirstName()
					+ ", ");
			System.out
					.print("Identity Number: " + patient.getLastName() + ", ");
			System.out.print("Identity Number: " + patient.getPhone() + ", ");
			System.out.print("Identity Number: " + patient.getAddress() + ", ");
			System.out.print("Identity Number: " + patient.getGender() + ", ");
			System.out.print("Identity Number: " + patient.getRace() + ", ");
			System.out
					.println("---------------------------------------------------------------------------------------------");
		}
		System.out.println("---------------------------------------------------");

	}

}
