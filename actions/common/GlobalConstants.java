package common;

import java.io.File;

public class GlobalConstants {
	public static final String USER_URL_LINK = "https://demo.nopcommerce.com/";
	public static final String ADMIN_URL_LINK = "https://admin-demo.nopcommerce.com/";
	public static final String ADMIN_LIVE_GURU_URL_LINK = "http://live.techpanda.org/index.php/backendlogin/customer/";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFile" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFile";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";

	// SERVER/DB/ACCOUNT/PASSWORD
	public static final String DB_TEST = "";
	public static final String ACCOUNT_TEST = "";
	public static final String PASSWORD_TEST = "";

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;

}
