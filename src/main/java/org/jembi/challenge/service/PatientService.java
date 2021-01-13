package org.jembi.challenge.service;

import java.util.Collection;
import org.jembi.challenge.model.Patient;

public interface PatientService {

	public Collection<Patient> savePatients(final Collection<Patient> patients)
			throws Exception;

}
