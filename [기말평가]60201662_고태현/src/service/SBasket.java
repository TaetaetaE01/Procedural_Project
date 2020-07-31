package service;

import java.io.IOException;
import java.util.Vector;

import model.MBasket;
import model.MLecture;
import model.MPersonalInfo;
import valueObject.VBasket;
import valueObject.VLecture;
import valueObject.VLogin;
import valueObject.VPersonalInfo;

public class SBasket {

	public Vector<VBasket> read(String personalData, String Id) {

		MBasket mBasket = new MBasket();
		Vector<VBasket> vBaskets = mBasket.read(personalData, Id);

		return vBaskets;

	}

	public void write(VBasket vBasket, String personalData) {

		MBasket mBasket = new MBasket();
		mBasket.write(vBasket, personalData);

	}

	public void basketDelete(String personalData) {

		MBasket mBasket = new MBasket();
		mBasket.basketDelete(personalData);
	}
}
