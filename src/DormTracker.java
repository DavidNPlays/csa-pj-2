
// DormTracker.java
import java.util.ArrayList;
import java.util.Scanner;
public class DormTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: Create ArrayList to store Person objects **David did this part**
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Roommate("Jenny", 7, "Chips", "Quiet solo", 204)); // adding roommates to array list called people
        people.add(new Roommate("Rohan", 11, "Ramen", "Loud music", 206));
        people.add(new Roommate("Bibi", 11, "Ramen", "Loud music", 206));
        people.add(new RA("Samantha", 9, "Protein Bar", "Organized groups", 2)); 
        // TODO: Add some sample people (Roommate and RA) to the list **Krish did this part**
        String[] chores = {"Vacuum", "Trash", "Dishes", "Laundry"}; //simple array for immutability
        String[] weeklyChores = new String[7];
        boolean running = true;
        // TODO : Print choices **Zaid did this part**
        while (running) {
            System.out.println("\nWelcome to the Dorm Roommate Tracker");
            System.out.println("\nEnter option: ");
            System.out.println("1 = View all people");
            System.out.println("2 = Show people who wake up before a certain time");
            System.out.println("3 = Assign and display weekly chore schedule");
            System.out.println("4 = Check roommate compatibility");
            System.out.println("5 = Add a new person");
            System.out.println("6 = Exit");
            System.out.print("\nEnter choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            // TODO: Print info for all people **Krish did this part**
            if (choice == 1) {
                for (int i = 0; i < people.size(); i++) 
                {
                    System.out.println(people.get(i).getInfo());
                }
            // TODO: Ask for time and show people who wake up earlier **Albert did this part**
            } else if (choice == 2){
                System.out.print("Enter wake-up time to filter (hour in 24hr format): ");
                int wakeTime = Integer.parseInt(scanner.nextLine());//parse int in case of human error
                for (int i = 0; i < people.size(); i++) // iterates through each person in the array
                {
                    if (wakeTime>people.get(i).getWakeUpTime()) // checks to see if index i person in the array wakes up before wakeTime
                    {
                        System.out.println(people.get(i).getName()); // prints their name if they wake up before
                    }
                }
            // TODO: Assign chores to each day of the week and display them **Albert did this part**
            } else if (choice == 3) {
                System.out.println("Weekly Chore Calendar: ");
                for (int i = 0; i < weeklyChores.length; i ++) // iterates through all the elements in weeklyChores
                {
                    System.out.println("Day " + i + ": " + chores[i % chores.length]); // prints out the chore for index i
                }
            // TODO: Ask for two names and compare compatibility
            // Hint : Incompatible: different study style OR wake-up time differs by 2+ hours
            // Hint : Compatible: similar study style AND wake-up time differs by 0-1 hour
            // Hint : One or both Person objects are null
            } else if (choice == 4) {
                System.out.print("Enter first person name: ");
                String name1 = scanner.nextLine();
                System.out.print("Enter second person name: "); // **Krish did this part**
                String name2 = scanner.nextLine();
                Person first = null;
                Person second = null;
                for (int i = 0; i < people.size(); i++) {
                    if (people.get(i).name.equals(name1)) { //checks for the name in people array
                        first = people.get(i); // assigns it to first
                    }
                    if (people.get(i).name.equals(name2)) { // same as first
                        second = people.get(i);
                    }
                }
                if ((first.studyStyle.equals(second.studyStyle))&&(Math.abs(first.wakeUpTime-second.wakeUpTime)<=1)) // condition to check if they match
                {
                    System.out.println("Compatible: " + name1 + " prefers " + first.studyStyle + " and wakes at "+first.wakeUpTime+ ", " + name2 + " prefers " + second.studyStyle + " and wakes at "+second.wakeUpTime+".");
                }
                else{ // in the case they do not match
                    System.out.println("Incompatible: " + name1 + " prefers " + first.studyStyle + " and wakes at "+first.wakeUpTime+ ", " + name2 + " prefers " + second.studyStyle + " and wakes at "+second.wakeUpTime+".");
                }


            // TODO: Prompt user to add a new RA or Roommate **Albert did this part**
            } else if (choice == 5) {
                System.out.print("Enter type (RA/Roommate): ");
                String type = scanner.nextLine(); // string value for roommate

                System.out.print("Enter name: ");
                String newName = scanner.nextLine(); 

                System.out.print("Enter wake-up time: ");
                int newWakeTime = Integer.parseInt(scanner.nextLine()); // int value for waking up

                System.out.print("Enter favorite snack: ");
                String newSnack = scanner.nextLine();

                System.out.print("Enter study style: ");
                String newStudyStyle = scanner.nextLine();

                if (type.equals("Roommate"))
                {
                    System.out.print("Enter room number: ");
                    int newRoomNum = Integer.parseInt(scanner.nextLine());
                    people.add(new Roommate(newName, newWakeTime, newSnack, newStudyStyle, newRoomNum)); // adds a new instance(roommate)
                }
                else {
                    System.out.print("Enter floor number: ");
                    int newFloor = Integer.parseInt(scanner.nextLine());
                    people.add(new RA(newName, newWakeTime, newSnack, newStudyStyle, newFloor)); // adds a new instance(roommate w/ RA privileges)
                }

                System.out.println("New roommate added.");



            // TODO: Exit
            } else if (choice == 6) {
                running = false;
                System.out.println("Exiting program."); // **Zaid did this part**
            } else {
                System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
