
package com.mycompany.groupproject;


abstract class File {
   
    private String DocumentName;
    private String Password;

    public File(String documentName,String password) {
        this.DocumentName = documentName;
        
        this.Password=password;
    }

    public String getDocumentName() {
        return DocumentName;
    }

    public void setDocumentName(String DocumentName) {
        this.DocumentName = DocumentName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    

    
}

