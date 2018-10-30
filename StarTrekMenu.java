//Andre Barajas
//Professor Opkins
//CECS277
//FileI/OProject- Adapter
//November 2017
//This program simulates the Universal Adapter from Star Trek. Where Klingon, Vulcan and English are compatible languages. 

import java.util.*;
import java.io.*;
/**Class to test humanMessage object*/
public class StarTrekMenu
{
               public static void main(String[] args) throws FileNotFoundException
               {
                      Scanner input = new Scanner(System.in);
                      HumanMessage ecoSignal = new HumanMessage();
                      
                      ecoSignal.menu(input);
               }
}