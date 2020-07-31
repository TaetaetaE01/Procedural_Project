package service;

import java.io.IOException;

import model.MPersonalInfo;
import valueObject.VPersonalInfo;

public class SFind {
	public VPersonalInfo findid(VPersonalInfo vPersonalInfo) throws IOException {

		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		vPersonalInfo = mPersonalInfo.findid(vPersonalInfo);

		if (vPersonalInfo.findid.equals(vPersonalInfo.number)) {
			return vPersonalInfo;
		} else {
			return null;
		}
	}

	public VPersonalInfo findpw(VPersonalInfo vPersonalInfo) throws IOException {

		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		vPersonalInfo = mPersonalInfo.findid(vPersonalInfo);

		if (vPersonalInfo.id1.equals(vPersonalInfo.findpw)) {
			return vPersonalInfo;
		} else {
			return null;
		}
	}
}
