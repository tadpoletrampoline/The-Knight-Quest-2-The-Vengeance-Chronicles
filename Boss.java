
import java.util.*;
import java.io.*;

public class Boss {
    //Coloured Text
    static String RED = "\u001B[31m";
    static String BLACK = "\u001B[30m";
    static String YELLOW = "\u001B[33m";
    static String MAGENTA = "\u001B[35m";
    static String BLUE = "\u001B[34m";
    static String RESET = "\u001B[0m";
    static String BOLD = "\n\033[0;1m";
    static String UNBOLD = "\033[0;0m";

    //Highlighted Text
    static String BLACK_BG = "\u001B[40m";
    static String RED_BG = "\u001B[41m";
    static String GREEN_BG = "\u001B[42m";
    static String YELLOW_BG = "\u001B[43m";
    static String BLUE_BG = "\u001B[44m";
    static String PURPLE_BG = "\u001B[45m";
    static String CYAN_BG = "\u001B[46m";
    static String WHITE_BG = "\u001B[47m";

    private int guess; // intialize guess variable for number guessing

    private Boolean guessing;

    public Hashtable<String, String> riddles1 = new Hashtable<String, String>(); // list of riddles for phase 1
    public Hashtable<String, String> riddles2 = new Hashtable<String, String>(); // list of riddles for phase 2


    public Boss() {

        // Adding riddles and their answers for phase 1
        riddles1.put("\u001B[31mWhat goes up but never comes down?\u001B[0m", "age");
        riddles1.put("\u001B[31mA time when they're green. A time when they're brown. But both of these times, cause me to frown. But just in between, for a very short while. They're perfect and yellow. And cause me to smile.\u001B[0m", "banana");
        riddles1.put("\u001B[31mI fly, yet I have no wings. I cry, yet I have no eyes. Darkness follows me. Lower light I never see.\u001B[0m", "cloud");
        riddles1.put("\u001B[31mWhat can you catch but not throw?\u001B[0m", "cold");

        // Adding riddles and their answers for phase 2
        riddles2.put("\u001B[31mGive it food and it will live, give it water and it will die.\u001B[0m", "fire");
        riddles2.put("\u001B[31mI have a tail and a head, but no body. What am I?\u001B[0m", "coin");
        riddles2.put("\u001B[31mLong and think, red within, with a nail at the end.\u001B[0m", "finger");
        riddles2.put("\u001B[31mWhat has keys but can't open locks?\u001B[0m", "piano");

        // Start the game
        game1();

    }

    public void game1() {

        System.out.println(RED + "It is impressive that you've followed me this far... I shall put you under a spell so you don't attack me. If you wish to free yourself, all you have to do is player a few games with me." + RESET);
        System.out.println(RED + "I shall share with you a riddle, you must give me the correct answer, you have 5 guesses" + RESET);
        System.out.println(RED + "\n(All answers are one word and singular, good luck!)\n\n" + RESET);

        int limit = 5; // limited guesses
        int guesses = 0; // keep track of guesses
        this.guessing = true; // while loop for guessing

        // picking a random riddle from the hashmap
        Set<String> keys = riddles1.keySet();
        String[] keyArray = keys.toArray(new String[0]);
        Random random = new Random();
        String question = keyArray[random.nextInt(keyArray.length)];
        String answer = riddles1.get(question);

        System.out.println(question); // asking question

        while (this.guessing) {

            if (guesses < limit) { // guess if below limit

                Scanner input = new Scanner(System.in);
                System.out.print(BLUE + "\nEnter your guess: ");
                String guess = input.nextLine();

                if (guess.toLowerCase().equals(answer)) {
                    System.out.println("\n" +RED + "Wizard: " + BOLD + YELLOW + "Oh you actually guessed correctly... You shall now play another game." + RESET);
                    this.guessing = false;
                    game2();
                } else {
                    guesses++;
                    System.out.printf("\n" + RED + "Wizard: " + BOLD + YELLOW + " Incorrect Mwahaha! You only have %d guesses left!\n" + RESET, limit-guesses);
                }
            } else {
                System.out.println("\n"+ RED + "Wizard: " + BOLD + YELLOW+ " Haha you" + RED+" lost!" + RESET +" (You ran out guesses)\n");
                System.out.println(BLUE + "(Would you like to play again?\n\n"+GREEN_BG+ "Y" + RESET+ " or " + RED_BG + "N" + RESET);

                // replay stuff
                Scanner input = new Scanner(System.in);
                String replay = input.nextLine();

                if (replay.toLowerCase().equals("y")) {
                    this.guessing = false;
                    game1();
                } else if (replay.toLowerCase().equals("n")) {
                    this.guessing = false;
                    Main.menu();
                }
            }


        }

    }

