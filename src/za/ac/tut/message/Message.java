/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.message;

import za.ac.tut.messagedatainterface.MessageDataInterface;
import za.ac.tut.messageexception.MessageException;

/**
 *This class represents a Message. A Message has got a text as an attribute.
 * @author Kgodiso
 */
public class Message implements MessageDataInterface
{
    /**
     * The text is the only attribute of the Message class.
     */
    //prviate fields
    private String text;
    
    /**
     * This a parameterized constructor 
     * @param text 
     */
    //constructor
    public Message(String text) throws MessageException {
        setText(text);
    }
    
    //getter and setters 
    /**
     * 
     * @return the text
     */
    public String getText() {
        return text;
    }
    
    /**
     * 
     * @param text 
     */
    public void setText(String text) throws MessageException 
    {
        if(isValidText(text))
        {   
                this.text = text;
        }
        else 
        {
            throw new MessageException(ERROR_MSG);
        }    
    }
    /**This is helper method checking if a text is valid and not kept empty.
     * @param text
     */
    private boolean isValidText(String text)
    {
        boolean isValid=false;
        
        if(text.length()>=MIN_TEXT_SIZE)
        {
            isValid=true;
        }    
        return isValid;
    }        
    
    //to String method
    /**
     * 
     * @return String that carries the current state of Message 
     */
    @Override
    public String toString() {
        return "Message{" + "text=" + text + '}';
    }
    
    
}
