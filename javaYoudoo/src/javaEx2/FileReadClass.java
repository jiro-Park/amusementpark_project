package javaEx2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadClass {

	private BufferedReader br = null;
	private OutputClass oc = null;

	public FileReadClass() throws IOException {

		try {
			br = new BufferedReader(new FileReader("C:\\Users\\p\\Desktop\\out.txt"));
			oc = new OutputClass();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	public void readFromFile() throws IOException {
		ArrayList<String> line = new ArrayList<String>();
		String[] split = new String[7];
		String line2;

		while (true) {
			line2 = br.readLine();
			if (line2 == null) break;
			line.add(line2);
		}

		for (int i = line.size() - 1; i >= 0; i--) {
			if (!line.get(i).contains("환전") && line.get(i).contains("USD")) {
				split = line.get(i).split(",");
				ConstValueClass.setBALANCE_USD(Double.parseDouble(split[6]));
				break;
			}
		}
		for (int i = line.size() - 1; i >= 0; i--) {
			if (!line.get(i).contains("환전") && line.get(i).contains("EUR")) {
				split = line.get(i).split(",");
				ConstValueClass.setBALANCE_EUR(Double.parseDouble(split[6]));
				break;
			}
		}
		for (int i = line.size() - 1; i >= 0; i--) {
			if (!line.get(i).contains("환전") && line.get(i).contains("JPY")) {
				split = line.get(i).split(",");
				ConstValueClass.setBALANCE_JPY(Double.parseDouble(split[6]));
				break;
			}
		}
		oc.printBalance();
	}
}
