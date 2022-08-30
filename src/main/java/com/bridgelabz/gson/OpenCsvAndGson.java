package com.bridgelabz.gson;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.bridgelabz.opencsv.pojo.UserModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCsvAndGson {

	public static final String USER_DATA_FILE = "userdata.csv";
	public static final String USER_DATA_JSON = "users.json";

	public static void main(String[] args) {

		try (Reader reader = Files
				.newBufferedReader(Paths.get(USER_DATA_FILE))) {

			CsvToBean<UserModel> csvToBean = new CsvToBeanBuilder<UserModel>(
					reader).withType(UserModel.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			List<UserModel> userList = csvToBean.parse();

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			String jsonList = gson.toJson(userList);

			FileWriter writer = new FileWriter(USER_DATA_JSON);

			writer.write(jsonList);

			writer.close();

			BufferedReader bufferReader = Files
					.newBufferedReader(Paths.get(USER_DATA_JSON));

			StringBuffer bufferStr = new StringBuffer();

			String fileStr;
			while ((fileStr = bufferReader.readLine()) != null) {
				bufferStr.append(fileStr);
			}

			UserModel[] jsonFileData = gson.fromJson(bufferStr.toString(),
					UserModel[].class);

			Arrays.asList(jsonFileData);
			
			for (UserModel model : jsonFileData) {
				System.out.println(model);
			}

			bufferReader.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}