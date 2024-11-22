/**
 * This class represents an Apartment object
 *
 * @author Ori Segev
 * @version 2024a
 */
public class Apartment
{
    //=========================
    private int _noOfRooms;
    private double _area;
    private double _price;
    private Person _Tenant;
    private Date _rentalStartDate;
    private Date _rentalEndDate;
    //======= FINALS ==========
    private final int DEFAULT_ROOMS = 3;
    private final double DEFAULT_AREA = 80;
    private final double DEFAULT_PRICE = 5000;
    private final int DEFAULT_END_DATE = 1; // in years
    //========================================
     /**
     * Apartment constructor create new apartment
     * @param rooms the number of rooms the apartment has
     * @param area the apartment's area
     * @param price monthly price to rent the apartment
     * @param tenant the person renting the apartment
     * @param start_day starting day of apartment rental
     * @param start_month starting month of apartment rental
     * @param start_year starting year of apartment rental
     * @param end_day last day of apartment rental
     * @param end_month last month of apartment rental
     * @paramend_year last year of apartment rental
     */
    
    public Apartment(int rooms, double area, double price, Person tenant, int start_day, int start_month, int start_year, int end_day, int end_month, int end_year)
    {
        if(rooms > 0) 
            _noOfRooms = rooms;
        else
            _noOfRooms = DEFAULT_ROOMS;
        if(area > 0)
            _area = area;
        else
            _area = DEFAULT_AREA;
        if(price > 0)
            _price = price;
        else
            _price = DEFAULT_PRICE;
        _Tenant = new Person(tenant);
        _rentalStartDate = new Date(start_day, start_month, start_year);
        _rentalEndDate = new Date(end_day, end_month, end_year);
        if(_rentalStartDate.equals(_rentalEndDate) || _rentalEndDate.before(_rentalStartDate))
            _rentalEndDate = _rentalStartDate.addYearsToDate(1);
    }
    
    //========================================
    /**
     * Copy Constructor
     * @param other the apartment to be copied
     */
    public Apartment(Apartment other)
    {
        _noOfRooms = other._noOfRooms;
        _area = other._area;
        _price = other._price;
        _Tenant = new Person(other._Tenant);
        _rentalStartDate = new Date(other._rentalStartDate);
        _rentalEndDate = new Date(other._rentalEndDate);
    }
    //========================================
    /**
     * Gets the number of rooms the apartment has
     * @return the number of rooms the apartment has
     */
    public int getNoOfRooms()
    {
        return _noOfRooms;
    }
    //========================================
    /**
     * Gets the area of the apartment
     * @return the area of the apartment
     */
    public double getArea()
    {
        return _area;
    }
    //========================================
    /**
     * Gets the price of the apartment
     * @return the price of the apartment
     */
    public double getPrice()
    {
        return _price;
    }
    //========================================
    /**
     * Gets the tenant renting the apartment
     * @return the tenant renting the apartment
     */
    public Person getTenant()
    {
        return new Person(_Tenant);
    }
    //========================================
    /**
     * Gets the rental start date
     * @return the rental start date
     */
    public Date getRentalStartDate()
    {
        return new Date(_rentalStartDate);
    }
    //========================================
    /**
     * Gets the rental end date
     * @return the rental end date
     */
    public Date getRentalEndDate()
    {
        return new Date(_rentalEndDate); 
    }
    //========================================
    /**
     * Sets the apartment's number of rooms (only if the new value is positive)
     * @param num new number of rooms
     */
    public void setNoOfRooms(int num)
    {
        if(num > 0) 
            _noOfRooms = num;
    }
    //========================================
    /**
     * Sets the apartment's area (only if the new value is positive)
     * @param area apartment's new area
     */
    public void setArea(double area)
    {
        if(area > 0)
            _area = area;
    }
    //========================================
    /**
     * Sets the apartment's price (only if the new value is positive)
     * @param price apartment's new price
     */
    public void setPrice(double price)
    {
        if(price > 0)
            _price = price;
    }
    //========================================
    /**
     * Sets the apartment's tenant
     * @param p apartment's new tenant
     */
    public void setTenant(Person p)
    {
        _Tenant = new Person(p);
    }
    //========================================
    /**
     * Sets the apartment's rental start date (only if the new rental start date is before the current rental end date)
     * @param rentalStartDate apartment's new rental start date
     */
    public void setRentalStartDate(Date rentalStartDate)
    {
        if(rentalStartDate.before(_rentalEndDate))
            _rentalStartDate = new Date(rentalStartDate);
    }
    //========================================
    /**
     * Sets the apartment's rental end date (only if the new rental end date is after the current rental start date)
     * @param p apartment's new tenant
     */
    public void setRentalEndDate(Date rentalEndDate)
    {
        if(rentalEndDate.after(_rentalStartDate))
            _rentalEndDate = new Date(rentalEndDate);
    }
    //========================================
    /**
     * Returns a String that represents this Apartment
     * @return Apartment information in this pattern:<br/>
        Number Of Rooms: 4<br/>
        Area: 81.0<br/>
        Price: 6500.0 NIS<br/>
        Tenant name: Israel Israeli<br/>
        Rental start date: 01/07/2022<br/>
        Rental end date: 01/07/2024
     */
    public String toString()
    {

        String s;
        s = "Number of Rooms: "+getNoOfRooms()+"\n";
        s = s + "Area: "+getArea()+"\n";
        s = s + "Price: "+getPrice()+ " NIS\n";
        s = s + "Tenant name: "+_Tenant.getName()+"\n";
        s = s + "Rental start date: "+_rentalStartDate+"\n";
        s = s + "Rental end date: "+_rentalEndDate;
        return s;
    }
    //========================================
    /**
     * Extends the rental period by additional years(only if the years value is positive)
     * @param years the number of years to extend the lease
     */
    public void extendRentalPeriod(int years)
    {
        if(years > 0)
        {
            Date d6 = getRentalEndDate().addYearsToDate(years);            
            _rentalEndDate = d6;
        }
    }
    //========================================
    /**
     * Computes the number of days left between a given date and the end of rental date. If the given date comes after the end of rental date, returns -1.
     * @param d a date object
     * @return the number of days left between a given date and the end of rental date
     */
    public int daysLeft(Date d)
    {   
        if(getRentalEndDate().before(d))
            return -1; 
        else 
            return getRentalEndDate().difference(d);
    }
    //========================================
    /**
     * Checks if the apartment's tenant can be replaced and update apartment attributes accordingly ( if the tenant is younger, the rental end date ends up to 90 days after the new rental start date and the new price is at least the current rental's price)
     * @param startDate a new rental start date
     * @param p a new tenant
     * @param price a new price
     * @return true if the tenant has been changed  
     */
    public boolean changeTenant(Date startDate, Person p, double price)
    {
        if(p.compareTo(_Tenant) < 0 && daysLeft(startDate) <= 90 && price >= getPrice())
        {
            setTenant(p);
            setPrice(price);
            setRentalStartDate(startDate);
            setRentalEndDate(startDate.addYearsToDate(1));
            return true;
        }
        else
        {
            return false;
        }
    }
    //========================================
    /**
     * Checks if the current and other apartments are equal by all the apartment attributes
     * @param other an apartment object
     * @return true if the two objects are equal. Otherwise, returns false
     */
    public boolean equals(Apartment other)
    {
        return getNoOfRooms() == other.getNoOfRooms() && getArea() == other.getArea() && getPrice() == other.getPrice() && getTenant().equals(other.getTenant()) && getRentalStartDate().equals(other.getRentalStartDate()) && getRentalEndDate().equals(other.getRentalEndDate());
    }
}
