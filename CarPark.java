import java.util.ArrayList; 
/**
 * This is CarPark Class representing the whole parking area consists of many parking spots
 * 
 * @author      Sujit Ghosh
 * @ID          102233329
 * @email       sujit.bit.0329@gmail.com
 * @version     1.0.0
 */
public class CarPark
{
    private ArrayList<ParkingSpot> parkingSpots; // List of parking spots
    
    /**
     * This is the constructor of CarPark class initializing the ArrayList of Parking Spots
     */
    public CarPark()
    {
        // Initializing the Arraylist of Parking Spot
        parkingSpots = new ArrayList<ParkingSpot>();
    }
    
    /**
     * addParkingSpot() method adds any particular parking spot to the array list of parking spots
     * 
     * @param parkingSpot parking spot provided by the application is added to the arraylist
     */
    public void addParkingSpot(ParkingSpot parkingSpot)
    {
        // Adding provided parkingSpot
        parkingSpots.add(parkingSpot);
    }
    
    /**
     * removeParkingSpot() method removes any particular parking spot from the array list of parking spots
     * 
     * @param parkingSpot parking spot provided by the application is removed from the arraylist
     * @return boolean if parking spot is removed or not
     */
    public boolean removeParkingSpot(ParkingSpot parkingSpot)
    {
        // Removing provided Parking Spot
        return parkingSpots.remove(parkingSpot);
    }
    
    /**
     * getAllParkingSpots() method returns all the parking spots in parking area as a list
     * 
     * @return ArrayList consists of all parkingSpots
     */
    public ArrayList<ParkingSpot> getAllParkingSpots()
    {
        // Returns whole parking spots array list
        return parkingSpots;
    }
    
    /**
     * checkIfParkingSpotExists() method checks if there is any parking spot exists in the provided identifier
     * 
     * @param parkingSpotIdentifier a string provided to search wheather the name is unique in the parking spot list
     * @return parkingSpot is returned if found in that provided name
     */
    public ParkingSpot checkIfParkingSpotExists(String parkingSpotIdentifier)
    {
        // Check wheather any parking spot exists in that provided name
        for (ParkingSpot parkingSpot: parkingSpots) 
        {
            if(parkingSpotIdentifier.equals(parkingSpot.getParkingSpotIdentifier())) 
            {
                return parkingSpot;
            }
        }
        // if not matching the ID, then return null
        return null;
    }
    
    /**
     * getParkingSpotOfParkedCar() method checks if there is any car parked in the parking area provided car's registration number
     * 
     * @param carRegistrationNumber car's registration number is provided to search if the its been parked into the parking area
     * @return parkingSpot is returned if found that car is parked there
     */
    public ParkingSpot getParkingSpotOfParkedCar(String carRegistrationNumber)
    {
        // Traverse through the parking spots to search the car 
        for (ParkingSpot parkingSpot: parkingSpots) 
        {
            // Check if any car is parked 
            if(parkingSpot.getParkedCar()!=null)
            {
                // Matching the registration numbers to identify if car is parked there
                if(carRegistrationNumber.equals(parkingSpot.getParkedCar().getRegistrationNumber())) 
                {
                    return parkingSpot;
                }
            }
        }
        // if not matching the Registration Number, then return null
        return null;
    }
}
