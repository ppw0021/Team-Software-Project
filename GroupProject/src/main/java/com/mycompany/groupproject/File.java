
package com.mycompany.groupproject;


abstract class File {
   
    private String DocumentName;
    private String Author;
    private String Password;

    public File(String documentName, String author,String password) {
        this.DocumentName = documentName;
        this.Author = author;
        this.Password=password;
    }

    public String getDocumentName() {
        return DocumentName;
    }

    public void setDocumentName(String DocumentName) {
        this.DocumentName = DocumentName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    

    
}

