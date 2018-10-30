//Andre Barajas
//Professor Opkins
//CECS277
//FileI/OProject- Adapter
//November 2017
//This program simulates the Universal Adapter from Star Trek. Where Klingon, Vulcan and English are compatible languages. 

import java.io.*;
import java.util.*;
public class KlingonMessage implements AlienCellPhone
{
   private String text;
   private String bankofTranslations[] = {"qo' vIvan!", "roj", "veS ghotvam'e'", "Hello World!", "Peace.", "This is war!"};
   private File fileName0;
   private String fileName;
   private  String languageType;
   /** Default constructor*/
    public KlingonMessage(){ } //Default constructor 
    /** Overloaded default constructor 
     * @param String languageType
     * @param String fileName
     * @param String message
     * Method to Send a translated Klingon message to a file
     */
   public void sendMessage(String languageType, String fileName, String text) throws FileNotFoundException
   {
       this.text = text;
       this.languageType = languageType;
       this.fileName = fileName;
       PrintStream output = new PrintStream(new File(fileName));
       System.out.println("\nLoading transcript....\n\n\n\n");
       System.out.println("Human message: " + text +  "\n");
       System.out.println("\nTranslating message...\n\n");
       text = translateMessage(text);
       System.out.println(toString());
       output.println(text);
       output.close();
    }
     /** Overloaded default constructor 
     * @param String languageType
     * @param String fileName
     * @param String message
     * Method to Read a translated Klingon message from a file
     */
   public void readMessage(String languageType, String fileName)    throws FileNotFoundException 
   {
                   this.languageType = languageType;
                   this.fileName = fileName;
                   fileName0 = new File(fileName);
                   Scanner input = new Scanner(fileName0);
                     while(input.hasNext())
                     {
                        String text = input.nextLine();
                         System.out.println("\n Reading message....\n");
                         this.text = text;
                         System.out.println(toString());
                         System.out.println("\nTranslating message to English....\n");
                         translateMessage(text);
                         System.out.println("Message reads: \t" + this.text);
                     }
                     input.close();
    }
    /**Method to translate a message from english to Klingon
     * @param String message
     * @return String message
     */
   public String  translateMessage(String message)
   {
        if (message.charAt(0) == 'H')
       {
           text = bankofTranslations[0];
        }
        else if (message.charAt(0) == 'P')
        {
             text = bankofTranslations[1];
        }
        else if (message.charAt(0) == 'W')
        {
             text = bankofTranslations[2];
        }
         else if (message.charAt(0) == 'r')
        {
             text = bankofTranslations[4];
        }
        else if (message.charAt(0) == 'v')
        {
             text = bankofTranslations[5];
        }
        else 
        {
            text = bankofTranslations[3];
        }
        return text;
      
    }
    /**Override toString method to print a message object
     * @return String 
     */
     public String toString() {
        return ("File name is: \t\t\t\"" + fileName + "\"\n" + "The " + languageType + " message reads:\t" + text);
      }
}
