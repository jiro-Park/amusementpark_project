package everland2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {

	private BufferedReader br = null;
	private FileWrite fw = null;

	public FileRead() throws IOException {
		try {
			br = new BufferedReader(new FileReader(DataClass.FILE_LOCATION));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void fileCheck() throws IOException {        // 파일이 존재하지 않을 경우에 카테고리 저장
		fw = new FileWrite();
		String line = br.readLine();

		if (line == null) {
			fw.saveTitle();
		}
	}
}