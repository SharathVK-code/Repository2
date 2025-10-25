package Automation.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class DataReader {

	public void getJsonDataToMap() throws IOException {

		// Read JSON to String
		String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\Automation\\data\\PurchaseOrder.json"),
				StandardCharsets.UTF_8);

		// convert string to HashMap - Jackson DataBind dependency

	}

}
