package service;

import model.MPersonalInfo;
import valueObject.VPersonalInfo;

// 개인정보 입력 서비스
public class SRegistration {
	public void write(VPersonalInfo vPersonalInfo) {
		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		mPersonalInfo.write(vPersonalInfo);
	}
}
