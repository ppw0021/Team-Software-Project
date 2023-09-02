package com.mycompany.groupproject;

import java.io.File;

public abstract class AbstractFile {

    private File thisFile;

    public AbstractFile() {

    }

    public AbstractFile(File thisFile) {
        this.thisFile = thisFile;
    }

    public void setThisFile(File file) {
        this.thisFile = file;
    }

    public File getThisFile() {
        return this.thisFile;
    }

    public File getThisFileEdits() {
        String fileName = this.thisFile.getName();
        String originalFilePath = this.thisFile.getPath();
        String editsFilePath = (originalFilePath.replace(fileName, "") + "EDITS_" + fileName);
        return new File(editsFilePath);
    }

    public void create(String DocumentName) {}
    
    void viewFile(String directoryPath, int fileNumber, boolean set, boolean viewEdits) {}
    
    public int findAndReplace(String find, String replace) {
        return 3;
    }

    public void deleteFileAndEdits() {}
}
