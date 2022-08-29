package com.bridgelabz.opencsv;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.opencsv.pojo.UserModel;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OpenCsvWriter {

	public static final String USER_DATA_PATH = "empData.csv";

	public static void main(String[] args) {

		try (Writer writer = Files
				.newBufferedWriter(Paths.get(USER_DATA_PATH))) {

			StatefulBeanToCsv<UserModel> beanToCsv = new StatefulBeanToCsvBuilder<UserModel>(
					writer).build();

			List<UserModel> list = new ArrayList<>();

			UserModel user1 = new UserModel("S. Pichai",
					"sundar.pichai@gmail.com", "+1-1212121212", "USA");
			list.add(user1);

			UserModel user2 = new UserModel("S. Nadela",
					"satyam.n@microsoft.com", "+1-1213141516", "USA");
			list.add(user2);

			beanToCsv.write(list);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}

		System.out.println("Write data to file successfully");
	}

}