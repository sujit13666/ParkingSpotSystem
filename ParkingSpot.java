/**
 * This is ParkingSpot Class representing a parking spot in the parking area where cars can be parked. It can be of 2 types like for disabled person and for everyone.
 * 
 * @author      Sujit Ghosh
 * @ID          102233329
 * @email       sujit.bit.0329@gmail.com
 * @version     1.0.0
 */
public class ParkingSpot
{
    private boolean parkingIsForDisabled; // Parking is for disabled or everyone
    private String parkingSpotIdentifier; // Parking spot ID
    private Car car; // Car parked in the parking spot
    
    /**
     * This is the constructor of ParkingSpot class initializing the parking spot of a parking area where car parking spot ID and disability allowance are provided
     * 
     * @param parkingSpotIdentifier Parking spot ID as String
     * @param parkingForDisabled parking spot is dedicated for the disabled in boolean
     */
    public ParkingSpot(String parkingSpotIdentifier, boolean parkingForDisabled)
    {
        // Assigning the values to create a parking spot
        this.parkingIsForDisabled = parkingForDisabled;
        this.parkingSpotIdentifier = parkingSpotIdentifier;
    }
    
    /**
     *  getParkingSpotIdentifier() method returns the ID of the parking spot
     * 
     * @return parkingSpotIdentifier is retuened as a String
     */
    public String getParkingSpotIdentifier()
    {
        return parkingSpotIdentifier;
    }
    
    /**
     *  getParkingIsForDisabled() method returns if the parking spot is for the disabled person or for everyone
     * 
     * @return parkingIsForDisabled is retuened as a boolean if true then its for only disabled person and if false then its for everyone
     */
    public boolean getParkingIsForDisabled()
    {
        return parkingIsForDisabled;
    }
    
    /**
     *  getParkedCar() method returns the car if the parking spot has any car parked in it
     * 
     * @return car as a Car object if it is parked in the spot
     */
    public Car getParkedCar()
    {
        return car;
    }
    
    /**
     *  setCar() method parks any car to the particular parking spot
     * 
     * @param car Car object is set for parking in the parking spot
     */
    public void setCar(Car car)
    {
        this.car = car;
    }
    
    /**
     *  toString() method simplify the parking spot object into readable message and sent to the application
     * 
     * @return A simplified readable message is retuned regarding parking spot as a String
     */
    public String toString()
    {
        return ("|      "+this.parkingSpotIdentifier+"      |     "+(this.parkingIsForDisabled==true?"Disabled":"Everyone")+"    |           "+(this.car!=null?(this.car.getRegistrationNumber()):"Empty")+"           |"+(this.car!=null?((this.car.getIsOwnerDisabled()==true)?"    Disabled Person    ":"  Not Disabled Person  "):"         Empty         ")+"|");
    }
}
