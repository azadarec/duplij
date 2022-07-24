package general;

import Interfaces.DFileSystem;
import Objects.FileObject;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class FileSystemOperations implements DFileSystem {

    private final ArrayList<File> roots;
    private List<FileObject> duplicates;

    public FileSystemOperations() {
        this.roots = new ArrayList<>(Arrays.asList(File.listRoots()));
    }

    public FileSystemOperations(File[] roots) {
        this.roots = new ArrayList<>(Arrays.asList(roots));
    }

    public FileSystemOperations(ArrayList<File> roots) {
        this.roots = roots;
    }

    @Override
    public void searchDuplicateFileHashes() {

    }

    @Override
    public void searchDuplicateFileNames() {

    }

    @Override
    public void searchDuplicateDirHashes() {

    }

    @Override
    public void searchDuplicateDirNames() {

    }

    private void recursiveFileSearch() {
        for(File root : roots) {

        }
    }
}
