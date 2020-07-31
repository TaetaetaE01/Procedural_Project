package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VBasket;
import valueObject.VSugangsincheong;

public class MSugangsincheong {

	public void write(VSugangsincheong vSugangsincheong, String personalData) {

		try {
			File file = new File("data//sugangUsers//" + personalData);
			FileWriter fw = new FileWriter(file, true);

			fw.write(vSugangsincheong.getId() + ' ');
			fw.write(vSugangsincheong.getName() + ' ');
			fw.write(vSugangsincheong.getProfessor() + ' ');
			fw.write(vSugangsincheong.getCredit() + ' ');
			fw.write(vSugangsincheong.getTime() + ' ');
			fw.write(0x0a);
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Vector<VSugangsincheong> read(String personalData) {
		VSugangsincheong vSugangsincheong;
		Vector<VSugangsincheong> vSugangsincheongs = new Vector<VSugangsincheong>();

		Scanner scanner;

		try {

			File file = new File("data//sugangUsers//" + personalData);
			scanner = new Scanner(file);

			while (scanner.hasNext()) {
				vSugangsincheong = new VSugangsincheong();

				vSugangsincheong.setId(scanner.next());
				vSugangsincheong.setName(scanner.next());
				vSugangsincheong.setProfessor(scanner.next());
				vSugangsincheong.setCredit(scanner.next());
				vSugangsincheong.setTime(scanner.next());
				vSugangsincheongs.add(vSugangsincheong);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vSugangsincheongs;
	}

	public void basketDelete(String personalData) {
	
		String dataFolder;
		dataFolder = ("data//sugangUsers//" + personalData);
		File deleteFile = new File(dataFolder);

		boolean delete = true;
		if (deleteFile.exists()) {

			System.gc();
			delete = deleteFile.delete();
		} else {

		}
	}
}
