/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.filemanagerinterface;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import za.ac.tut.message.Message;
import za.ac.tut.messageexception.MessageException;

/**
 *
 * @author Kgodiso
 */
public interface FileManagerInterface 
{
    public Message getMessage(File file) throws IOException, MessageException;
    public void storeMessageStatistics(Message message, File file, int numWhiteSpaces,int numCommas,int numFullStops,int numWords, int size, Map<String, Integer> words) throws IOException, MessageException;
}
