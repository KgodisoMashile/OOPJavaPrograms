/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.messagemanagerinterface;

import java.util.List;
import java.util.Map;
import za.ac.tut.message.Message;
import za.ac.tut.messageexception.MessageException;

/**
 *This a Message interface that defines all the abstract methods implemented by the Message manager class.
 * @author Kgodiso
 */
public interface MessageManagerInterface {
   
    public int determineSize(Message message) throws MessageException;
    public int determineNumberOfWhiteSpaces(Message message) throws MessageException;
    public int determineNumberOfCommas(Message message) throws MessageException;
    public int determineNumberOfFullStops(Message message) throws MessageException;
    public  Map<String, Integer> determineWordsFrequence(List<String> words);
    public List<String> getWords(Message message) throws MessageException;
}
