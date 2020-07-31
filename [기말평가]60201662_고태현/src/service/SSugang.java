package service;

import java.util.Vector;

import model.MBasket;
import model.MSugang;
import valueObject.VBasket;
import valueObject.VSugang;

public class SSugang {
	public Vector<VSugang> read(String personalData) {

		MSugang mSugang = new MSugang();
		return mSugang.read(personalData);
	}

	public void write(VSugang vSugang, String personalData) {
		MSugang mSugang = new MSugang();
		mSugang.write(vSugang, personalData);
	}

}
