package service;

import java.io.IOException;
import java.util.Vector;

import model.MLecture;
import model.MPersonalInfo;
import model.MPlusfriend;
import valueObject.VFriend;
import valueObject.VLecture;
import valueObject.VPersonalInfo;
import valueObject.VSugangsincheong;

public class SPlusfriend {

	public VPersonalInfo plusfriend(VFriend vFriend, VPersonalInfo vPersonalInfo) throws IOException {

		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		vPersonalInfo = mPersonalInfo.plusfriend(vPersonalInfo);

		if (vPersonalInfo.id1.equals(vPersonalInfo.plusfriend)) {
			return vPersonalInfo;
		} else {
			return null;
		}
	}

	public void write(VFriend vFriend, String PersonalData) {
		MPlusfriend mPlusfriend = new MPlusfriend();
		mPlusfriend.write(vFriend, PersonalData);
	}

	public Vector<VFriend> read(String personalData) throws IOException {

		MPlusfriend mPlusfriend = new MPlusfriend();
		return mPlusfriend.read(personalData);
	}

	public Vector<VFriend> getFriend(String friendData) throws IOException {

		MPlusfriend mPlusfriend = new MPlusfriend();
		return mPlusfriend.getFriend(friendData);
	}
}
