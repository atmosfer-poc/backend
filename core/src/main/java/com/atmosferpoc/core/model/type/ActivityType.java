package com.atmosferpoc.core.model.type;


public enum ActivityType implements BaseTypeEnum {

	EXCEL_USER_IMPORT("%s başarılı %s başarısız kayıt. (%s)"),
	LDAP_ADD("%s"),
	MANUAL_USER_ADD("%s kullanıcısı kaydedildi."),
	RESET_PASSWORD("%s kullanıcı");

	private String value;

	ActivityType(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}
}