    // method to use binary search to find the index of a random target in a random list which will be used for te player to guess a number
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public void game2() {
        int limit = 6;
        int guesses = 0; // keep track of guesses
        this.guessing = true;

        int[] numbers = new int [35]; // make a list of 35 numbers

        for (int i = 0; i < numbers.length; i++) { // fill array with random numbers
            numbers[i] = (int)(Math.random() * 100) + 1;
        }

        Arrays.sort(numbers);
        Random random = new Random();
        int target = numbers[random.nextInt(numbers.length)]; // sort array for binary search

        int index = binarySearch(numbers, target);
        System.out.println("\n" +RED+ "Wizard: " + YELLOW + " I'm thinking a number from 1-100, guess where it is this a list of 35 numbers" +RESET);
        System.out.println(BLUE + "(Guess the number in the list. Hint: Use binary search methods to help guess the number faster.)\n" + RESET);

        while (this.guessing) {

            if (guesses < limit) { // prevent guesses over the limit

                System.out.println(Arrays.toString(numbers)); // show list

                System.out.print(BLUE + "\nEnter a number: " + RESET);
                Scanner scanner = new Scanner(System.in);

                // getting guess
                try { // error handling
                    guess = scanner.nextInt();
                } catch (InputMismatchException e) {
                    scanner.next();
                    System.out.println("\nInvalid input. Please enter a valid number.\n\n");
                    guess = scanner.nextInt();
                }

                if (guess == target) {
                    System.out.println(RED + "\n\nWizard: " + YELLOW + " Oh you actually guessed correctly again... You shall now play " + RESET + RED_BG + BLACK + "a final game."+ RESET + "\n\n");
                    game3();
                    this.guessing = false;
                } else if (guess < target) {
                    guesses++;
                    System.out.printf(RED + "\nWizard: " + YELLOW + " Higher! Only %d guesses left!\n" + RESET, limit-guesses);
                } else if (guess > target) {
                    guesses++;
                    System.out.printf(RED + "Wizard: " + YELLOW + BOLD + " Lower! Only %d guesses left!\n" + RESET, limit-guesses);
                }
            } else {
                System.out.println("\n"+ RED + "Wizard: " + BOLD + YELLOW+ " Haha you" + RED+" lost!" + RESET +" (You ran out guesses)\n");
                System.out.println(BLUE + "(Would you like to play again?\n\n"+RESET+GREEN_BG+ "Y" + RESET+ " or " + RED_BG + "N" + RESET);

                // replay stuff
                Scanner input = new Scanner(System.in);
                String replay = input.nextLine();

                if (replay.toLowerCase().equals("y")) {
                    this.guessing = false;
                    game2();
                } else if (replay.toLowerCase().equals("n")) {
                    this.guessing = false;
                    Main.menu();
                }
            }
        }
    }


    public void game3() {
        int limit = 3;
        int guesses = 0; // keep track of guesses
        this.guessing = true; // while loop for guessing

        // picking a random riddle from the hashmap
        Set<String> keys = riddles2.keySet();
        String[] keyArray = keys.toArray(new String[0]);
        Random random = new Random();
        String question = keyArray[random.nextInt(keyArray.length)];
        String answer = riddles2.get(question);

        System.out.println(question); // asking question

        while (this.guessing) {

            if (guesses < limit) { // guess if below limit

                Scanner input = new Scanner(System.in);
                System.out.print(BLUE + "\nEnter your guess: " + RESET);
                String guess = input.nextLine();

                if (guess.toLowerCase().equals(answer)) {
                    System.out.println("\n\n\nOh.... you actually beat me at my own game.. " + RED_BG+ BLACK + " BUT STILL I CANNOT LET YOU LIVE!!! ." + RESET);
                    this.guessing = false;
                    new MyFrame(3); // cutscene
                } else {
                    guesses++;
                    System.out.printf("\n"+ RED +"Wizard:" + YELLOW + BOLD + " Incorrect Mwahaha! You only have %d guesses left!\n" + RESET, limit-guesses);
                }
            } else {
                System.out.println("\n"+ RED + "Wizard: " + BOLD + YELLOW+ " Haha you" + RED+" lost!" + RESET +" (You ran out guesses)\n");
                System.out.println(BLUE + "(Would you like to play again?\n\n"+GREEN_BG+ "Y" + RESET+ " or " + RED_BG + "N" + RESET);

                // replay stuff
                Scanner input = new Scanner(System.in);
                String replay = input.nextLine();

                if (replay.toLowerCase().equals("y")) {
                    this.guessing = false;
                    game3();
                } else if (replay.toLowerCase().equals("n")) {
                    this.guessing = false;
                    Main.menu();
                }

            }

        }
    }
}
