package fw.loginModule;

import java.io.IOException;
import java.util.Properties;

import fw.utilities.BaseClass;

public class LoginModuleTestData {

	BaseClass baseclass = new BaseClass();

	public String putUserName() throws IOException {
		String basePath = System.getProperty("user.dir");
		Properties masterdata_properties = BaseClass
				.getPropertyControl(basePath + "/configuration/masterdata.properties");
		String nopcomm_username = masterdata_properties.getProperty("nopcomm_username");
		return nopcomm_username;
	}

	public String putPassword() throws IOException {
		String basePath = System.getProperty("user.dir");
		Properties masterdata_properties = BaseClass
				.getPropertyControl(basePath + "/configuration/masterdata.properties");
		String nopcomm_password = masterdata_properties.getProperty("nopcomm_password");
		return nopcomm_password;
	}
	
	public String putinvalidUserName() throws IOException {
		String basePath = System.getProperty("user.dir");
		Properties masterdata_properties = BaseClass
				.getPropertyControl(basePath + "/testdata/loginModule.properties");
		String nopcomm_password = masterdata_properties.getProperty("nopcomm_username_invalid");
		return nopcomm_password;
	}
	
	public String putinvalidPassword() throws IOException {
		String basePath = System.getProperty("user.dir");
		Properties masterdata_properties = BaseClass
				.getPropertyControl(basePath + "/testdata/loginModule.properties");
		String nopcomm_password = masterdata_properties.getProperty("nopcomm_password_invalid");
		return nopcomm_password;
	}
}
