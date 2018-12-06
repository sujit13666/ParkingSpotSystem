/**
 * This is Car Class representing a Car owned by person and that can be parked to any parking spot in parking area
 * 
 * @author      Sujit Ghosh
 * @ID          102233329
 * @email       sujit.bit.0329@gmail.com
 * @version     1.0.0
 */
public class Car
{
    private String registrationNumber; // Registration Numebr of Car
    private String ownerName; // Owner name of the car
    private boolean isOwnerDisabled; // Disability status of the owner
    
    /**
     * This is the constructor of Car class initializing the registration number of the car, owner name and disability status of a car owner
     * 
     * @param registrationNumber registration number of car in String
     * @param ownerName the name of the owner in String
     * @param isOwnerDisabled the boolean value if the owner is disabled or not
     */
    public Car(String registrationNumber, String ownerName, boolean isOwnerDisabled)
    {
        // Assigning the values to create a car
        this.registrationNumber = registrationNumber;
        this.ownerName  = ownerName;
        this.isOwnerDisabled = isOwnerDisabled;
    }
    
    /**
     * getRegistrationNumber() method returns the registration number of the car
     * 
     * @return registartion number is returned as a srting
     */
    public String getRegistrationNumber()
    {
        return this.registrationNumber;
    }
    
    /**
     * getOwnerName() method returns the name of the owner name of the car
     * 
     * @return owner name of the car is returned as a srting
     */
    public String getOwnerName()
    {
        return this.ownerName;
    }
    
    /**
     * getIsOwnerDisabled() method returns the disability status of the owner of the car
     * 
     * @return owner's disability status is returned as a boolean
     */
    public boolean getIsOwnerDisabled()
    {
        return this.isOwnerDisabled;
    }
}
