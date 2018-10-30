//Andre Barajas
//Professor Opkins
//CECS277
//FileI/OProject- Adapter
//November 2017
//This program simulates the Universal Adapter from Star Trek. Where Klingon, Vulcan and English are compatible languages. 
import java.io.*;
import java.util.*;

public class HumanMessage implements EarthCellPhone
{
    UniversalTAdapter adapter;
    int fileExCounter = 1;
    private File fileName0;
    private int communicating = 1;
    private int readSend, kOrv, messageType;
    private  String fileName,languageType, message;
    private String bankOfOptions[] = {"klingon", "vulcan", "english", "Hello World!", "Peace", "War"};
    
    /** Default Constructor */
    public HumanMessage() {} //Default constructor 
    /** Method to send a message in one of three languages.
     * @param String languageType
     * @param String fileName
     * @param String message
     */
    public void sendMessage(String languageType, String fileName, String message) throws FileNotFoundException
     {
                this.message = message;
                this.languageType = languageType;
                this.fileName = fileName;
                if(languageType.equalsIgnoreCase("english"))
                {
                    PrintStream output = new PrintStream(fileName0);
                    System.out.println("\nLoading transcript....\n\n\n\n");
                    System.out.println(toString());
                    output.print(message);
                    output.close();
                }
                else if(languageType.equalsIgnoreCase("vulcan") || languageType.equalsIgnoreCase("klingon"))
                {
                    adapter = new UniversalTAdapter(languageType);
                    adapter.sendMessage(languageType, fileName, message);
                }
               
    }
     /** Method to read a message in one of three languages.
     * @param String languageType
     * @param String fileName
     * @param String message
     */
    public void readMessage(String languageType, String fileName) throws FileNotFoundException
    {
               if(languageType.equalsIgnoreCase("english"))
                {
                     Scanner input = new Scanner(fileName0);
                     while(input.hasNext())
                     {
                         System.out.println("\n Reading message....\n");
                          System.out.println("File name is: \t\t\t\"" + fileName + "\"\n" + "The " + languageType + " message reads:\t\t" + input.nextLine());
                          
                     }
                     input.close();
                }
                else if(languageType.equalsIgnoreCase("vulcan") || languageType.equalsIgnoreCase("klingon"))
                {
                    adapter = new UniversalTAdapter(languageType);
                    adapter.readMessage(languageType, fileName);
                }
                else 
                {
                    throw new UnknownOptionException("Error: " + languageType + " is not supported by this application, please try again next time.");
                }
    }
    /** Method to display Menu
     * @param Scanner input
     */
    public void menu(Scanner input) throws FileNotFoundException
    {
                        do
                       {
                             menu0(input);
                                 if( readSend == 2)
                                 {
                                         communicating = 0;
                                         break;
                                 }
                             fileExCounter--;
                             if (readSend == 0)
                             {
                                 menu1(input);       
                                 menu2(input);
                                       if(messageType == 7)
                                       {
                                            communicating = 0;
                                            break;
                                       }
                                       
                                       do
                                       {
                                          System.out.println("\t\t*****Please enter a file name or 0 to exit\t\t*****");
                                          if (fileExCounter == 1) 
                                           {
                                         System.out.println("\n\nError: File already exists, try again...\n\n");
                                         fileExCounter--;
                                        }
                                        fileName = input.next();
                                           if (fileName == "0"){  kOrv = 3; break; }
                                           fileName0 = new File(fileName);
                                           ++fileExCounter;
                                        } while(fileName0.exists());
                                       System.out.println("\nValidating user selections...\n\n");
                                       if( kOrv == 3)
                                        {
                                              communicating = 0;
                                              break;
                                        }
                                        
                                       
                                       sendMessage(bankOfOptions[kOrv], fileName, bankOfOptions[messageType]);
                             }
                             
                             else if ( readSend == 1)
                             {
                                 menu1(input);       
                                 
                                       if(kOrv == 7)
                                       {
                                            communicating = 0;
                                            break;
                                       }
                                       do
                                       {
                                           System.out.println("\t\t*****Please enter a file name or 0 to exit\t\t*****");
                                            if (fileExCounter == 1) 
                                          {
                                                 System.out.println("\n\nError: File doesn't already exists, try again...\n\n");
                                                 fileExCounter--;
                                          }
                                          fileName = input.next();
                                           if (fileName.charAt(0) == '0'){  kOrv = 3; break; }
                                           fileName0 = new File(fileName);
                                           ++fileExCounter;
                                    }while(!fileName0.exists());
                                 System.out.println("\nValidating user selections...\n\n");
                                 if( kOrv == 3)
                                 {
                                              communicating = 0;
                                              break;
                                 }
                                 
                                 readMessage(bankOfOptions[kOrv], fileName);
                             }
                        } while(communicating != 0);
    }
   
    public void menu0(Scanner input)
    {
                        System.out.println("\n\n\t\t******Send or Read a Message*******\t\t");
                        System.out.println("0. Send a message.");
                        System.out.println("1. Read a message.");
                        System.out.println("2. Exit\n");
                        readSend = input.nextInt();
                        if (readSend < 0 || readSend > 2)
                        {
                             throw new UnknownOptionException("Error: " + readSend + " is not supported by this application, please try again next time.");
                        }
    }
     /** Method to display send of Language option
     * @param Scanner input
     */
    public void menu1(Scanner input)
    {
                System.out.println("\t\t******Klingon, Vulcan or English Message*******\t\t");
                System.out.println("0. Klingon");
                System.out.println("1. Vulcan");
                System.out.println("2. English");
                System.out.println("3. Exit\n");
                kOrv = input.nextInt();
                if (kOrv < 0 || kOrv > 3)
                {
                        throw new UnknownOptionException("Error: " + kOrv + " is not supported by this application, please try again next time.");
                        
                }
    }
     /** Method to display message option
     * @param Scanner input
     */
    public void menu2(Scanner input)
    {
                System.out.println("\t\t******Choose a Message*******\t\t");
                System.out.println("4. Hello World!");
                System.out.println("5. Peace.");
                System.out.println("6. War!");
                System.out.println("7. Exit\n");
                messageType = input.nextInt();
                messageType -= 1;
                if (messageType < 3 || messageType > 7)
                {
                                 throw new UnknownOptionException("Error: " + messageType + " is not supported by this application, please try again next time.");
                }
    }
     /** @override Method to print a HumanMessage Object
     * @return String 
     */
    public String toString() 
    {
        return ("File name is: \t\t\t\"" + fileName + "\"\n" + "The " + languageType + " message reads:\t\t\t" + message);
    }
}
