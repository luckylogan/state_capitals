import java.util.*;

public class MainClass {
    // Declare a constant 2D array to store the state-capital pairs
    private static final String[][] STATE_CAPITALS = {
            {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
            "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
            "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
            "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
            "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
            "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
            "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"},
            {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford",
            "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis",
            "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston",
            "Lansing", "Saint Paul", "Jackson", "Jefferson City", "Helena", "Lincoln", "Carson City",
            "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City",
            "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City",
            "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a state capital and check if it's correct
        String capital = promptUserForCapital(scanner);
        checkCapital(capital);

        // Print the contents of the 2D array
        printStateCapitals();

        // Sort the array by capital using bubble sort
        bubbleSortByCapital();

        // Quiz the user on state capitals
        quizUser(scanner);

        // Create a HashMap of state-capital pairs
        HashMap<String, String> capitalMap = createCapitalMap();
        printCapitalMap(capitalMap);

        // Sort the HashMap using TreeMap
        TreeMap<String, String> sortedCapitalMap = new TreeMap<>(capitalMap);

        // Prompt the user to enter a state and display its capital
        promptUserForState(scanner, sortedCapitalMap);

        System.out.println("Thank you for using the State Capital Quiz program!");
    }

    // Prompt the user to enter a state capital
    private static String promptUserForCapital(Scanner scanner) {
        System.out.print("Please enter a state capital: ");
        return scanner.nextLine();
    }

    // Check if the entered capital is a valid US state capital
    private static void checkCapital(String capital) {
        boolean isCapital = Arrays.asList(STATE_CAPITALS[1]).contains(capital);
        if (isCapital) {
            System.out.println("Yes, " + capital + " is a US state capital!");
        } else {
            System.out.println("No, " + capital + " is not a US state capital.");
        }
    }

    // Print the contents of the 2D array
    private static void printStateCapitals() {
        System.out.println("\nState Capitals:");
        for (int i = 0; i < STATE_CAPITALS[0].length; i++) {
            System.out.println(STATE_CAPITALS[0][i] + " - " + STATE_CAPITALS[1][i]);
        }
    }

    // Sort the array by capital using bubble sort
    private static void bubbleSortByCapital() {
        int n = STATE_CAPITALS[0].length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (STATE_CAPITALS[1][j].compareTo(STATE_CAPITALS[1][j + 1]) > 0) {
                    // Swap capitals
                    String tempCapital = STATE_CAPITALS[1][j];
                    STATE_CAPITALS[1][j] = STATE_CAPITALS[1][j + 1];
                    STATE_CAPITALS[1][j + 1] = tempCapital;

                    // Swap states
                    String tempState = STATE_CAPITALS[0][j];
                    STATE_CAPITALS[0][j] = STATE_CAPITALS[0][j + 1];
                    STATE_CAPITALS[0][j + 1] = tempState;
                }
            }
        }
    }

    // Quiz the user on state capitals
    private static void quizUser(Scanner scanner) {
        System.out.println("\nLet's quiz your knowledge of state capitals!");
        System.out.println("Enter as many state capitals as you can (one per line).");
        System.out.println("Type 'done' when you're finished.");

        List<String> userAnswers = new ArrayList<>();
        String answer;
        while (!(answer = scanner.nextLine()).equalsIgnoreCase("done")) {
            userAnswers.add(answer);
        }

        int correctCount = countCorrectAnswers(userAnswers);
        System.out.println("You got " + correctCount + " out of " + userAnswers.size() + " capitals correct!");
    }

    // Count the number of correct answers entered by the user
    private static int countCorrectAnswers(List<String> userAnswers) {
        int count = 0;
        for (String answer : userAnswers) {
            if (Arrays.asList(STATE_CAPITALS[1]).contains(answer)) {
                count++;
            }
        }
        return count;
    }

    // Create a HashMap of state-capital pairs
    private static HashMap<String, String> createCapitalMap() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < STATE_CAPITALS[0].length; i++) {
            map.put(STATE_CAPITALS[0][i], STATE_CAPITALS[1][i]);
        }
        return map;
    }

    // Print the contents of the HashMap
    private static void printCapitalMap(HashMap<String, String> capitalMap) {
        System.out.println("\nState-Capital HashMap:");
        for (Map.Entry<String, String> entry : capitalMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    // Prompt the user to enter a state and display its capital
    private static void promptUserForState(Scanner scanner, TreeMap<String, String> sortedCapitalMap) {
        System.out.println("\nEnter a state to get its capital (type 'done' to exit):");
        String state;
        while (!(state = scanner.nextLine()).equalsIgnoreCase("done")) {
            String capital = sortedCapitalMap.get(state);
            if (capital != null) {
                System.out.println("The capital of " + state + " is " + capital + ".");
            } else {
                System.out.println("State not found. Please try again.");
            }
        }
    }
}