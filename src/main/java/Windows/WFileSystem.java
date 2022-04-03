package Windows;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Windows File System functions for the Application
 * @author azadarec <azadarec@gmail.com>
 */
@Getter
@Slf4j
public class WFileSystem {

    private final File[] paths = File.listRoots();
    private final FileSystemView fsv = FileSystemView.getFileSystemView();
    private HashMap<String, ArrayList<File>> orderedList;
    private HashMap<String, ArrayList<File>> subdirsByRoot;

    public WFileSystem() {
        fillOrderedList();
        subdirsByRoot = new HashMap<>();
    }

    public WFileSystem(boolean sorted) {
        if(!sorted) {
            System.out.println("To be done");
            return;
        }
        fillOrderedList();
        subdirsByRoot = new HashMap<>();
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
            ArrayList<File> currentType = orderedList.get(key);
            iterateFsRoots(currentType);
        }
    }

    private void iterateFsRoots(@NotNull ArrayList<File> files) {

        for(File f : files) {
            getDirectoryList(f);
        }

    }
    private void setSubDirsByRoot(String key, File file) {

        ArrayList<File> arrayList;
        if(subdirsByRoot.get(key) == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList = subdirsByRoot.get(key);
        }
        arrayList.add(file);
        subdirsByRoot.put(key, arrayList);

    }

    private void getDirectoryList(@NotNull File file) {
        String rootDir = file.toString();
        try {
            Files.walkFileTree(file.toPath(), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {

                    File[] subdirectories = dir.toFile().listFiles(File::isDirectory);

                    assert subdirectories != null;

                    if (subdirectories.length == 0) {

                        setSubDirsByRoot(rootDir, dir.toFile());
                    }

                    return FileVisitResult.CONTINUE;

                }
            });
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

}
