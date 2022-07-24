package Interfaces;

import Objects.FileObject;

import java.util.List;

public interface DFileSystem {

    public void searchDuplicateFileHashes();

    public void searchDuplicateFileNames();

    public void searchDuplicateDirHashes();

    public void searchDuplicateDirNames();

}
