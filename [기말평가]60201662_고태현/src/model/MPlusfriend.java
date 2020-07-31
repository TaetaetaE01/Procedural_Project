package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VBasket;
import valueObject.VFriend;
import valueObject.VPersonalInfo;
import valueObject.VSugangsincheong;

public class MPlusfriend {

	public void write(VFriend vFriend, String PersonalData) {
		try {

			File file = new File("data//friends//" + PersonalData);
			FileWriter fw = new FileWriter(file, true);
			fw.write(vFriend.getFriendName() + ' ');

			fw.write(0x0a);
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Vector<VFriend> read(String personalData) {
		VFriend vFRriend;
		Vector<VFriend> friends = new Vector<VFriend>();

		Scanner scanner;

		try {

			File file = new File("data//friends//" + personalData);
			scanner = new Scanner(file);

			while (scanner.hasNext()) {
				vFRriend = new VFriend();

				vFRriend.setFriendName(scanner.next());

				friends.add(vFRriend);

			}
		} catch (FileNotFoundException e) {
			
		}
		return friends;
	}

	public Vector<VFriend> getFriend(String friendData) {
		VFriend vFriend;
		Vector<VFriend> friends = new Vector<VFriend>();

		Scanner scanner;

		try {

			File file = new File("data//sugangUsers//" + friendData);
			scanner = new Scanner(file);

			while (scanner.hasNext()) {
				vFriend = new VFriend();

				vFriend.setId(scanner.next());
				vFriend.setName(scanner.next());
				vFriend.setProfessor(scanner.next());
				vFriend.setCredit(scanner.next());
				vFriend.setTime(scanner.next());
				friends.add(vFriend);
			}
		} catch (FileNotFoundException e) {

		}
		return friends;
	}
}
