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

    
    public void create(String DocumentName) {
    }

    ;
    
    void viewOrSetFile(String directoryPath, int fileNumber, int status) {
    }

    ;
    
    public boolean findAndReplace(String find, String replace) {
        return false;
    }

}
