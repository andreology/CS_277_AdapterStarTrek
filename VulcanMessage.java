//Andre Barajas
//Professor Opkins
//CECS277
//FileI/OProject- Adapter
//November 2017
//This program simulates the Universal Adapter from Star Trek. Where Klingon, Vulcan and English are compatible languages. 
import java.io.*;
import java.util.*;
public class VulcanMessage implements AlienCellPhone
{
   private String text;
   private String fileName;
    private File fileName0;
    private  String languageType;
   private String bankofTranslations[] = {"tonk'peh panu!", "sochya", "Nash tor t'naehm", "Hello World!", "Peace.", "War!"};
   public VulcanMessage(){} //Defualt Constructor
   public void sendMessage(String languageType, String fileName, String text) throws FileNotFoundException
   {
       this.text = text;
       this.languageType = languageType;
       this.fileName = fileName;
       PrintStream output = new PrintStream(new File(fileName));
       System.out.println("\nLoading transcript....\n\n\n\n");
       System.out.println("Human message: " + text +  "\n");
       System.out.println("\nTranslating message...\n\n");
       this.text = translateMessage(text);
       
       System.out.println(toString());
       output.println(text);
       output.close();
    }
   public void readMessage(String languageType, String fileName) throws FileNotFoundException
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
   public String translateMessage(String message)
   {
     
       if (message.charAt(0) == 'H')
       {
           text = bankofTranslations[0];
        }else if (message.charAt(0) == 'P')
        {
             text = bankofTranslations[1];
        }
        else if (message.charAt(0) == 'W')
        {
             text = bankofTranslations[2];
        }
         else if (message.charAt(0) == 'T')
        {
             text = bankofTranslations[3];
        }
        else if (message.charAt(0) == 's')
        {
             text = bankofTranslations[4];
        }
        else 
        {
            text = bankofTranslations[5];
        }
        return text;
   }
   /** @override Method to print a HumanMessage Object
     * @return String 
     */
    public String toString() {
        return ("File name is: \t\t\t\"" + fileName + "\"\n" + "The " + languageType + " message reads:\t\t\t" + text);
      }
}
