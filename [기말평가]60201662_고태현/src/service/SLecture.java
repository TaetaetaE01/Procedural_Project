package service;

import java.io.IOException;
import java.util.Vector;

import model.MHakgwa;
import model.MLecture;
import valueObject.VHakgwa;
import valueObject.VLecture;

public class SLecture {

	public Vector<VLecture> read(String fileName) throws IOException {

		MLecture mLecture = new MLecture();
		return mLecture.read(fileName);
	}
}
