//Andre Barajas
//Professor Opkins
//CECS277
//FileI/OProject- Adapter
//November 2017
//This program simulates the Universal Adapter from Star Trek. Where Klingon, Vulcan and English are compatible languages. 
import java.io.*;

public class UniversalTAdapter implements EarthCellPhone
{
    AlienCellPhone extraTer;
    /** Default constructor */
    public UniversalTAdapter() {} //Default constructor
    /**Overloaded Constructor 
     * @param String language
     * method to create Vulcan or Klingon message
     */
    public UniversalTAdapter(String language)
    {
        if(language.equalsIgnoreCase("Vulcan"))
        {
            extraTer = new VulcanMessage();
        }else if(language.equalsIgnoreCase("klingon"))
        {
            extraTer = new KlingonMessage();
        }
    }
    /** Method to call sendMessage from alianCellphone based objects
     * @param String language 
     * @param String fileName
     * @param String message
     */
    public void sendMessage(String language, String fileName,  String message) throws FileNotFoundException
    {
        if(language.equalsIgnoreCase("Vulcan"))
        {
             extraTer.sendMessage(language,fileName , message);
        }else if(language.equalsIgnoreCase("klingon"))
        {
             extraTer.sendMessage(language,fileName , message);
        }
    }
    /** Method to call readMessage from alianCellphone based objects
     * @param String language 
     * @param String fileType/Name
     */
    public void readMessage(String language, String fileType) throws FileNotFoundException
    {
        if(language.equalsIgnoreCase("Vulcan"))
        {
            extraTer.readMessage(language, fileType);
        }else if(language.equalsIgnoreCase("klingon"))
        {
           extraTer.readMessage(language, fileType);
        }
    }
}
