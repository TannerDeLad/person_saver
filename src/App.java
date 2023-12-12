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
        public String type;

        // method to set the above attributes to each object using the 'this' keywod
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
                        break;
                    case 2:
                        this.type = "Faculty";
                        small_trap = false;
                        break;
                    case 3:
                        this.type = "Staff";
                        small_trap = false;
                        break;
                    case 4:
                        this.type = "Student";
                        small_trap = false;
                        break;
                    default:
                        System.out.println("Please enter 1-4");
                        break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String user_in = "";
        boolean big_trap = true;
        // creating a list to save Person objects into
        List<Person> personlist = new ArrayList<Person>();
        // big while loop that encompasses the whole program
        while (big_trap) {
            System.out.println("Please select from the below options: \n");
            System.out.println("1: Add people \n");
            System.out.println("2: Search people \n");
            System.out.println("3: Exit program \n");
            // using the user_filtering function to ensure the user gives us an integer
            int a = user_filtering(user_in);
            String throwaway = "";
            // below are test people that can be used to utilize the search function
            // Person tester = new Person();
            // Person tester1 = new Person();
            // Person tester2 = new Person();
            // tester1.fName = "Stinker";
            // tester2.fName = "Thrower";
            // tester.fName = "Hill";
            // tester.address = "hill city";
            // tester1.address = "2424 w york st";
            // tester2.address = "2323 s yorkee ave";
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
                    // System.out.println("Enter the first name of the person you would like to look
                    // for: ");
                    Boolean search_trap = true;
                    List<String> rankingList;
                    if (personlist.size() == 0) {
                        System.out.println("There are no People to search for");
                    } else {
                        while (search_trap) {
                            System.out.println("Select which attribute you would like to search by: ");
                            System.out.println("1. First Name ");
                            System.out.println("2. Middle name");
                            System.out.println("3. Last Name");
                            System.out.println("4. Date of Birth");
                            System.out.println("5. Social Secuirty Number");
                            System.out.println("6. Phone Number");
                            System.out.println("7. Addresss");
                            System.out.println("8. Type of Person");
                            a = user_filtering(throwaway);
                            String searchthis = null;
                            switch (a) {
                                case 1:
                                    searchthis = getQuery();
                                    rankingList = searchAttribute(personlist, searchthis, "fName");
                                    outputOptions(personlist, rankingList, "fName");
                                    search_trap = false;
                                    break;
                                case 2:
                                    searchthis = getQuery();
                                    rankingList = searchAttribute(personlist, searchthis, "mName");
                                    outputOptions(personlist, rankingList, "mName");
                                    search_trap = false;
                                    break;
                                case 3:
                                    searchthis = getQuery();
                                    rankingList = searchAttribute(personlist, searchthis, "lName");
                                    outputOptions(personlist, rankingList, "lName");
                                    search_trap = false;
                                    break;
                                case 4:
                                    searchthis = getQuery();
                                    rankingList = searchAttribute(personlist, searchthis, "DOB");
                                    outputOptions(personlist, rankingList, "DOB");
                                    search_trap = false;
                                    break;
                                case 5:
                                    searchthis = getQuery();
                                    rankingList = searchAttribute(personlist, searchthis, "SSN");
                                    outputOptions(personlist, rankingList, "SSN");
                                    search_trap = false;
                                    break;
                                case 6:
                                    searchthis = getQuery();
                                    rankingList = searchAttribute(personlist, searchthis, "phone");
                                    outputOptions(personlist, rankingList, "phone");
                                    search_trap = false;
                                    break;
                                case 7:
                                    searchthis = getQuery();
                                    rankingList = searchAttribute(personlist, searchthis, "address");
                                    outputOptions(personlist, rankingList, "address");
                                    search_trap = false;
                                    break;
                                case 8:
                                    searchthis = getQuery();
                                    rankingList = searchAttribute(personlist, searchthis, "type");
                                    outputOptions(personlist, rankingList, "type");
                                    search_trap = false;
                                default:
                                    System.out.println("Please select from the correct options: ");
                                    break;
                            }
                            // System.out.println("Are you seraching for " + searchfName(personlist,
                            // throwaway));
                            // searchfName will be called and needs the list of Person objects with the
                            // query the user input
                        }
                    }
                    break;
                case 3:
                    // java exit
                    System.exit(0);
                    break;

                default:
                    // user handling with a default that will keep the user contained until they
                    // choose 1 2 or 3
                    System.out.println("Please input 1, 2 or 3");
                    break;
            }
        }
    }

    // below was the beginning of search by attribute - it worked just needed to
    // prompt the user to select which attribute they wanted and ask for that
    // specific input. Would need to change for the type attribute however, likely
    // use some if blocks
    public static void outputOptions(List<Person> personList, List<String> rankingList, String attribute) {
        System.out.println("Here's what was found: ");
        System.out.println("Select from the following");
        for (int i = 0; i < rankingList.size(); i++) {
            System.out.println(i + 1 + ". " + rankingList.get(i));
        }

        // ensure user chooses a number
        String rankingListOption = "";
        int selection = user_filtering(rankingListOption);
        boolean outputTrap = true;
        while (outputTrap) {
            if (selection > rankingList.size() || selection <= 0) {
                System.out.println("Select from the options");
                selection = user_filtering(rankingListOption);
                // break;
            } else if (rankingList.size() == 0) {
                System.out.println("Refine your query and try again");
            } else {
                outputTrap = false;
            }
        }

        // use number -1 to select from ranklist
        rankingListOption = rankingList.get(selection - 1);
        // iterate through person list with .attribute and compare it to ranklist option
        // if match output that Person
        Person outputThisPerson = null;
        for (int i = 0; i < personList.size(); i++) {
            // String searchme = personList.get(i) + "." + attribute;
            // System.out.println(personList.get(i) + "." + attribute);
            // if (personList.get(i) + "." + attribute == rankingListOption) {
            // outputThisPerson = personList.get(i);
            // }
            switch (attribute) {
                case "fName":
                    if (personList.get(i).fName == rankingListOption) {
                        outputThisPerson = personList.get(i);
                    }
                    break;
                case "mName":
                    if (personList.get(i).mName == rankingListOption) {
                        outputThisPerson = personList.get(i);
                    }
                    break;
                case "lName":
                    if (personList.get(i).lName == rankingListOption) {
                        outputThisPerson = personList.get(i);
                    }
                    break;
                case "DOB":
                    if (personList.get(i).DOB == rankingListOption) {
                        outputThisPerson = personList.get(i);
                    }
                    break;
                case "SSN":
                    if (personList.get(i).SSN == rankingListOption) {
                        outputThisPerson = personList.get(i);
                    }
                    break;
                case "phone":
                    if (personList.get(i).phone == rankingListOption) {
                        outputThisPerson = personList.get(i);
                    }
                    break;
                case "address":
                    if (personList.get(i).address == rankingListOption) {
                        outputThisPerson = personList.get(i);
                    }
                    break;
                // will need to do something unique here
                case "type":
                    if (personList.get(i).type == rankingListOption) {
                        outputThisPerson = personList.get(i);
                    }
                    break;
            }
            if (outputThisPerson != null) {
                break;
            }
        }
        System.out.println("First Name: " + outputThisPerson.fName);
        System.out.println("Middle Name: " + outputThisPerson.mName);
        System.out.println("Last Name: " + outputThisPerson.lName);
        System.out.println("Date of Birth: " + outputThisPerson.DOB);
        System.out.println("Social Security: " + outputThisPerson.SSN);
        System.out.println("Address: " + outputThisPerson.address);
        System.out.println("Phone: " + outputThisPerson.phone);
        System.out.println("Type: " + outputThisPerson.type);
        System.out.println("Press enter key to continue");
        System.console().readLine();
        // accept user input and filter
    }

    public static List<String> searchAttribute(List<Person> personlist, String query, String attribute) {
        // turn the query into a character array
        char[] qArray = turn_search(query);
        // get the size of the list because we're about to iterate through it
        int tot = personlist.size();
        // other variables for later use
        double how_alike = 0;
        String attributeValue = "";
        List<String> outList = new ArrayList<String>();
        for (int i = 0; i < tot; i++) {
            switch (attribute) {
                case "fName":
                    attributeValue = personlist.get(i).fName;
                    break;
                case "mName":
                    attributeValue = personlist.get(i).mName;
                    break;
                case "lName":
                    attributeValue = personlist.get(i).lName;
                    break;
                case "DOB":
                    attributeValue = personlist.get(i).DOB;
                    break;
                case "SSN":
                    attributeValue = personlist.get(i).SSN;
                    break;
                case "phone":
                    attributeValue = personlist.get(i).phone;
                    break;
                case "address":
                    attributeValue = personlist.get(i).address;
                    break;
                // will need to do something unique here
                case "type":
                    attributeValue = personlist.get(i).type;
                    break;
            }
            // turn below into a reusable statement
            // char[] firstNameArray = turn_search(personlist.get(i).fName);
            // ensure all of the candidates are being looked at
            // update the top contender
            // attempt array
            char[] attArray = turn_search(attributeValue);
            if (likeness(attArray, qArray) > how_alike) {
                // System.out.println(how_alike);
                how_alike = likeness(attArray, qArray);
                outList.add(attributeValue);
            }
        }
        outList.sort(null);
        // sort list before returning
        return outList;
    }

    public static String getQuery() {
        System.out.println("Enter the search criteria: ");
        String response = System.console().readLine();
        return response;
    }

    // a function to return the ratio of matching characters to total length of the
    // firstname
    public static double likeness(char[] passedAtt, char[] query) {
        double score = 0;
        // go through the first whole person array
        for (int i = 0; i < passedAtt.length; i++) {

            // go through the second query array
            for (int j = 0; j < query.length; j++) {
                if (query[j] == passedAtt[i]) {
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
        // System.out.println(calc);
        return calc;
    }

    public static char[] turn_search(String makeMe) {
        // a function to convert a string into an uppercase character array
        makeMe.toUpperCase();
        char[] useMe = makeMe.toCharArray();
        return useMe;
    }

    public static int user_filtering(String users_attempt) {
        // creating variables and assigning them values to be used later in the program
        boolean trap = true;
        int b = 0;
        while (trap) {
            // entrapment of user to ensure they enter a correct number
            users_attempt = System.console().readLine();
            try {
                // will turn the user's input variable into the preinitalized int if it can,
                // otherwise it throws error which will be caught below
                b = Integer.parseInt(users_attempt);
                trap = false;
            } catch (Exception e) {
                // in the event that the string can't be converted to an integer it will display
                // this message instead
                System.out.println("Enter a number (with no spaces)");
            }
        }
        // where b is the number the user inputs
        return b;
    }
}