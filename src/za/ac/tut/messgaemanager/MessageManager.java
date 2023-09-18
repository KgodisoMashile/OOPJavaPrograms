/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.messgaemanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import za.ac.tut.filemanagerinterface.FileManagerInterface;
import za.ac.tut.message.Message;
import za.ac.tut.messageexception.MessageException;
import za.ac.tut.messagemanagerinterface.MessageManagerInterface;

/**
 *This is the manager class that implements all the Message abstract methods.
 * @author Kgodiso
 */
public class MessageManager implements MessageManagerInterface,FileManagerInterface{

    /**
     * This method determines and returns the size of the text in bytes.
     * @param message
     * @return
     * @throws MessageException 
     */
    @Override
    public int determineSize(Message message) throws MessageException{
      int size;
      
      size=message.getText().getBytes().length*8;
      
      return size;
    }
    /**
     * This method determines and return the number of white spaces int the text.
     * @param message
     * @return
     * @throws MessageException 
     */
    @Override
    public int determineNumberOfWhiteSpaces(Message message) throws MessageException{
            
            String msg=message.getText();
            int whiteSpaceCount=0;
            for(int j=0;j<msg.length();j++)
            {
                    char character=msg.charAt(j);
                if(Character.isWhitespace(character))
                {
                   whiteSpaceCount ++;
                }
                
             }
            
            return whiteSpaceCount;
    }
    /**
     * This method determines and returns the number of commas in the text.
     * @param message
     * @return
     * @throws MessageException 
     */
    @Override
    public int determineNumberOfCommas(Message message) throws MessageException
    {
        String msg=message.getText();
         int commaCount=0;
                
            for(int k=0;k<msg.length();k++)
             {
                    char character=msg.charAt(k);
                    if(character==',')
                    {
                        commaCount++;
                    }  
                   
              }
            return commaCount;
    }
    /**
     * This method determines and return the number of full stops
     * @param message
     * @return
     * @throws MessageException 
     */
    @Override
    public int determineNumberOfFullStops(Message message) throws MessageException
    {
        String msg=message.getText();
         int fullStopCount=0;
                
            for(int k=0;k<msg.length();k++)
             {
                    char character=msg.charAt(k);
                    if(character=='.')
                    {
                        fullStopCount++;
                    }  
                   
              }
            return fullStopCount;
    }
    /**
     * This method determines, stores the word as a key and number of time it appears as a value in a Hashmap. It them returns the the Map to the user. 
     * @param words
     * @return 
     */
    @Override
    public Map<String, Integer> determineWordsFrequence(List<String> words) 
    {
        //diplaying all the words
        for(String word : words)
        {
            System.out.println(word);
        }
       
        //create a map
        Map <String,Integer> wordMap=new HashMap<>();
        int count;
        
        for(String word : words)
        {
            if(wordMap.containsKey(word))
            {
                count=wordMap.get(word);
                count++;
                wordMap.put(word,count);
            }    
            else
            {
                wordMap.put(word, 1);
            }  
        }
        
        return wordMap;
    }

    /**
     * This method reads from a file and returns the Message object.
     * @param file
     * @return
     * @throws IOException
     * @throws MessageException 
     */
    @Override
    public Message getMessage(File file) throws IOException, MessageException {
       BufferedReader br = new BufferedReader(new FileReader(file));
        String data, text = "";

        while((data = br.readLine()) != null)
        {
                text = text.concat(data);
        }

                br.close();

                Message message = new Message(text);

    return message;

    }
    /**
     * This method stores the text message and extra details about the message  to a text file.
     * @param message
     * @param file
     * @param numWhiteSpaces
     * @param numCommas
     * @param numFullStops
     * @param numWords
     * @param size
     * @param frequenceOfOccurence
     * @throws IOException
     * @throws MessageException 
     */

    @Override
    public void storeMessageStatistics(Message message, File file, int numWhiteSpaces,int numCommas, int numFullStops, int numWords, int size, Map<String, Integer> frequenceOfOccurence) throws IOException ,MessageException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
 
        bw.write(message.toString());
        bw.newLine();
        bw.newLine();
        bw.write("Message statictics");
        bw.newLine();
        bw.write("Size: " + size + " bytes");
        bw.newLine();
        bw.write("Number of whitespaces: " + numWhiteSpaces);
        bw.newLine();
        bw.write("Number of commas: " + numCommas);
        bw.newLine();
        bw.write("Number of fullstops: " + numFullStops);
        bw.newLine();
        bw.newLine();
        bw.write("Frequency of occurence of words");

        for(Map.Entry<String,Integer> entry : frequenceOfOccurence.entrySet())
        {
            bw.write(entry.getKey() + " : " + entry.getValue());
            bw.newLine();
        }

        bw.close();

    }
    @Override
 public List<String> getWords(Message message) throws MessageException {
        Message cleanMessage = removeSpecialCharacters(message);
        String[] messageTokens = cleanMessage.getText().split(" ");
        List<String> words = new ArrayList<>();
 
            for(String word:messageTokens){
            words.add(word);
            }
 
 return words;
 }
 private Message removeSpecialCharacters(Message message) throws MessageException, MessageException {
    char charAtIndex;
    String newText = "";
    String text = message.getText();

            for(int i = 0; i < text.length(); i++)
            {
                charAtIndex = text.charAt(i);

                        if(Character.isLetterOrDigit(charAtIndex)){
                        newText = newText + Character.toString(charAtIndex);
                } 
                else 
                {
                if(Character.isWhitespace(charAtIndex)){
                            newText = newText + " ";
                            }
                }
             }
            
                Message newMessage = new Message(newText); 
                return newMessage;
            }
}
 

    

