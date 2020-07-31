package service;

import java.io.IOException;
import java.util.Vector;

import model.MHakgwa;
import valueObject.VHakgwa;

public class SHakgwa {

	public Vector<VHakgwa> getData(String fileName) {
		MHakgwa mCampus = new MHakgwa();
		return mCampus.getData(fileName);
	}

}
