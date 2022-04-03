import Windows.WindowsMain;
import helpers.OSUtils;

public class Main {

    public static void main(String[] args) {
        OSUtils OsU = new OSUtils();
        if(OsU.isWindows()) {
            WindowsMain.main();
        }

    }
}
