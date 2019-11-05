
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javax.print.DocFlavor.READER;
public class FileHandling 
{
    private static ArrayList<People> myPeople = new ArrayList<People>();
    private static Scanner keyboard = new Scanner(System.in);
    private static String[] FirstNames = {"Abra", "Bretton", "Marry", "Bob", "Elizaba", "Amen", "Canberny", "Vanna", "Nhi", "Kevin"};
    private static String[] LastNames = {"Joe", "Tom", "Buble", "Venty", "Hong", "Henry", "Micus", "Isha", "Arthur"};
    private static String[] MiddleNames = {"S", "A", "B", "H", "P", "K", "L", "T", "C", "M"};
    private static String[] Genders = {"M", "F"};
    private static String[] StreetAddresses = {"6060 Pow St", "7612 Nova Rd", "2428 Fairhaven Ave", "2250 Huntington Ave", "5020 Port St", "705 First St"};
    private static String[] CityNames = {"Alexandria", "Burke", "Annadale", "Fairfax", "TysonCorner", "Roveill", "Centreville"};
    private static String[] StateNames = {"VA", "MD", "NY", "NJ", "PA", "CA", "BS"};
    public static int ReturnInt()
    {
        String str;
        Boolean bo;
        int enterint = 0;
        bo = false;
        do
        {
            try
            {
                str = keyboard.nextLine();
                enterint = Integer.valueOf(str);
                if (enterint <= 0)
                    enterint = Integer.valueOf("asd");
                bo = true;
            }
            catch(Throwable e)
            {
                System.out.println("wrong enter type, please enter an Int type number which is positive.");
                bo = false;
            }
        }
        while (!bo);
        return (enterint);
    }
    public static void RandomSetUpPeople(People people)
    {
        people.SetFirst_name(FirstNames[(int)(Math.random() * FirstNames.length)]);
        people.SetMiddle_name(MiddleNames[(int)(Math.random() * MiddleNames.length)]);
        people.SetLast_name(LastNames[(int)(Math.random() * LastNames.length)]);
        people.SetGender(Genders[(int)(Math.random() * Genders.length)].charAt(0));
        people.SetAge((int)(Math.random() * 70 + 1));
        people.SetWeight((double)((int)(Math.random() * 15000 +5000)) / 100);
        people.SetHeight_inch((int)(Math.random() * 100 + 50));
        people.SetStreet_address(StreetAddresses[(int)(Math.random() * StreetAddresses.length)]);
        people.SetCity_name(CityNames[(int)(Math.random() * CityNames.length)]);
        people.SetState_name(StateNames[(int)(Math.random() * StateNames.length)]);
        people.SetZip_code((int)(Math.random() * 90000 + 10000));
    }
    public static void main(String[] args)
    {
        try
        {
            File myFile = new File("People.txt");
            if (!myFile.exists()) 
            {
                myFile.createNewFile();
            }
            FileWriter OutPut = new FileWriter(myFile);
            System.out.println("How many people you want to add to the txt file? (Please enter a positive int number)");
            int PeopleAmount = ReturnInt();
            for (int i = 0; i < PeopleAmount; i ++)
            {
                People newPeople = new People();
                RandomSetUpPeople(newPeople);
                myPeople.add(newPeople);
            }
            for (int i = 0; i < myPeople.size(); i++)
            {
                OutPut.write(myPeople.get(i).GetFirst_name() + ",");
                OutPut.write(myPeople.get(i).GetMiddle_name() + ",");
                OutPut.write(myPeople.get(i).GetLast_name() +",");
                OutPut.write(myPeople.get(i).GetGender() + ",");
                OutPut.write(myPeople.get(i).GetAge() + ",");
                OutPut.write(myPeople.get(i).GetWeight() + ",");
                OutPut.write(myPeople.get(i).GetHeight_inch() + ",");
                OutPut.write(myPeople.get(i).GetStreet_address() + ",");
                OutPut.write(myPeople.get(i).GetCity_name() + ",");
                OutPut.write(myPeople.get(i).GetState_name() + ",");
                OutPut.write(myPeople.get(i).GetZip_code() + "\r\n");
            }
            OutPut.close();
        }   
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            File OpenFile = new File("People.txt");
            FileReader InPut = new FileReader(OpenFile);
            BufferedReader BuffInPut = new BufferedReader(InPut);
            String str;
            while ((str = BuffInPut.readLine()) != null)
            {
                People ReadingPeople = new People();
                String[] ArrayStr = str.split(",");
                ReadingPeople.SetFirst_name(ArrayStr[0]);
                ReadingPeople.SetMiddle_name(ArrayStr[1]);
                ReadingPeople.SetLast_name(ArrayStr[2]);
                ReadingPeople.SetGender(ArrayStr[3].charAt(0));
                ReadingPeople.SetAge(Integer.valueOf(ArrayStr[4]));
                ReadingPeople.SetWeight(Double.valueOf(ArrayStr[5]));
                ReadingPeople.SetHeight_inch(Integer.valueOf(ArrayStr[6]));
                ReadingPeople.SetStreet_address(ArrayStr[7]);
                ReadingPeople.SetCity_name(ArrayStr[8]);
                ReadingPeople.SetState_name(ArrayStr[9]);
                ReadingPeople.SetZip_code(Integer.valueOf(ArrayStr[10]));
                System.out.println(ReadingPeople.GetFirst_name() + ", " + ReadingPeople.GetMiddle_name() + " " + ReadingPeople.GetLast_name() + " Age: " + ReadingPeople.GetAge() + " Gender: " + ReadingPeople.GetGender() + " Height: " + ReadingPeople.GetHeight_inch() + " Weight: " + ReadingPeople.GetWeight());
                System.out.println(ReadingPeople.GetStreet_address());
                System.out.println(ReadingPeople.GetCity_name() + ", " + ReadingPeople.GetState_name() + " " + ReadingPeople.GetZip_code());
            }
            BuffInPut.close();
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}