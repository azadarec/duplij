package Windows;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Windows File System functions for the Application
 */
@Getter
public class WFileSystem {

    private final File[] paths = File.listRoots();
    private final FileSystemView fsv = FileSystemView.getFileSystemView();
    private HashMap<String, ArrayList<File>> orderedList;

    public WFileSystem() {
        fillOrderedList();
    }

    public WFileSystem(boolean sorted) {
        if(!sorted) {
            System.out.println("To be done");
            return;
        }
        fillOrderedList();

    }

    public void fillOrderedList() {
            orderedList = new HashMap<>();

            for (File path : paths) {

                String type = fsv.getSystemTypeDescription(path);
                ArrayList<File> pathArray = new ArrayList<>();

                if (orderedList.get(type) != null) {
                    pathArray = orderedList.get(type);
                }

                pathArray.add(path);
                orderedList.put(type, pathArray);
            }
    }

    public void searchDuplicateFileNames() {
        String[] fileNames;

        for(String key : orderedList.keySet()) {
            ArrayList<File> currentRoot = orderedList.get(key);
            getAllFilenamesInRoot(currentRoot);
        }
    }

    private void getAllFilenamesInRoot(@NotNull ArrayList<File> files) {
//        String[] fileNames;

        for(File f : files) {
            String temp = f.getName();
            System.out.println(temp);
        }

    }

}
