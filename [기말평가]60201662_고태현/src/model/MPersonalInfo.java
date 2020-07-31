package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import valueObject.VPersonalInfo;

public class MPersonalInfo {

	public VPersonalInfo plusfriend(VPersonalInfo vPersonalInfo) throws IOException {
		// vPersonalInfo = null;
		String u;
		// vPersonalInfo = new VPersonalInfo();
		File file = new File("data//PersonalInfo");

		BufferedReader infile = new BufferedReader(new FileReader(file));

		while ((u = infile.readLine()) != null) {

			Scanner scanner = new Scanner(u);

			vPersonalInfo.id1 = scanner.next();
			vPersonalInfo.password1 = scanner.next();
			vPersonalInfo.name1 = scanner.next();
			vPersonalInfo.number = scanner.next();
			vPersonalInfo.seoulBtn = scanner.next();
			vPersonalInfo.yonginBtn = scanner.next();

			if (vPersonalInfo.id1.equals(vPersonalInfo.plusfriend)) {
				break;
			}
			scanner.close();
		}
		return vPersonalInfo;
	}

	public VPersonalInfo findid(VPersonalInfo vPersonalInfo) throws IOException {
		// vPersonalInfo = null;
		String u;
		// vPersonalInfo = new VPersonalInfo();
		File file = new File("data//PersonalInfo");

		BufferedReader infile = new BufferedReader(new FileReader(file));

		while ((u = infile.readLine()) != null) {

			Scanner scanner = new Scanner(u);

			vPersonalInfo.id1 = scanner.next();
			vPersonalInfo.password1 = scanner.next();
			vPersonalInfo.name1 = scanner.next();
			vPersonalInfo.number = scanner.next();
			vPersonalInfo.seoulBtn = scanner.next();
			vPersonalInfo.yonginBtn = scanner.next();

			if (vPersonalInfo.number.equals(vPersonalInfo.findid)) {
				break;
			}
			scanner.close();
		}
		return vPersonalInfo;
	}

	public VPersonalInfo findpw(VPersonalInfo vPersonalInfo) throws IOException {
		// vPersonalInfo = null;
		String u;
		// vPersonalInfo = new VPersonalInfo();
		File file = new File("data//PersonalInfo");

		BufferedReader infile = new BufferedReader(new FileReader(file));

		while ((u = infile.readLine()) != null) {

			Scanner scanner = new Scanner(u);

			vPersonalInfo.id1 = scanner.next();
			vPersonalInfo.password1 = scanner.next();
			vPersonalInfo.name1 = scanner.next();
			vPersonalInfo.number = scanner.next();
			vPersonalInfo.seoulBtn = scanner.next();
			vPersonalInfo.yonginBtn = scanner.next();

			if (vPersonalInfo.id1.equals(vPersonalInfo.findpw)) {
				break;
			}
			scanner.close();
		}
		return vPersonalInfo;
	}

	public VPersonalInfo compare(VPersonalInfo vPersonalInfo) throws IOException {

		String m;

		File file = new File("data//PersonalInfo");

		BufferedReader infile = new BufferedReader(new FileReader(file));

		while ((m = infile.readLine()) != null) {

			Scanner scanner = new Scanner(m);

			vPersonalInfo.id1 = scanner.next();
			vPersonalInfo.password1 = scanner.next();
			vPersonalInfo.name1 = scanner.next();
			vPersonalInfo.number = scanner.next();
			vPersonalInfo.seoulBtn = scanner.next();
			vPersonalInfo.yonginBtn = scanner.next();

			if (vPersonalInfo.id1.equals(vPersonalInfo.compareid)) {
				break;
			}
			scanner.close();
		}
		return vPersonalInfo;
	}

	public VPersonalInfo read(String ConfirmId) throws IOException {
		VPersonalInfo vPersonalInfo = null;

		String s;
		vPersonalInfo = new VPersonalInfo();
		File file = new File("data//PersonalInfo");

		BufferedReader infile = new BufferedReader(new FileReader(file));

		while ((s = infile.readLine()) != null) {

			Scanner scanner = new Scanner(s);

			vPersonalInfo.id1 = scanner.next();
			vPersonalInfo.password1 = scanner.next();
			vPersonalInfo.name1 = scanner.next();
			vPersonalInfo.number = scanner.next();
			vPersonalInfo.seoulBtn = scanner.next();
			vPersonalInfo.yonginBtn = scanner.next();

			if (vPersonalInfo.id1.equals(ConfirmId)) {
				break;
			}
			scanner.close();
		}
		return vPersonalInfo;
	}

	public void write(VPersonalInfo vPersonalInfo) {
		try {
			File file = new File("data//PersonalInfo");
			FileWriter fw = new FileWriter(file, true);
			fw.write(vPersonalInfo.id1 + ' ');
			fw.write(vPersonalInfo.password1 + ' ');
			fw.write(vPersonalInfo.name1 + ' ');
			fw.write(vPersonalInfo.number + ' ');
			fw.write(vPersonalInfo.seoulBtn + ' ');
			fw.write(vPersonalInfo.yonginBtn + ' ');
			fw.write(0x0a);
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
