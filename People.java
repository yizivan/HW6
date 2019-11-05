public class People
{
    private String First_name, Middle_name, Last_name, Street_address, City_name, State_name;
    private char Gender;
    private int Age, Height_inch, Zip_code;
    private double Weight;
    public People()
    {

    }
    public void SetFirst_name(String firstname)
    {
        First_name = firstname;
    }
    public void SetMiddle_name(String middlename)
    {
        Middle_name = middlename;
    }
    public void SetLast_name(String lastname)
    {
        Last_name = lastname;
    }
    public void SetStreet_address(String streetaddress)
    {
        Street_address = streetaddress;
    }
    public void SetCity_name(String cityname)
    {
        City_name = cityname;
    }
    public void SetState_name(String statename)
    {
        State_name = statename;
    }
    public void SetGender(char gender)
    {
        Gender = gender;
    }
    public void SetAge(int age)
    {
        Age = age;
    }
    public void SetHeight_inch(int heightinch)
    {
        Height_inch = heightinch;
    }
    public void SetZip_code(int zipcode)
    {
        Zip_code = zipcode;
    }
    public void SetWeight(double weight)
    {
        Weight = weight;
    }
    public String GetFirst_name()
    {
        return First_name;
    }
    public String GetMiddle_name()
    {
        return Middle_name;
    }
    public String GetLast_name()
    {
        return Last_name;
    }
    public String GetStreet_address()
    {
        return Street_address;
    }
    public String GetCity_name()
    {
        return City_name;
    }
    public String GetState_name()
    {
        return State_name;
    }
    public char GetGender()
    {
        return Gender;
    }
    public int GetAge()
    {
        return Age;
    }
    public int GetHeight_inch()
    {
        return Height_inch;
    }
    public int GetZip_code()
    {
        return Zip_code;
    }
    public double GetWeight()
    {
        return Weight;
    }
}