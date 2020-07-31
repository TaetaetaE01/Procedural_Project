package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VHakgwa;
import valueObject.VLecture;

public class MLecture {

	public Vector<VLecture> read(String fileName) {

		VLecture vLecture;

		// vLecture = new VLecture();
		Vector<VLecture> vLectures = new Vector<VLecture>();

		Scanner scanner;
		try {
			File file = new File("data\\" + fileName);
			scanner = new Scanner(file);

			while (scanner.hasNext()) {
				vLecture = new VLecture();

				vLecture.setId(scanner.next());
				vLecture.setName(scanner.next());
				vLecture.setProfessor(scanner.next());
				vLecture.setCredit(scanner.next());
				vLecture.setTime(scanner.next());
				vLectures.add(vLecture);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vLectures;
	}
}
