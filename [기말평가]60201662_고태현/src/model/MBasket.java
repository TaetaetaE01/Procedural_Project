package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VBasket;
import valueObject.VHakgwa;

public class MBasket {
	int a;

	public void write(VBasket vBasket, String personalData) {

		try {
			File file = new File("data//users//" + personalData);
			FileWriter fw = new FileWriter(file, true);

			fw.write(vBasket.getId() + ' ');
			fw.write(vBasket.getName() + ' ');
			fw.write(vBasket.getProfessor() + ' ');
			fw.write(vBasket.getCredit() + ' ');
			fw.write(vBasket.getTime() + ' ');
			fw.write(0x0a);
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Vector<VBasket> read(String personalData, String Id) {
		VBasket vBasket;
		Vector<VBasket> vBaskets = new Vector<VBasket>();

		Scanner scanner;

		try {

			File file = new File("data//users//" + personalData);
			scanner = new Scanner(file);

			while (scanner.hasNext()) {
				vBasket = new VBasket();

				vBasket.setId(scanner.next());
				vBasket.setName(scanner.next());
				vBasket.setProfessor(scanner.next());
				vBasket.setCredit(scanner.next());
				vBasket.setTime(scanner.next());
				vBaskets.add(vBasket);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vBaskets;
	}

	public void basketDelete(String personalData) {
		String dataFolder;
		dataFolder = ("data//users//" + personalData);
		File deleteFile = new File(dataFolder);

		boolean delete = true;
		if (deleteFile.exists()) {

			System.gc();
			delete = deleteFile.delete();
		} 
	}

}