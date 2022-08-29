package com.bridgelabz.opencsv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.bridgelabz.opencsv.pojo.UserModel;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCsvReaderPojo {

	public static final String USER_SAMPLE_DATA_PATH = "userdata.csv";

	public static void main(String[] args) {

		try (Reader reader = Files
				.newBufferedReader(Paths.get(USER_SAMPLE_DATA_PATH))) {

			CsvToBean<UserModel> csvToBean = new CsvToBeanBuilder<UserModel>(
					reader).withType(UserModel.class).build();

			List<UserModel> userList = csvToBean.parse();

			for (UserModel userModel : userList) {
				System.out.println(userModel);
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}