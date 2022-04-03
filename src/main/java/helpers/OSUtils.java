package helpers;


public class OSUtils {

    private static String operatingSystem = null;

    public OSUtils() {
        operatingSystem = System.getProperty("os.name");
    }

    public boolean isWindows() {
        return operatingSystem.toLowerCase().startsWith("win");
    }

    public boolean isUnix() {
        return operatingSystem.toLowerCase().indexOf("nix") > 0;
    }


}
