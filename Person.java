/**
 * This class represents a Person object
 *
 * @author Ori Segev
 * @version 2024a
 */
public class Person
{
    //=========================
    private String _name;
    private String _id;
    private Date _dateOfBirth;
    //======= FINALS ==========
    private final String DEFAULT_NAME = "Someone";
    private final String DEFAULT_ID = "000000000";
    private final int MIN_NAME_LENGTH = 0;
    private final int ID_LENGTH = 9;
    //========================================
    /**
     * Person Constructor - create new person
     * @param name the person's name. If name is an empty string, assign the default string "Someone"
     * @param d the day of the Person's date of birth
     * @param m the month of the Person's date of birth
     * @param y the year of the Person's date of birth
     * param id the person's id. If id doesn't contain 9 digits, assign the default string "000000000"
     */
    public Person (String name, int d, int m, int y, String id) 
    {
        if(name.length() > MIN_NAME_LENGTH)
            _name = name;
        else 
            _name = DEFAULT_NAME;
        if(id.length() == ID_LENGTH) 
            _id = id;
        else 
            _id = DEFAULT_ID;
        _dateOfBirth = new Date(d, m, y);
        
    }
    //========================================
    /**
     * Copy Constructor
     * @param other the person to be copied
     */
    public Person (Person other) 
    {
        _name = other._name;
        _id = other._id;
        _dateOfBirth = new Date(other._dateOfBirth);
    }
    //========================================
    /**
     * Gets the person's name
     * @return the person's name
     */
    public String getName()
    {
        return _name;
    }
    //========================================
    /**
     * Gets the person's id
     * @return person's id
     */
    public String getId()
    {
        return _id;
    }
    //========================================
    /**
     * Gets the person's date of birth
     * @return person's date of birth
     */
    public Date getDateOfBirth()
    {
        return new Date(_dateOfBirth);
    }
    //========================================
    /**
     * Sets the person's name (only if the string given is not empty)
     * @param name the person's new name
     */
    public void setName (String name)
    {
        if(name.length() > MIN_NAME_LENGTH)
            _name = name;
    }
    //========================================
    /**
     * Sets the person's id (only if the id is 9 digits)
     * @param id the person's new id
     */
    public void setId (String id)
    {
        if(id.length() == ID_LENGTH) 
            _id = id;        
    }
    //========================================
    /**
     * Sets the person's date of birth
     * @param d the person's new date of birth
     */
    public void setDateOfBirth (Date d)
    {
        _dateOfBirth = new Date(d);
    }
    //========================================
    /**
     * Checks if two Person objects are the same
     * @param other another Person object
     * @return true if all the attributes are the same
     */
    public boolean equals(Person other)
    {
        return _name.equals(other._name) && _id.equals(other._id) && _dateOfBirth.equals(other._dateOfBirth);
    }
    //========================================
    /**
     * Returns a String that represents this Person
     * @return Person's information in this pattern:<br/>
            Name: Israeli Israeli<br/>
            ID: 123456789<br/>
            Date of birth: 01/04/2000
    */
    public String toString()
    {   
       String s;
       s = "Name: "+_name+"\n";
       s = s + "ID: "+_id+"\n";
       s = s + "Date of birth: "+_dateOfBirth;
       return s;
    }
    //========================================
    /**
     * check if person is younger/older/same age as other person
     * @param other another person object
     * @return 1 - if this person is older than the other person ,<br/> -1 - if the other person is older than this person,<br/> 0 - If both people have the same birth date.
     */
    public int compareTo(Person other)
    {
        Date date1 = new Date(other._dateOfBirth);
        Date date2 = new Date(this._dateOfBirth);
        if(date2.before(date1)) 
            return 1;
        else if(date2.equals(date1)) 
            return 0;
        else return -1;
        
    }
}
