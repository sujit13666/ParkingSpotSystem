import java.util.Scanner;
/**
 * This Application Class consists of main method as well as interface representing the apllication as a whole. User can interact via this class directly with console.
 * 
 * @author      Sujit Ghosh
 * @ID          102233329
 * @email       sujit.bit.0329@gmail.com
 * @version     1.0.0
 */
public class Application
{
    private Scanner sc; // Scanner for user input
    private CarPark carPark; // Single CarPark object represent the whole parking place
    
    public static void main (String args[])
    {
        // Application creation and running
        Application app = new Application();
        app.runApp();
    }
    
    /**
     * runApp() method Runs the application from begining to end using the option menu
     */
    private void runApp()
    {
        boolean programTermination = false; // Flag to check program termination
        String userInput; // Variable for user input
        carPark = new CarPark(); // Initializing parking place
        sc = new Scanner(System.in); // Initializing Scanner for user input
        
        do
        {
            // Printing option menu
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Parking Spot System                |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Add a parking spot                            |");
            System.out.println("| 2. Delete a parking spot                         |");
            System.out.println("| 3. List all parking spots                        |");
            System.out.println("| 4. Park a car to a specified spot                |");
            System.out.println("| 5. Find a car and show the spot if the car is in |");
            System.out.println("| 6. Remove a car                                  |");
            System.out.println("| 7. Exit                                          |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("|   Note: Hit '\\q' anywhere to quit to main menu   |");
            System.out.println("+--------------------------------------------------+");
            
            userInput = sc.nextLine();
            
            // Check if user has choose correct option
            if(!userInput.matches("^[1-7]$"))
            {
                System.out.println("Wrong Input! Please try again.");
                continue;
            }
            
            // Call methods according to users choice
            switch (userInput) 
            {
                case "1":
                    addParkingSpot();
                    break;
                case "2":
                    deleteParkingSpot();
                    break;
                case "3":
                    listAllParkingSpot();
                    break;
                case "4":
                    parkCarInParkingSpot();
                    break;
                case "5":
                    findCar();
                    break;
                case "6":
                    removeCar();
                    break;
                case "7":
                    System.out.println("Program Terminated");
                    programTermination = true;
                    break;
            }
            
        }while(!programTermination);
    }
    
    /**
     *  addParkingSpot() method adds Parking Spot
     */
    private void addParkingSpot()
    {
        String parkingSpotIdentifierUserInput; // User input for parking spot ID
        String parkingIsForDisabledUserInput; // User input for parking is for disabled command
        boolean isForDisabled; // boolean for parking spot's disabled availability 
        
        // Printing header styles or message
        System.out.println("\n\n+--------------------------------------------------+");
        System.out.println("|            Adding a Parking Spot                 |");
        System.out.println("+--------------------------------------------------+\n");
        
        // Infinity loop to receive users input for parking spot ID, unless quit to main menu
        while(true)
        {
            System.out.print("Enter the Identifier of Parking Spot: (eg.“D01”, “E27” etc.): ");
            parkingSpotIdentifierUserInput = sc.nextLine();
            
            // Quit to main menu by hitting '\q'
            if(parkingSpotIdentifierUserInput.equals("\\q"))return;
            
            // Checking user input if it consists of one letter and two digits
            if(parkingSpotIdentifierUserInput.matches("^[a-zA-Z][0-9]{2}$"))
            {
                break;
            }else
            {
                System.out.println("Wrong Input! Please try again.");
            }
        }
        
        // Infinity loop to receive users input for parking spot's disabled availabilty, unless quit to main menu
        while(true)
        {
            // Press D for Disabled or E or Everyone
            System.out.println("\nEnter if the spot is for disabled person or not-\n'D' : For Disabled \n'E' : For Everyone ");
            parkingIsForDisabledUserInput = sc.nextLine();

            // Quit to main menu by hitting '\q'
            if(parkingIsForDisabledUserInput.equals("\\q"))return;            
            
            // Check if user put D/d or E/e
            if(parkingIsForDisabledUserInput.matches("[Dd]|[eE]"))
            {
                isForDisabled = (parkingIsForDisabledUserInput.toUpperCase().equals("D"))? true:false;
                break;
            }else
            {
                System.out.println("Wrong Input! Please try again.");
            }
        }
        
        // Check if parking spot ID is unique
        if(carPark.checkIfParkingSpotExists(parkingSpotIdentifierUserInput.toUpperCase())==null)
        {
            // Adding new parking spot
            carPark.addParkingSpot(new ParkingSpot(parkingSpotIdentifierUserInput.toUpperCase(), isForDisabled));
            System.out.println("Parking Spot Added, ID: "+parkingSpotIdentifierUserInput.toUpperCase()+", Parking Type: "+(isForDisabled==true?"Disabled":"Everyone")+"\n");
            System.out.println("+--------------------------------------------------+\n\n");
        }else
        {
            System.out.println("Parking spot is already there, please provide different name.\n");
        }
    }
    
    /**
     *  deleteParkingSpot() method deletes Parking Spot from parking area
     */
    private void deleteParkingSpot()
    {
        String parkingSpotIdentifierUserInput; // User input for parking spot ID
        ParkingSpot parkingSpot; // Variable to store parking spot
        
        // Printing header styles or message
        System.out.println("\n\n+--------------------------------------------------+");
        System.out.println("|            Deleting a Parking Spot               |");
        System.out.println("+--------------------------------------------------+\n");
        
        // Infinity loop to receive users input for parking spot ID, unless quit to main menu
        while(true)
        {
            System.out.print("Enter the Identifier of Parking Spot: (eg.“D01”, “E27” etc.): ");
            parkingSpotIdentifierUserInput = sc.nextLine();
            
            // Quit to main menu by hitting '\q'
            if(parkingSpotIdentifierUserInput.equals("\\q"))return;
            
            // Checking user input if it consists of one letter and two digits
            if(parkingSpotIdentifierUserInput.matches("^[a-zA-Z][0-9]{2}$"))
            {
                // Getting parking spot with provided ID 
                parkingSpot = carPark.checkIfParkingSpotExists(parkingSpotIdentifierUserInput.toUpperCase());
                
                // Check if parking spot exists
                if(parkingSpot!=null)
                {
                    // Check if any car is parked in the spot 
                    if(parkingSpot.getParkedCar()==null)
                    {
                        // Finally removed the parking spot
                        if(carPark.removeParkingSpot(parkingSpot)==true)
                        {
                            System.out.println("Congratulations, Parking Spot ID: "+parkingSpotIdentifierUserInput.toUpperCase()+" has been deleted.\n\n");
                            System.out.println("+--------------------------------------------------+\n\n");
                            break;
                        }else
                        {
                            System.out.println("Sorry, Spot couldn't be removed\n\n");
                        }
                    }else
                    {
                        System.out.println("Sorry, there is a car Registration ID: "+parkingSpot.getParkedCar().getRegistrationNumber()+" parked in the spot\n\n");
                    }
                }else
                {
                    System.out.println("Sorry there is no Parking Spot in ID: "+parkingSpotIdentifierUserInput.toUpperCase()+"\n\n");
                };
            }else
            {
                System.out.println("Wrong Input! Please try again.\n");
            }
        }
    }
    
    /**
     *  listAllParkingSpot() method list all the parking spot with details
     */
    private void listAllParkingSpot()
    {
        // Printing header styles or message
        System.out.println("\n\n+-------------------------------------------------------------------------------------+");
        System.out.println("|                            Listing All Parking Spots                                |");
        System.out.println("+---------------+-----------------+---------------------------+-----------------------+");
        System.out.println("|    Spot ID    |   Parking Type  |  Parked Car Registration  |        Car Owner      |");
        System.out.println("+---------------+-----------------+---------------------------+-----------------------+");

        // Print all the parking spot details
        for (ParkingSpot parkingSpot: carPark.getAllParkingSpots()) {
            System.out.println(parkingSpot.toString());
        }
        System.out.println("+---------------+-----------------+---------------------------+-----------------------+\n\n");
    }
    
    /**
     *  parkCarInParkingSpot() method parks the car into provided parking spot
     */
    private void parkCarInParkingSpot()
    {
        Car car; // Car object which will be parked
        String carRegistrationNumberUserInput; // User input for Car Registration Number
        String ownerNameUserInput; // User input for Car Owner Name (Additionally taken; No use in the project)
        String isOwnerDisabledUserInput; // User input if the owner is disabled licensed
        String parkingSpotIdentifierUserInput; // User input for parking spot ID 
        ParkingSpot parkingSpot; // Parking spot where car will be parked
        boolean isOwnerDisabled; // boolean value to set if owner is disabled or not
        
        // Printing header styles or message
        System.out.println("\n\n+--------------------------------------------------+");
        System.out.println("|                    Parking A Car                 |");
        System.out.println("+--------------------------------------------------+\n");
        
        // Infinity loop to receive users input for car's registration number, unless quit to main menu
        while(true)
        {
            System.out.print("Enter the registration number of car: (eg.“T1234”, “D9876” etc.): ");
            carRegistrationNumberUserInput = sc.nextLine();
            
            // Quit to main menu by hitting '\q'
            if(carRegistrationNumberUserInput.equals("\\q"))return;
            
            // Checking user input if it consists of one letter and four digits
            if(carRegistrationNumberUserInput.matches("^[a-zA-Z][0-9]{4}$"))
            {
                // Checking if this car is already parked or not
                if(carPark.getParkingSpotOfParkedCar(carRegistrationNumberUserInput.toUpperCase())==null)
                {
                    break;
                }else
                {
                    System.out.println("Sorry, this car Registration ID: "+carRegistrationNumberUserInput.toUpperCase()+" already parked. Please provide different Registration Number\n");
                }
                
            }else
            {
                System.out.println("Wrong Input! Please try again.\n");
            }
        }
        
        // Infinity loop to receive users input for car's owner name, unless quit to main menu
        while(true)
        {
            System.out.print("\nEnter the owner name of car: (eg.“John”, “Jane” etc.): ");
            ownerNameUserInput = sc.nextLine();

            // Quit to main menu by hitting '\q'
            if(ownerNameUserInput.equals("\\q"))return;
            
            // Checking user inut if the name consists of alphabets
            if(ownerNameUserInput.matches("^[a-zA-Z]*$"))
            {
                break;
            }else
            {
                System.out.println("Wrong Input! Please try again.\n");
            }
        }
        
        // Infinity loop to receive users input if the owner of car is disabled licesnsed, unless quit to main menu. 'Y': Disabled (Yes), 'N': Not Disabled (No)
        while(true)
        {
            System.out.println("\nEnter if the car owned by disabled person or not-\n'Y' : Disabled \n'N' : Not Disabled ");
            isOwnerDisabledUserInput = sc.nextLine();

            // Quit to main menu by hitting '\q'
            if(isOwnerDisabledUserInput.equals("\\q"))return;
            
            // Check if user put Y/y or N/n
            if(isOwnerDisabledUserInput.matches("[Yy]|[nN]"))
            {
                isOwnerDisabled = (isOwnerDisabledUserInput.toUpperCase().equals("Y"))? true:false;
                break;
            }else
            {
                System.out.println("Wrong Input! Please try again.\n");
            }
        }
        
        // Infinity loop to receive users input for getting parking spot ID, unless quit to main menu.
        while(true)
        {
            System.out.print("\nEnter the Parking Spot ID to park your car: (eg.“D01”, “E27” etc.): ");
            parkingSpotIdentifierUserInput = sc.nextLine();
            
            // Quit to main menu by hitting '\q'
            if(parkingSpotIdentifierUserInput.equals("\\q"))return;
            
            // Checking user input if it consists of one letter and two digits
            if(parkingSpotIdentifierUserInput.matches("^[a-zA-Z][0-9]{2}$"))
            {
                // Check if parking spot exists
                parkingSpot = carPark.checkIfParkingSpotExists(parkingSpotIdentifierUserInput.toUpperCase());
                if(parkingSpot!=null)
                {
                    // Check if any car is parked in the parking spot already
                    if(parkingSpot.getParkedCar()==null)
                    {
                        // Check if any normal person is trying to park in Disabled parking spot
                        if((parkingSpot.getParkingIsForDisabled() && isOwnerDisabled) || (!parkingSpot.getParkingIsForDisabled() && isOwnerDisabled) || (!parkingSpot.getParkingIsForDisabled() && !isOwnerDisabled))
                        {
                            break;
                        }else
                        {
                            System.out.println("Sorry, You can't park your car in disabled parking. Please Try with different spot ID.\n");
                        }
                    }else
                    {
                        System.out.println("Sorry, there is car parked in the spot Registration No: "+parkingSpot.getParkedCar().getRegistrationNumber()+". Please Try with different spot ID.\n");
                    }
                }else
                {
                    System.out.println("Sorry, there is no parking spot named "+parkingSpotIdentifierUserInput.toUpperCase()+". Please Try with different spot ID.\n");
                }
            }else
            {
                System.out.println("Wrong Input! Please try again.\n");
            }
        }
        
        // Creating car according to users input to park        
        car = new Car(carRegistrationNumberUserInput.toUpperCase(), ownerNameUserInput, isOwnerDisabled);
        
        // Parking the car
        parkingSpot.setCar(car);
        
        System.out.println("Congratulations, your car has been parked");
        System.out.println("+--------------------------------------------------+\n");
    }
    
    /**
     *  findCar() method searches for any parked car throughout the whole parking area
     */
    private void findCar()
    {
        String carRegistrationNumberUserInput; // User input for car's Registration Number
        ParkingSpot parkingSpot; // Parking spot where car would be searched
        
        // Printing header styles or message
        System.out.println("\n\n+--------------------------------------------------+");
        System.out.println("|                   Finding A Car                  |");
        System.out.println("+--------------------------------------------------+\n");

        // Infinity loop to receive users input for getting car's registration number, unless quit to main menu.
        while(true)
        {
            System.out.print("Enter the registration number of car: (eg.“T1234”, “D9876” etc.): ");
            carRegistrationNumberUserInput = sc.nextLine();
            
            // Quit to main menu by hitting '\q'
            if(carRegistrationNumberUserInput.equals("\\q"))return;
            
            // Checking user input if it consists of one letter and four digits
            if(carRegistrationNumberUserInput.matches("^[a-zA-Z][0-9]{4}$"))
            {
                // Searching for parking spot where car was parked and printing details once parking spot with car is found
                parkingSpot = carPark.getParkingSpotOfParkedCar(carRegistrationNumberUserInput.toUpperCase());
                if(parkingSpot!=null)
                {
                    // Printing header styles or message
                    System.out.println("\n\n+-------------------------------------------------------------------------------------+");
                    System.out.println("|                                   Search Car Result                                 |");
                    System.out.println("+---------------+-----------------+---------------------------+-----------------------+");
                    System.out.println("|    Spot ID    |   Parking Type  |  Parked Car Registration  |        Car Owner      |");
                    System.out.println("+---------------+-----------------+---------------------------+-----------------------+");
                    System.out.println(parkingSpot.toString());
                    System.out.println("+---------------+-----------------+---------------------------+-----------------------+\n\n");
                    break;
                }else
                {
                    System.out.println("Sorry, No car is found by Registration ID: "+carRegistrationNumberUserInput.toUpperCase()+". Please provide any other registration number.\n");
                }
            }else
            {
                System.out.println("Wrong Input! Please try again.\n");
            }
        }
    }
    
    /**
     *  removeCar() method removes any provided car from parking area which was parked previously
     */
    private void removeCar()
    {
        String carRegistrationNumberUserInput; // User input for car's Registration Number
        ParkingSpot parkingSpot; // Parking spot where car would be searched
        
        // Printing header styles or message
        System.out.println("\n\n+--------------------------------------------------+");
        System.out.println("|                   Removing A Car                 |");
        System.out.println("+--------------------------------------------------+\n");

        // Infinity loop to receive users input for getting car's registration number, unless quit to main menu.
        while(true)
        {
            System.out.print("Enter the registration number of car: (eg.“T1234”, “D9876” etc.): ");
            carRegistrationNumberUserInput = sc.nextLine();
            
            // Quit to main menu by hitting '\q'
            if(carRegistrationNumberUserInput.equals("\\q"))return;
            
            // Checking user input if it consists of one letter and four digits
            if(carRegistrationNumberUserInput.matches("^[a-zA-Z][0-9]{4}$"))
            {
                // Checking if the car was parked to any parking spot
                parkingSpot = carPark.getParkingSpotOfParkedCar(carRegistrationNumberUserInput.toUpperCase());
                if(parkingSpot!=null)
                {
                    // Removing the car from parking area
                    parkingSpot.setCar(null);
                    System.out.println("Congratulations, Car successfully removed from Parking Spot: "+parkingSpot.getParkingSpotIdentifier()+"\n");
                    System.out.println("+--------------------------------------------------+\n\n");
                    break;
                }else
                {
                    System.out.println("Sorry, No car found by Registration ID: "+carRegistrationNumberUserInput.toUpperCase()+".\n\n");
                }
            }else
            {
                System.out.println("Wrong Input! Please try again.\n\n");
            }
        }
    }
}
