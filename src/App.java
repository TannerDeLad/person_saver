import java.util.ArrayList;
import java.util.List;
//creating an app to create Person class and save them into a list 
public class App {
    public static class Person {
        public String fName;
        public String mName;
        public char mInitial;
        public String lName;
        public String DOB;
        public String SSN;
        public String phone;
        public String address;
        public String allergies;
        public String type;
        public String courses;
        //method to set the above attributes to each object using the 'this' keywod
        public void set_attr() {
            System.out.println("Please enter the first name of this person: ");
            this.fName = System.console().readLine();
            System.out.println("Please enter the middle name of this person: ");
            this.mName = System.console().readLine();
            this.mInitial = this.mName.charAt(0);
            System.out.println("Please enter the last name of this person: ");
            this.lName = System.console().readLine();
            System.out.println("Please enter the DOB of the person in the format (01-01-1999)");
            String att = "";
            this.DOB = System.console().readLine();
            System.out.println("Please enter the SSN of this person: ");
            this.SSN = System.console().readLine();
            System.out.println("Please enter the phone number of this person: ");
            this.phone = System.console().readLine();
            System.out.println("Please enter the address of this person: ");
            this.address = System.console().readLine();
            System.out.println("Please enter anything this person is allergic to: ");
            this.allergies = System.console().readLine();
            System.out.println("Please enter the type of person (number)\n");
            System.out.println("1: Administration \n");
            System.out.println("2: Faculty \n");
            System.out.println("3: Staff \n");
            System.out.println("4: Student");
            int a = 0;
            boolean small_trap = true;
            while (small_trap) {
                a = user_filtering(att);
                switch (a) {
                    case 1:
                        this.type = "Administration";
                        small_trap = false;
                    case 2:
                        this.type = "Faculty";
                        small_trap = false;
                    case 3:
                        this.type = "Staff";
                        small_trap = false;
                    case 4:
                        this.type = "Student";
                        small_trap = false;
                    default:
                        System.out.println("Please enter 1-4");
                        break;
                }
            }
            if (this.type == "Faculty") {
                System.out.println("Please enter the courses taught for this person: ");
                this.courses = System.console().readLine();
            } else if (this.type == "Student") {
                System.out.println("Please enter the classes being taken for this person: ");
                this.courses = System.console().readLine();
            } else {
                this.courses = null;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String user_in = "";
        int a = 0;
        boolean big_trap = true;
        //big while loop that encompasses the whole program
        while (big_trap) {
            System.out.println("Please select from the below options: \n");
            System.out.println("1: Add people \n");
            System.out.println("2: Search people \n");
            System.out.println("3: Exit program \n");
            // using the user_filtering function to ensure the user gives us an integer
            a = user_filtering(user_in);
            String throwaway = "";
            //creating a list to save Person objects into
            List<Person> personlist = new ArrayList<Person>();
            // below are test people that can be used to utilize the search function
            // Person tester = new Person();
            // Person tester1 = new Person();
            // Person tester2 = new Person();
            // tester1.fName = "Stinker";
            // tester2.fName = "Thrower";
            // tester.fName = "Hill";
            // personlist.add(tester);
            // personlist.add(tester1);
            // personlist.add(tester2);
            switch (a) {
                case 1:
                    // adding people function
                    System.out.println("How many people would you like to add?");
                    int b = 0;
                    b = user_filtering(throwaway);
                    while (b > 0) {
                        // creating and adding new people each time
                        Person creation = new Person();
                        creation.set_attr();
                        personlist.add(creation);
                        b--;
                    }
                    break;

                case 2:
                    // search people function - allows the user to search for entries that aren't
                    // actually there and will display the closest one
                    System.out.println("Enter the first name of the person you would like to look for: ");
                    throwaway = System.console().readLine();
                    System.out.println("Are you seraching for " + searchfName(personlist, throwaway));
                    //searchfName will be called and needs the list of Person objects with the query the user input
                    break;
                case 3:
                // java exit 
                    System.exit(0);
                    break;

                default:
                // user handling with a default that will keep the user contained until they choose 1 2 or 3
                    System.out.println("Please input 1, 2 or 3");
                    break;
            }
        }
    }
    //below was the beginning of search by attribute - it worked just needed to prompt the user to select which attribute they wanted and ask for that specific input. Would need to change for the type attribute however, likely use some if blocks
    // public static String searchAttribute(List<Person> personlist, String query, String attribute) {
    //     char[] qArray = turn_search(query);
    //     int tot = personlist.size();
    //     String candidate = "";
    //     double how_alike = 0;
    //     String attributeValue = "";
    //     for (int i = 0; i < tot; i++) {
    //         switch (attribute) {
    //             case "fName":
    //                 attributeValue = personlist.get(i).fName;
    //                 break;
    //             case "mName":
    //             attributeValue = personlist.get(i).mName;
    //                 break;
    //             case "lName":
    //             attributeValue = personlist.get(i).lName;
    //                 break;
    //             case "DOB":
    //             attributeValue = personlist.get(i).DOB;
    //                 break;
    //             case "SSN":
    //             attributeValue = personlist.get(i).SSN;
    //                 break;
    //             case "phone":
    //             attributeValue = personlist.get(i).phone;
    //                 break;
    //             case "address":
    //             attributeValue = personlist.get(i).address;
    //                 break;
    //             case "allergies":
    //             attributeValue = personlist.get(i).allergies;
    //                 break;
    //             // will need to do something unique here
    //             case "type":
    //             attributeValue = personlist.get(i).type;
    //                 break;
    //             case "courses":
    //             attributeValue = personlist.get(i).courses;
    //                 break;

    //         }
    //         // turn below into a reusable statement
    //         // char[] firstNameArray = turn_search(personlist.get(i).fName);
    //         // ensure all of the candidates are being looked at
    //         // update the top contender
    //         char[] attArray = turn_search(attributeValue);
    //         if (likeness(attArray, qArray) > how_alike) {
    //             how_alike = likeness(attArray, qArray);
    //             candidate = attributeValue;
    //         }
    //     }
    //     return candidate;
    // }
    // search fName looks through the person objects and checks to see how close they are to the user's query
    public static String searchfName(List<Person> personlist, String query) {
        //turn_search will convert the string into caps and a character array to be used to compare
        char[] qArray = turn_search(query);
        //getting the size of the Person list 
        int tot = personlist.size();
        //candidate will be the most likely searched for name 
        String candidate = "";
        //how_alike will save the best score for each name and consequently the name that generates the best score 
        double how_alike = 0;
        for (int i = 0; i < tot; i++) {
            //need to regenerate the firstnamearray each time because we are doing the entire list
            char[] firstNameArray = turn_search(personlist.get(i).fName);
            // ensure all of the candidates are being looked at
            // update the top contender
            //likeness calculates the score of how many characters line up and if this score is higher than the previous one then it will be saved instead
            if (likeness(firstNameArray, qArray) > how_alike) {
                how_alike = likeness(firstNameArray, qArray);
                candidate = personlist.get(i).fName;
            }
        }
        if(how_alike == 0)
        {
            candidate = "There were no matching names";
        }
        return candidate;
    }
    //a function to return the ratio of matching characters to total length of the firstname 
    public static double likeness(char[] firstname, char[] query) {
        double score = 0;
        // go through the first whole person array
        for (int i = 0; i < firstname.length; i++) {

            // go through the second query array
            for (int j = 0; j < query.length; j++) {
                if (query[j] == firstname[i]) {

                    score++;
                }
            }
        }
        // char[] fArray = turn_search(personlist.get(tot - 1).fName);
        // total is the person list size which is the real amount of person objects
        double calc = 0.0;
        // calc is the percent of matching characters in the array - rather an estimate
        // of how accurate the query is to the looked for entry. Somewhat accurate but
        // is prone to mistakes due to some characters repeating
        calc = score / query.length;
        System.out.println(calc);
        return calc;
    }

    public static char[] turn_search(String makeMe) {
        // a function to convert a string into an uppercase character array
        makeMe = makeMe.toUpperCase();
        char[] useMe = makeMe.toCharArray();
        return useMe;
    }

    public static int user_filtering(String users_attempt) {
        // creating variables and assigning them values to be used later in the program
        boolean trap = true;
        int b = 0;
        while (trap) {
            // entrapment of user to ensure they enter a correct number
            System.out.println("Enter a number (with no spaces)");
            users_attempt = System.console().readLine();
            try {
                // will turn the user's input variable into the preinitalized int if it can,
                // otherwise it throws error which will be caught below
                b = Integer.parseInt(users_attempt);
                trap = false;
            } catch (Exception e) {
                // in the event that the string can't be converted to an integer it will display
                // this message instead
                System.out.println("That is not a number");
            }
        }
        // where b is the number the user inputs
        return b;
    }
}