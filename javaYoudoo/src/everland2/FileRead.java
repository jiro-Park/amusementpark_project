package everland2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {

	private BufferedReader br = null;

	public FileRead() throws IOException {

		try {
			br = new BufferedReader(new FileReader("out0.txt"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readFromFile() throws IOException {
		String line;

		while (true) {
			line = br.readLine();

			if (line == null)
				break;
			System.out.println(line);

		}
		System.out.println();
	}
}