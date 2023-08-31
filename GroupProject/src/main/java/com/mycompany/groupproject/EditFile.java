/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupproject;

/**
 *
 * @author dec50
 */
public class EditFile extends AbstractFile{
    
    public EditFile(String fileName)
    {
        super(fileName, ("EDITS_" + fileName));
    }
}
