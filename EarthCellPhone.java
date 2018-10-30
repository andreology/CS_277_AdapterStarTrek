//Andre Barajas
//Professor Opkins
//CECS277
//FileI/OProject- Adapter
//November 2017
//This program simulates the Universal Adapter from Star Trek. Where Klingon, Vulcan and English are compatible languages. 
import java.io.*;
/**EarthCellPhone interface*/
public interface EarthCellPhone
{
   public void sendMessage(String languageType,String fileName, String message) throws FileNotFoundException ;
           
   public void readMessage(String languageType, String fileName)throws FileNotFoundException;
}
