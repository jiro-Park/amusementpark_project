package everland2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	private BufferedReader br = null;

	public FileRead() throws IOException {

		try {
			br = new BufferedReader(new FileReader("C:\\Users\\p\\Desktop\\out.txt"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}