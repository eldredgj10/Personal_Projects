//Author: Jeanette Eldredge

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Generator {
    // Declaration of Arrays
    public static ArrayList<String> SchoolWords = new ArrayList<String>();
    public static ArrayList<String> HomeWords = new ArrayList<String>();
    public static ArrayList<String> OutsideWords = new ArrayList<String>();
    public static String input;
    public static String previousInput;

    public Generator() {
        input = "";
        fillInLists("school");
        fillInLists("home");
        fillInLists("outside");
    }
    private int count = 100;
    public void generate(String input) {
        Random rand = new Random();
        // The random generator does number 0 - the limit so saying that
        // the lim is 6 will generate a number out of 7 numbers.
        // This will need to be changed for bigger lists.
        boolean NWorCHK = false;
        if ((input.equals("new")) || input.equals("check")) {
            NWorCHK = true;
            input = previousInput;
        }

        if(count == 0)
        {
            fillInLists(input);
            count =100;
        }

        int item = rand.nextInt(count);

        if (input.equals("school")) {
            if(SchoolWords.size() == 0)
            {

            }
            System.out.println(SchoolWords.get(item));
            SchoolWords.remove(item);
            count -= 1;
        }

        else if (input.equals("home")) {
            System.out.println(HomeWords.get(item));
            HomeWords.remove(item);
            count -= 1;
        }

        else if (input.equals("outside")) {
            System.out.println(OutsideWords.get(item));
            OutsideWords.remove(item);
            count -= 1;
        }

        if (NWorCHK == false) {
            previousInput = input;
        }
    }

    public static void fillInLists(String input) {
        String file1 = new File("school.txt").getAbsolutePath();
        String file2 = new File("home.txt").getAbsolutePath();
        String file3 = new File("outside.txt").getAbsolutePath();
        
        Path list1 = Paths.get(file1);
        Path list2 = Paths.get(file2);
        Path list3 = Paths.get(file3);
        
        if(input.equals("school"))
        {
            Scanner schoollist;
            try {
                schoollist = new Scanner(new File(list1.toString()));
                while(schoollist.hasNext()){ SchoolWords.add(schoollist.nextLine()); }
                schoollist.close();
            } 
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        if(input.equals("home"))
        {
            try{
                Scanner homelist = new Scanner(new File(list2.toString()));
                while(homelist.hasNext()){ HomeWords.add(homelist.nextLine()); }
                homelist.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }   

        if(input.equals("outside"))
        {
            try{
                Scanner outsidelist = new Scanner(new File(list3.toString()));
                while(outsidelist.hasNext()){ OutsideWords.add(outsidelist.nextLine()); }
                outsidelist.close();
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
}