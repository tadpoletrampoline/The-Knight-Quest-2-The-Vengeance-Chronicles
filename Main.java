import java.util.*;

public class Main {

    // variables
    ArrayList<Item> items = new ArrayList<Item>(); // Create an ArrayList object of type Item
    
    //Coloured Text
    static String RED = "\u001B[31m";
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

    //setting up the game
    int score = 0;
    boolean hasItem = false;
    int location = 1; // signifies location/level
    
    static Scanner options = new Scanner(System.in); //player options for the menu
    
    static void menu(){
        
        Boolean start = true; // control menu
        
        System.out.println(BOLD + "Hello there! Welcome to " + WHITE_BG + BLUE + "THE KNIGHT'S QUEST 2: THE VENGEANCE CHRONICLES" + RESET + UNBOLD);
        System.out.println(BOLD + "This is the text-based Java sequal to the original game! Have fun!" + UNBOLD);
        
        System.out.println("\nTo view the instructions please press: " + BOLD + BLUE + "[i]"); 
        System.out.println(RESET + "\nTo begin the game please press: " + BOLD + MAGENTA + "[S]"); 
        System.out.println(RESET + "\nIf at any point you would like to leave the game, type: " + BOLD + YELLOW + "[L] or [leave]\n" + RESET); 
        
        
        //menu ramble... press s to start...press i for intructions");
        
        String menu = options.nextLine().toLowerCase();

        switch(menu) {
            case "s": //starting the game
                System.out.println("\n... ... ... ...STARTING GAME... ... ... ...\n");
                
                start = false;
                gameIntro();
                
                
                Map landscape = new Map(1); // initializing map object!!!
                landscape.move();
                break;

            case "i":
                instructions();
                menu();
                break;
                
            case "l": //lets player exit game
                System.out.println("bye bye");
                System.exit(0);

            default: 
                System.out.println("how dare you, please type in one of the proper options");
                menu(); // recursion!!!
                break;
        }
    }

    static void instructions(){
        System.out.println("these are the very cool instructions");
        System.out.println("if you want to do this then blah blah blah...");

    }

    static void gameIntro(){
        
        System.out.print("\n\nWelcome brave player! Last we left off the wicked wizard had kidnapped yoru sister! Luckily, you were there ");
        System.out.print("to stop his antics however... it was to late. Your sister spent her final moments in that tower" +BLUE+ " cold " + RESET+ "and"+BLUE+ " alone." +RESET);
        System.out.println("The wizard must" +RED+" pay " +RESET+ "for his transgressions. He has already begun to flee.. but he won't last for long.");
        
        
        System.out.println("\n\nEnter your username (default is Lancelot): ");

        String username = options.nextLine();
        Knight person = new Knight(username);/// knight object created!!
        
        System.out.println("\n\n" +RED_BG+ person.getName() + " are you ready to defeat the wizard? Let's begin your journey...\n\n" + RESET);

    }

    static void levelOne(){
        System.out.println("this is level one");
    }

    // Methods for cutscene
    //static void cutsene1() {System.out.println("hi)};

    public static void main(String[] args) {

        // lets player start the game
        menu();

        try {

            FileWriter results = new FileWriter("Stats.txt");
            results.write("--------------------------\n\nGreat job!!\n!");
            results.write("Here is how you did on the game: \n");
            results.write("Score: ");
            results.write("Remaing health: ");

            results.close();
            System.out.println("\nSuccessfully gathered player statistic.");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();

        }



    }
}
