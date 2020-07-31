package service;

import java.util.Vector;

import model.MBasket;
import model.MSugangsincheong;
import valueObject.VBasket;
import valueObject.VSugangsincheong;

public class SSugangsincheong {

	public Vector<VSugangsincheong> read(String personalData) {

		MSugangsincheong mSugangsincheong = new MSugangsincheong();
		Vector<VSugangsincheong> vSugangsincheongs = mSugangsincheong.read(personalData);

		return vSugangsincheongs;

	}

	public void write(VSugangsincheong vSugangsincheong, String personalData) {

		MSugangsincheong mSugangsincheong = new MSugangsincheong();
		mSugangsincheong.write(vSugangsincheong, personalData);

	}
	public void basketDelete(String personalData) {

		MSugangsincheong mSugangsincheong = new MSugangsincheong();
		mSugangsincheong.basketDelete(personalData);
	}
}
