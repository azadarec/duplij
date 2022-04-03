package Windows;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WindowsMain {

    public static void main() {
        WFileSystem fs = new WFileSystem();
        fs.searchDuplicateFileNames();
    }
}
