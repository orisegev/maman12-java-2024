/**
 * This class represents a Date Object
 * 
 * @author (Ori Segev) 
 * @version (2024a)
 */

public class Date 
{
    //======= INTS ============
    private int _day;
    private int _month;
    private int _year;
    //======= FINALS ==========
    private final int DEFAULT_DAY = 1;
    private final int DEFAULT_MONTH = 1;
    private final int DEFAULT_YEAR = 2000;
    private final int JAN = 1;
    private final int FEB = 2;
    private final int MAR = 3;
    private final int APR = 4;
    private final int MAY = 5;
    private final int JUN = 6;
    private final int JUL = 7;
    private final int AUG = 8;
    private final int SEP = 9;
    private final int OCT = 10;
    private final int NOV = 11;
    private final int DEC = 12;
    private final int MAX_DAY = 31;
    private final int MAX_DAY_SHORT = 30;
    private final int MAX_DAY_FEB = 28;
    private final int MAX_DAY_FEB_LEAP = 29;
    private final int MAX_MONTH = 12;
    private final int MIN_DAY = 1;
    private final int MIN_MONTH = 1;
    private final int MIN_YEAR = 1000;
    private final int MAX_YEAR = 9999;
    //========================================
    /**
    * Date constructor - If the given date is valid - creates a new Date object, otherwise creates the date 01/01/2000.
    * @param day the day in the month(1-31)
    * @param month the month in the year(1-12)
    * @param year the year (4 digits)
    */
    public Date (int day, int month, int year) 
    { 
        if(isValidDate(day, month, year))
        {
            _day = day;
            _month = month;
            _year = year;
        }
        else 
        {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }
    
    }
    //========================================
    /**
     * Copy constructor
     * @param other the date to be copied
     */
    public Date (Date other) 
    {
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }
    //========================================
    /**
     * Gets the day
     * @return the day of this date
     */
    public int getDay() 
    {
        return _day;
    }
    //========================================
    /**
     * Gets the month
     * @return the month of this date
     */
    public int getMonth() 
    {
        return _month;
    } 
    //========================================
    /**
     * Gets the year
     * @return the year of this date
     */
    public int getYear() 
    {
        return _year;
    }
    //========================================
    /**
     * Sets the day (only if date remains valid)
     * @param dayToSet the new day value
     */
    public void setDay(int dayToSet)
    {
        if(isValidDate(dayToSet, _month, _year))
            _day = dayToSet;
    }
    //========================================
    /**
     * Sets the month (only if date remains valid)
     * @param monthToSet the new month value
     */
    public void setMonth(int monthToSet)
    {
       if(isValidDate(_day, monthToSet, _year))
            _month = monthToSet; 
    }
    //========================================
    /**
     * Sets the year (only if date remains valid)
     * @param yearToSet the new year value
     */
    public void setYear(int yearToSet)
    {
        if(isValidDate(_day, _month, yearToSet))
            _year = yearToSet;
    }
    //========================================
    /**
     * Checks if two dates are the same
     * @param other the date to compare this date to
     * @return true if the dates are the same
     */
    public boolean equals(Date other)
    {
        return _day == other._day && _month == other._month && _year == other._year;
    }
    //========================================
    /**
     * Checks if this date comes before another date
     * @param other date to compare this date to
     * @return true if this date is before the other date
     */
    public boolean before (Date other) 
    {   
        return (calculateDate(_day, _month, _year) < calculateDate(other._day, other._month, other._year));
    }
    //========================================
    /**
     * Checks if this date comes after another date
     * @param other date to compare this date to
     * @return true if this date is after the other date
     */
    public boolean after (Date other)
    {
        return other.before(this);
    }
    //========================================
    // Computes the days number since the beginning of the Christian counting of years
    private int calculateDate (int day, int month, int year)
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }
    //========================================
    /**
     * Calculates the difference in days between two dates
     * @param other the date to calculate the difference between
     * @return the number of days between the dates (non negative value)
     */
    public int difference (Date other) 
    {
        return calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year);
    }
    //========================================
    /**
     * Returns a new Date which is the current date after adding a number of years to it (the current date does not change)
     * @param num the number of years to add (a positive number)
     * @return the new date: this date plus num years
     */
    public Date addYearsToDate (int num)
    {
        int a = this._day;
        if(num > 0)
        {
            if(this._month == FEB && this._day >= MAX_DAY_FEB)
                a = isLeapYear(this._year + num) ? MAX_DAY_FEB_LEAP : MAX_DAY_FEB;
            else
                a = this._day;
        }
        Date d5 = new Date(a, this._month, this._year + num);
        return d5;
    }
    //========================================
    // checks if the year is a leap year
    private boolean isLeapYear (int y)
    {   
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0) ? true : false;
    }
    //========================================
    /**
     * Returns the date in this pattern: d/m/year (12/05/2019)
     * @return a String that represents this date in the following format: day (2 digits) / month(2 digits) / year (4 digits) for example: 02/03/1998
     */
    public String toString()
    {
        String s;
        if(_day >= 10)
            s = "";
        else
            s = "0";
        s = s +_day+"/";
        if(_month < 10)
            s = s + "0";
        s = s + _month+"/"+_year;
        return s;
    }
    //========================================
    // check if the date is valid
    private boolean isValidDate(int d, int m, int y)
    {
        if(y < MIN_YEAR || y > MAX_YEAR)
            return false;
        if(d < MIN_DAY)
            return false;
        switch(m) 
        {
            case JAN:
                if(d > MAX_DAY)
                    return false;
                break;
            case FEB:
                if(isLeapYear(y) ? d > MAX_DAY_FEB_LEAP : d > MAX_DAY_FEB)
                    return false;
                break;    
            case MAR:
                if(d > MAX_DAY)
                    return false;
                break;
            case APR:
                if(d > MAX_DAY_SHORT)
                    return false;
                break;
            case MAY:
                if(d > MAX_DAY)
                    return false;
                break;
            case JUN:
                if(d > MAX_DAY_SHORT)
                    return false;
                break;
            case JUL:
                if(d > MAX_DAY)
                    return false;
                break;
            case AUG:
                if(d > MAX_DAY)
                    return false;
                break;
            case SEP:
                if(d > MAX_DAY_SHORT)
                    return false;
                break;
            case OCT:
                if(d > MAX_DAY)
                    return false;
                break;
            case NOV:
                if(d > MAX_DAY_SHORT)
                    return false;
                break;
            case DEC:
                if(d > MAX_DAY)
                    return false;
                break;
            default: 
                return false;
        }
        return true;   
    }
}