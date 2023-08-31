package com.mycompany.groupproject;

abstract class AbstractFile {

    private String DocumentName;
    private String DocumentEditsName;
    //private String Password;

    public AbstractFile(String documentName, String documentEditsName) {
        this.DocumentName = documentName;
        this.DocumentEditsName = documentEditsName;
        //this.Password = password;
    }

    public void create(String DocumentName) {
    }

    ;
    
    public String getDocumentName() {
        return DocumentName;
    }

    public void setDocumentName(String DocumentName) {
        this.DocumentName = DocumentName;
        this.DocumentEditsName = ("EDITS_" + DocumentName);
    }
/*
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
*/
}
