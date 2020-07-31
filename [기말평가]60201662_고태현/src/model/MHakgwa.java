package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VPersonalInfo;
import valueObject.VHakgwa;

public class MHakgwa {

	public Vector<VHakgwa> getData(String fileName) {
		String m;
		VHakgwa vCampus;
		Vector<VHakgwa> vCampuses = new Vector<VHakgwa>();
		File file = new File("data\\" + fileName);
		Scanner scanner;
		try {
			scanner = new Scanner(file);

			while (scanner.hasNext()) {
				vCampus = new VHakgwa();

				vCampus.setId(scanner.nextInt());
				vCampus.setName(scanner.next());
				vCampus.setFileName(scanner.next());
				vCampuses.add(vCampus);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vCampuses;
	}

}
