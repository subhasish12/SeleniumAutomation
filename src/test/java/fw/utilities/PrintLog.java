package fw.utilities;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PrintLog {

	static final Logger logger = LogManager.getLogger("LOG:");
	public static void getInfoLog(String info) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log/log.properties");
		logger.info(info);
	}

	public static void getErrorLog(String error) {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log/log.properties");
		BasicConfigurator.configure();
		logger.info(error);
	}

	public static void getWarnLog(String warn) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log/log.properties");
		logger.info(warn);
	}
}
