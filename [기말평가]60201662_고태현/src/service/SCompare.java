package service;

import java.io.IOException;

import model.MPersonalInfo;
import valueObject.VLogin;
import valueObject.VPersonalInfo;

public class SCompare {
	public VPersonalInfo compare(VPersonalInfo vPersonalInfo) throws IOException {

		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		vPersonalInfo = mPersonalInfo.compare(vPersonalInfo);

		if (vPersonalInfo.compareid.equals(vPersonalInfo.id1)) {
			return vPersonalInfo;
		} else {
			return null;
		}
	}
}
