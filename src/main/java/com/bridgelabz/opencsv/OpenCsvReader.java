package com.bridgelabz.opencsv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class OpenCsvReader {

	public static final String USER_SAMPLE_DATA_PATH = "userdata.csv";

	public static void main(String[] args) {

		try {
			Reader reader = Files
					.newBufferedReader(Paths.get(USER_SAMPLE_DATA_PATH));
			CSVReader csvReader = new CSVReader(reader);

			/*
			 * String[] nextRecord;
			 * 
			 * while ((nextRecord = csvReader.readNext()) != null) {
			 * System.out.print(nextRecord[0]); System.out.print("\t" +
			 * nextRecord[1]); System.out.print("\t" + nextRecord[2]);
			 * System.out.print("\t" + nextRecord[3] + "\n"); }
			 */

			List<String[]> allData = csvReader.readAll();

			for (String[] data : allData) {
				System.out.print(data[0]);
				System.out.print("\t" + data[1]);
				System.out.print("\t" + data[2]);
				System.out.print("\t" + data[3] + "\n");
			}

			System.out.println("---------------------------------");

			csvReader.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}

	}

}