package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import model.MPersonalInfo;
import valueObject.VLogin;
import valueObject.VPersonalInfo;

public class SLogin {

	public VPersonalInfo validate(VLogin vLogin) throws IOException {

		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		VPersonalInfo vPersonalInfo = mPersonalInfo.read(vLogin.ConfirmId);

		if (vPersonalInfo == null) {
			return vPersonalInfo;
		} else {
			if (vLogin.ConfirmPassword.equals(vPersonalInfo.password1) && vLogin.ConfirmId.equals(vPersonalInfo.id1)) {
				return vPersonalInfo;
			} else {
				return null;
			}
		}
	}

}