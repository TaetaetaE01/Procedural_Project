package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VBasket;
import valueObject.VSugang;

public class MSugang {
	
	public void write(VSugang vSugang, String personalData) {
		try {

			File file = new File("data//users//" + personalData);
			FileWriter fw = new FileWriter(file, true);

			
			fw.write(vSugang.getId() + ' ');
			fw.write(vSugang.getName() + ' ');
			fw.write(vSugang.getProfessor() + ' ');
			fw.write(vSugang.getCredit() + ' ');
			fw.write(vSugang.getTime() + ' ');
			fw.write(0x0a);
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Vector<VSugang> read(String personalData) {
		VSugang vSugang;
		Vector<VSugang> vSugangs = new Vector<VSugang>();
		Scanner scanner;

		try {
			File file = new File("data//users//" + personalData);
			scanner = new Scanner(file);

			while (scanner.hasNext()) {
				vSugang = new VSugang();

				vSugang.setId(scanner.next());
				vSugang.setName(scanner.next());
				vSugang.setProfessor(scanner.next());
				vSugang.setCredit(scanner.next());
				vSugang.setTime(scanner.next());
				vSugangs.add(vSugang);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vSugangs;
	}
}
