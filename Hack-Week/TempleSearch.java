// Author: Jeanette Eldredge

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TempleSearch {
    //Declaration of Arrays
    private static ArrayList<String> templeName = new ArrayList<String>();
    private static ArrayList<String> templeLocation = new ArrayList<String>();
    private static ArrayList<String> templeDedication = new ArrayList<String>();
    private static ArrayList<String> templestatus = new ArrayList<String>();
    private static ArrayList<String> allData = new ArrayList<String>();
    private static ArrayList<String> infoDisplayed = new ArrayList<String>();
    private static Scanner userInput = new Scanner(System.in);

/******************************************************************
* main():
* Main calls all the functions and handles the main input from the
* user. 
******************************************************************/
    public static void main(String[] args) {
        //Declaration of non global variables
        boolean continueLoop = true;
        Integer amountLooped = 0;

        //Create input Scanner and read in the list of temples
        try {
            importlist();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Organize read in data
        separateData();

        System.out.println("\n\nWelcome to Temple Search!");
        while (continueLoop) {
            //Recieve information from User and find Information about the temples in that location
            String input = "";
            String error = "";
            Integer templeAmount = 0;
            System.out.println("\n\nPlease enter a state or country:");
            if(amountLooped == 0)
            {
                input = userInput.nextLine();
            }
            else if (amountLooped > 0)
            {
                while(!userInput.hasNext()){
                    error = userInput.next();
                }
                input = userInput.next();
            }
            templeAmount = findInfo(input, templeAmount);

            //Check to see if place exists in Array. If not, while loop asks for new input
            while (infoDisplayed.size() <= 0) {
                System.out.println("Unable to find Temples in " + input + "\n");
                System.out.println("Please enter a state or country:");
                input = userInput.nextLine();
                templeAmount = findInfo(input, templeAmount);
            }

            //Display Table
            display(input, templeAmount);

            //Wait while User looks at the generated list for 3 seconds
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Begin Covid-19 status resource code
            System.out.println("\n\nWould you like Covid-19 Level status Information? Y or N");
            input = userInput.next();

            //Check for proper input
            while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                System.out.println("Invalid Response. Type Y or N");
                input = userInput.nextLine();
            }

            //Call the information function Covid19()
            if (input.equalsIgnoreCase("Y")) {
                Covid19();
            }
            amountLooped = amountLooped + 1;
            //Continue loop to search temples again or not
            System.out.println("\nWould you like to search more Temples? Y or N");
            input = userInput.next();
            while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                System.out.println("\nInvalid Response. Type Y or N");
                input = userInput.nextLine();
            }

            //If N Break the Loop
            if (input.equalsIgnoreCase("N")) {
                continueLoop = false;
                System.out.println("\nThank you! Have a good day!");
            } else {
                infoDisplayed.clear();
            }

            //Wait while for 5 seconds
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //close Scanner
        userInput.close();
    }

/******************************************************************
* findInfo(String Input, Integer Amount):
* Locates information about temples in the specific location and adds
* them to the array that displays the information.
******************************************************************/
    public static void importlist() throws FileNotFoundException {
        String file1 = new File("TempleList.txt").getAbsolutePath();
        Path list1 = Paths.get(file1);

        Scanner Datalist = new Scanner(new File(list1.toString()));
        while (Datalist.hasNextLine()) {
            allData.add(Datalist.nextLine());
        }
        Datalist.close();
    }

/******************************************************************
* separateData():
* Seperates the data from the array holding all the data to 4 
* different arrays. The new arrays hold the temple name, location,
* dedication, and Covid status
******************************************************************/   
    public static void separateData()
    {
        for (int i = 0; i < allData.size(); i += 4) {
            templeName.add(allData.get(i));
        }
        for (int i = 1; i < allData.size(); i += 4) {
            templeLocation.add(allData.get(i));
        }
        for (int i = 2; i < allData.size(); i += 4) {
            templeDedication.add(allData.get(i));
        }
        for (int i = 3; i < allData.size(); i += 4) {
            templestatus.add(allData.get(i));
        }
    }

/******************************************************************
* findInfo(String Input, Integer Amount):
* Locates information about temples in the specific location and adds
* them to the array that displays the information.
******************************************************************/
    public static Integer findInfo(String Input, Integer Amount) {
        for (int i = 0; i < templeLocation.size(); i++) {
            String tempLocation = templeLocation.get(i);
            if (tempLocation.equalsIgnoreCase(Input)) {
                infoDisplayed.add(templeName.get(i));
                infoDisplayed.add(templeLocation.get(i));
                infoDisplayed.add(templeDedication.get(i));
                infoDisplayed.add(templestatus.get(i));
                Amount = Amount + 1;
            }
        }
        return Amount;
    }
    
/******************************************************************
* display():
* Displays the table with the information regarding the temples in
* the specific location entered.
******************************************************************/
    public static void display(String Input, Integer templeAmount) {
        System.out.println("\n");
        System.out.println("Temples in " + Input + ":\t" + templeAmount + "\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%-40s %-30s %s\n", "Temple Name", "Dedication", "Covid-19 status");
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        for (int i = 0; i < infoDisplayed.size(); i += 4) {

            System.out.printf("%-40s %-37s %s\n", infoDisplayed.get(i), infoDisplayed.get(i + 2),
                    infoDisplayed.get(i + 3));
        }

    }
    
/******************************************************************
* Covid19():
* Displays information for each level of temple status for Covid-19
* designs.
******************************************************************/
    public static void Covid19()
    {
        boolean loops = true;
        while(loops)
        {
            //Create new Scanner and handle user input
            System.out.println("Please Enter the Level of status: ");
            String input = userInput.next();

            //Check for proper input
            while (!input.equalsIgnoreCase("1") && !input.equalsIgnoreCase("2") && !input.equalsIgnoreCase("3")
                    && !input.equalsIgnoreCase("4") && !input.equalsIgnoreCase("N/A")
                    && !input.equalsIgnoreCase("Paused") && !input.equalsIgnoreCase("Closed")) {
                System.out.println("Invalid Response. Type 1, 2, 3, 4, N/A, Paused, or Closed");
                input = userInput.next();
            }

            //Display information for each level of status
            if (input.equalsIgnoreCase("1")) {
                System.out.println("\nThe Temple is closed except for live Sealings by appointment.");
            } else if (input.equalsIgnoreCase("2")) {
                System.out.println("\nThe Temple is closed except for living Ordinances by appointment.");
            } else if (input.equalsIgnoreCase("3")) {
                System.out.println(
                        "\nThe Temple is open for living Ordinances for Proxy Baptisms and Confirmations by appointment.");
            } else if (input.equalsIgnoreCase("4")) {
                System.out.println("\nAll ordinances for the living as well as proxy are available by appointment.");
            } else if (input.equalsIgnoreCase("N/A")) {
                System.out.println("\nThis Temple is announced or under construction.");
            } else if (input.equalsIgnoreCase("Paused")) {
                System.out.println(
                        "\nThis Temple is located in a place where Covid-19 is too dangerous to open the temple.");
            } else if (input.equalsIgnoreCase("Closed")) {
                System.out.println("\nThis Temple is being renovated.");
            }

            //Wait while for 3 seconds
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Continue the loop
            System.out.println("\n\nWould you like more information? Y or N");
            input = userInput.next();

            //Check for proper input
            while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                System.out.println("Invalid Response. Type Y or N");
                input = userInput.next();
            }

            //if input is N then the loop is broken
            if (input.equalsIgnoreCase("N"))
            {
                loops = false;
            }
        }
    }
}