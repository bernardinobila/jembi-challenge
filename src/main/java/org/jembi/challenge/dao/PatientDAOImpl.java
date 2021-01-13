package org.jembi.challenge.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.jembi.challenge.model.Patient;

public class PatientDAOImpl implements PatientDAO {

	ConnectionDAO connectionDAO = new ConnectionDAO();

	public Collection<Patient> savePatient(Collection<Patient> patients) throws SQLException {

		for (Patient patient : patients) {

			String insert = "insert into patients(identityNumber, firstName, lastName, phoneNumber, address, gender, race) "
					+ "values(\""
					+ patient.getIdentityNumber()
					+ "\", \""
					+ patient.getFirstName()
					+ "\", \""
					+ patient.getLastName()
					+ "\", \""
					+ patient.getPhone()
					+ "\", \""
					+ patient.getAddress()
					+ "\", \""
					+ patient.getGender()
					+ "\", \"" + patient.getRace() + "\")";
			
			ResultSet duplicates = ConnectionDAO.statement
					.executeQuery("select * from patients "
							+ "where identityNumber ="
							+ patient.getIdentityNumber() + " or "
							+ "(firstName = \"" + patient.getFirstName()
							+ "\" and lastName =\"" + patient.getLastName()
							+ "\")");
			
			if (duplicates.isBeforeFirst()) {
				while (duplicates.next()) {
					if (patient.getIdentityNumber() == duplicates
							.getString("identityNumber")) {
						continue;
					} else if (patient.getFirstName() == duplicates
							.getString("firstName")
							&& patient.getLastName() == duplicates
									.getString("lastName")) {
						if (patient.getGender() == duplicates
								.getString("gender")
								&& patient.getRace() == duplicates
										.getString("race")) {
							continue;
						}
					} else {
						ConnectionDAO.statement.executeUpdate(insert);
					}
				}
			} else {
				ConnectionDAO.statement.executeUpdate(insert);
			}
		}
				
		 return findAllPatients();

	}

	private Collection<Patient> findAllPatients() throws SQLException {

		ResultSet rows = ConnectionDAO.statement
				.executeQuery("select * from patients limit 10");

		Collection<Patient> patients = new ArrayList<Patient>(0);

		while (rows.next()) {

			final Patient patient = new Patient(rows.getLong("id"),
					rows.getString("identityNumber"),
					rows.getString("firstName"), rows.getString("lastName"),
					rows.getString("phoneNumber"), rows.getString("address"),
					rows.getString("gender"), rows.getString("race"));
			

			patients.add(patient);
		}
		return patients;
	}

	public int countSavedPatients() throws SQLException {
		ResultSet count = ConnectionDAO.statement.executeQuery("select count(*) as count from patients");
		return count.getInt("count");
	}

}
