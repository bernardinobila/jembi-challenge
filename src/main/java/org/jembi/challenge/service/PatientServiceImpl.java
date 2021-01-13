package org.jembi.challenge.service;

import java.util.Collection;
import org.jembi.challenge.model.Patient;
import org.jembi.challenge.dao.PatientDAO;
import org.jembi.challenge.dao.PatientDAOImpl;

public class PatientServiceImpl implements PatientService {

	PatientDAO patientDAO;
	

	public PatientServiceImpl() {
		super();
		this.patientDAO = new PatientDAOImpl();
	}


	public Collection<Patient> savePatients(final Collection<Patient> patients)
			throws Exception {
		return patientDAO.savePatient(patients);
	}

}
