/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package textapp;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import za.ac.tut.message.Message;
import za.ac.tut.messageexception.MessageException;
import za.ac.tut.messgaemanager.MessageManager;

/**
 *
 * @author Kgodiso
 */
public class TextApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          // Declarations
            MessageManager mm=new MessageManager();
           File file1=new File("./messages.txt");
            File file2=new File("./stats.txt");
            int numCommas,numFullStops,numWhiteSpaces,size;
        try {
          
            Message message=mm.getMessage(file1);
            
            //determinig the text details
            size=mm.determineSize(message);
            numFullStops=mm.determineNumberOfFullStops(message);
            numWhiteSpaces=mm.determineNumberOfWhiteSpaces(message);
            numCommas=mm.determineNumberOfCommas(message);
            
            //getting the words with the special characters removed
            List<String> words=mm.getWords(message);
            Map<String,Integer> frequentWords=mm.determineWordsFrequence(words);
            
            //display everything
            System.out.println("The message is "+message.getText());
            System.out.println("The size is "+size);
            System.out.println("The number of full stops are "+numFullStops);
            System.out.println("The number of white spaces are "+numWhiteSpaces);
            System.out.println("The number of commas are "+numCommas); 
            System.out.println("How frequently the words were used:");
            
            for(Map.Entry<String,Integer> ent:frequentWords.entrySet())
            {
                System.out.println(ent.getKey()+":"+ent.getValue());
            }   
            
            //storing statstistically
            mm.storeMessageStatistics(message, file2, numWhiteSpaces, numCommas, numFullStops, numCommas, size, frequentWords);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error message for file",JOptionPane.ERROR_MESSAGE);
        } catch (MessageException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error message for the text",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
