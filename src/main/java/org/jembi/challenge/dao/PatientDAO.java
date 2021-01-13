package org.jembi.challenge.dao;

import java.sql.SQLException;
import java.util.Collection;

import org.jembi.challenge.model.Patient;

public interface PatientDAO {

	public Collection<Patient> savePatient(final Collection<Patient> patients)
			throws SQLException;
	
	public int countSavedPatients() throws SQLException;
}
