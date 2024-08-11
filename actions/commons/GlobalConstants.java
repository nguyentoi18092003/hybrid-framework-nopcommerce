package commons;

import java.io.File;

public class GlobalConstants {
    //server url: Dev, Testing/stating/product
    //Database: Dev/testing/Staging/Product
    //Timeout: Short/Long
    //Username/pass
    //third party: Sandbox Paypal
    //Download/upload folder
    //Relative Project Path
    //OS Name
    //clouding testing: Broserstack/Saucelab/CrossbroserTesting(Access Token/ID)
    public static final String DEV_USER_URL="https://demo.nopcommerce.com";
    public static final String DEV_ADMIN_URL="https://admin-demo.nopcommerce.com";
    public static final long SHORT_TIMEOUT=5;
    public static final long LONG_TIMEOUT=10;
    public static final String DEV_ADMIN_USERNAME="admin@yourstore.com";
    public static final String DEV_ADMIN_PASSWORD="admin";
    public static final String OS_NAME=System.getProperty("os.name");
    public static final String RELATIVE_PROJECT_PATH=System.getProperty("user.dir");
    public static final String UPLOAD_PATH=RELATIVE_PROJECT_PATH+ File.separator+"uploadFiles"+File.separator;//File.separator no se tu biet lauy "\" doi vs window vaf "/" vs mac
    public static final String DOWNLOAD_PATH=RELATIVE_PROJECT_PATH+File.separator+"downloadFiles"+File.separator;
    public static final String REPORT_IMAGE_PATH=RELATIVE_PROJECT_PATH+File.separator+"reportNGImage"+File.separator;


    public static final String JAVA_VERSION = System.getProperty("java.version");
}
