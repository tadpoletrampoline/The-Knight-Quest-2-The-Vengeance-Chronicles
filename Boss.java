import java.util.*;
import java.io.*;

public class Boss {

    private int guess; // intialize guess variable for number guessing

    private Boolean guessing;

    public Hashtable<String, String> riddles1 = new Hashtable<String, String>(); // list of riddles for phase 1
    public Hashtable<String, String> riddles2 = new Hashtable<String, String>(); // list of riddles for phase 2


    public Boss() {

        // Adding riddles and their answers for phase 1
        riddles1.put("What goes up but never comes down?", "age");
        riddles1.put("A time when they're green. A time when they're brown. But both of these times, cause me to frown. But just in between, for a very short while. They're perfect and yellow. And cause me to smile.", "banana");
        riddles1.put("I fly, yet I have no wings. I cry, yet I have no eyes. Darkness follows me. Lower light I never see.", "cloud");
        riddles1.put("What can you catch but not throw?", "cold");

        // Adding riddles and their answers for phase 2
        riddles2.put("Give it food and it will live, give it water and it will die.", "fire");
        riddles2.put("I have a tail and a head, but no body. What am I?", "coin");
        riddles2.put("Long and think, red within, with a nail at the end.", "finger");
        riddles2.put("What has keys but can't open locks?", "piano");

        // Start the game
        game1();

    }

    public void game1() {

        System.out.println("It is impressive that you've followed me this far... I shall put you under a spell so you don't attack me. If you wish to free yourself, all you have to do is player a few games with me.");
        System.out.println("I shall share with you a riddle, you must give me the correct answer, you have 5 guesses");
        System.out.println("(All answers are one word and singular, good luck!)");

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
                System.out.print("Enter your guess: ");
                String guess = input.nextLine();

                if (guess.toLowerCase().equals(answer)) {
                    System.out.println("Wizard: Oh you actually guessed correctly... You shall now play another game.");
                    this.guessing = false;
                    game2();
                } else {
                    guesses++;
                    System.out.printf("Wizard: Incorrect Mwahaha! You only have %d guesses left!\n", limit-guesses);
                }
            } else {
                System.out.println("Wizard: Haha you lost! (You ran out guesses");
                System.out.println("(Would you like to play again? Y or N");

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
        System.out.println("Wizard: I'm thinking a number from 1-100, guess where it is this a list of 35 numbers");
        System.out.println("(Guess the number in the list. Hint: Use binary search methods to help guess the number faster.)");

        while (this.guessing) {

            if (guesses < limit) { // prevent guesses over the limit

                System.out.println(Arrays.toString(numbers)); // show list

                System.out.print("Enter a number: ");
                Scanner scanner = new Scanner(System.in);

                // getting guess
                try { // error handling
                    guess = scanner.nextInt();
                } catch (InputMismatchException e) {
                    scanner.next();
                    System.out.println("Invalid input. Please enter a valid number.");
                    guess = scanner.nextInt();
                }

                if (guess == target) {
                    System.out.println("Wizard: Oh you actually guessed correctly again... You shall now play a final game.");
                    game3();
                    this.guessing = false;
                } else if (guess < target) {
                    guesses++;
                    System.out.printf("Wizard: Higher! Only %d guesses left!\n", limit-guesses);
                } else if (guess > target) {
                    guesses++;
                    System.out.printf("Wizard: Lower! Only %d guesses left!\n", limit-guesses);
                }
            } else {
                System.out.println("Haha you lost! (You ran out guesses)");
                System.out.println("Wizard: Haha you lost! You ran out guesses!");
                System.out.println("(Would you like to play again? Y or N)");

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
                System.out.print("Enter your guess: ");
                String guess = input.nextLine();

                if (guess.toLowerCase().equals(answer)) {
                    System.out.println("Oh you actually beat me at my own game.. BUT STILL I CANNOT LET YOU LIVE!!! .");
                    this.guessing = false;
                    new MyFrame(3); // cutscene
                } else {
                    guesses++;
                    System.out.printf("Wizard: Incorrect Mwahaha! You only have %d guesses left!", limit-guesses);
                }
            } else {
                System.out.println("Wizard: Haha you lost! You ran out guesses!");
                System.out.println("(Would you like to play again? Y or N)");

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

