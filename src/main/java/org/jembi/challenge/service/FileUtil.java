package org.jembi.challenge.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import org.jembi.challenge.model.Patient;

public class FileUtil {

	final URL url;

	static Scanner input;

	public FileUtil(final String url) throws MalformedURLException {
		super();
		this.url = new URL(url);
		FileUtil.input = getFileContent(this.url);
	}

	protected static Scanner getFileContent(final URL url) {
		Scanner input = null;
		try {
			input = new Scanner(new BufferedReader(new InputStreamReader(
					url.openStream())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	public static Collection<Patient> getPatients() {

		final Collection<Patient> patients = new ArrayList<Patient>(0);

		while (input.hasNextLine()) {
			String line = input.nextLine();
			line = line.replace("[", "");
			line = line.replace("]", "");
			line = line.replace("{", "");
			line = line.replace("}", "");
			line = line.replace("\"", "");

			String[] fields = line.split(",");

			for (int i = 0; i < fields.length; i++) {
				fields[i] = fields[i].substring(fields[i].indexOf(":") + 1);
			}

			final Patient patient = new Patient(fields[0], fields[1],
					fields[2], fields[3], fields[4], fields[5], fields[6]);

			patients.add(patient);
		}
		return patients;

	}

}
