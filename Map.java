import java.util.*;
import java.io.*;

// class to create mapping gample including movement and inserting puzzles

public class Map {

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

    //instance variables

    // delete private int Row,Col,Num1,Num2;
    private static int p1 = 0;
    private static int p2 = 0;
    private String Move;
    private boolean Running = true;
    static int Array[][];
    private int size = 7; // map size hard coded (change maybe later)
    private int level;
    String[] exits = {"\nYou've found the gate to exit the garden!", "\nYou found an opening in the forest!", "\nYou found the door to the throne room!"};// exit dialog
    String exitD; // dialog for winning level

    static ArrayList<Item> inventory = new ArrayList<Item>(); // Create an ArrayList object of type Item
    static Item[][] itemGrid; //to put the items on the map

    // constructor !!!
    public Map(int level) {

        this.level = level;
        this.Array = new int[this.size][this.size];
        exitD = exits[level - 1];
        this.inventory = new ArrayList<>();
        itemGrid = new Item[size][size];

        //making the keys and assigning key names per level

        Solution puzzleKey = new Solution("key", "mysterious key to the garden gate.");

        if (this.level == 1) {

            puzzleKey.setName("a key\n");
            puzzleKey.setType("mysterious key to the garden gate.");
            itemGrid[4][0] = puzzleKey; // Place key on the map

            //adding some extra items! (can change player health or score)
            Item potion = new Item("a potion\n", "A dangerous concoction...");
            itemGrid[2][1] = potion;

            Item coinBag = new Item("a coin bag\n", "A bag of valuable gold coins!");
            itemGrid[4][1] = coinBag;

            // changes items present for lvl 2
        } else if (this.level == 2) {

            Solution axe = new Solution("an axe\n", "heavy axe to chop down the big tree.");
            itemGrid[0][2] = axe; // Place axe on the map

            //adding some extra items! (can change player health or score)
            Item potion = new Item("a potion\n", "A dangerous concoction...");
            itemGrid[2][3] = potion;


            //changes items present for lvl 3
        } else if (level == 3) {

            Solution wand = new Solution("magic wand\n", "shimmering wand to take the spell off the castle.");
            itemGrid[2][3] = wand; // Place magic wand on the map

            //adding some extra items! (can change player health or score)
            Item potion = new Item("a potion\n", "A dangerous concoction...");
            itemGrid[3][3] = potion;
        }

        // create grid
        for (int i = 0; i < size; i++) {
            for (int x = 0; x < size; x++) {
                this.Array[i][x] = 0;
                this.Array[p1][p2] = 1;


                // creates patterns of making values 2 as borders * will edit later to be a complex path
                // creates patterns of making values 2 as borders * will edit later to be a complex path
                if (level == 1) {
                    if (((x + i) ^ 5) / 2 == 0 && x < size - 1 && i < size - 1 && i < size - 1 && x > 0 && i > 0) {
                        this.Array[i][x] = 2;
                        this.Array[this.p1][this.p2] = 1;
                    }
                } else if (level == 2) {
                    if (((x + i) ^ 7) / 2 == 0 && x < size - 1 && i < size - 1 && i < size - 1 && x > 0 && i > 0) {
                        this.Array[i][x] = 2;
                        this.Array[this.p1][this.p2] = 1;
                    }
                } else if (level == 3) {
                    if (((x + i) ^ 4) / 2 == 1 && x < size - 1 && i < size - 1 && i < size - 1 && x > 0 && i > 0) {
                        this.Array[i][x] = 2;
                        this.Array[this.p1][this.p2] = 1;
                    }
                }

            }
        }

        this.Array[p1][p2] = 1;
        Array[5][level + 3] = 3; // exit value is given 3

        // print grid for debugging purposed
        /*for (int i = 0; i < size; i++) {
            for (int x = 0; x < size; x++) {
                System.out.print(this.Array[i][x] + "\t");
            }
            System.out.println();
        }*/

    }
    // method to start the next round
    public void nextLevel() {

        if (level < 3) {
            new MyFrame(this.level);
            this.level++;
            p1 = 0;
            p2 = 0;// resets player starting position
            Map landscape = new Map(this.level); // start new level
            landscape.move();
        } else {
            new Boss(); // start final boss level
        }
    }

    // picking up items
    public static void pickUpItem() {

        Item item = itemGrid[p1][p2];

        if (item != null && !item.isPickedUp()) {
            item.pickUp();
            inventory.add(item);
            System.out.println("You picked up " + YELLOW + item.getName() + RESET + "!");
            itemGrid[p1][p2] = null; //taking item out

        }
        else if (item != null) {
            System.out.println("\n"+ item.getName() + " has already been picked up.");
        } else {
            System.out.println("\nNo item here to pick up.");
        }
    }


    //Checks if there is an item/key or not where the player is
    public Boolean checkTile() {
        Boolean haveKey = false;

        int tile = Array[p1][p2];

        if (itemGrid[p1][p2] != null) {  // Check if there's an item
            System.out.println(BLUE + "\nYou found an item!" + RESET);
            pickUpItem();
        } else if (tile == 3) {  // Locked Door
            unlockingDoor();
            haveKey = true;
            Array[p1][p2] = 3; // resets grid number for visual testing
            return haveKey;
        } else if (tile == 4) {  // Open Door
            System.out.println("The door is open!\n");
            return haveKey;
        } else {
            System.out.println("\nNothing important here. Keep searching.\n");
            return haveKey;
        }
        return haveKey;

    }

    // showing the player's inventory
    public void showInventory() {
        // Using bubbleSort to sort the inventory from item with the least characters to most
        for (int i = 0; i < inventory.size() - 1; i++) {
            for (int j = 0; j < inventory.size() - 1 - i; j++) {
                Item item1 = inventory.get(j);
                Item item2 = inventory.get(j + 1);

                // Compare the lengths of the item names
                if (item1.getName().length() > item2.getName().length()) {
                    // Swap the items if they are in the wrong order
                    inventory.set(j, item2);
                    inventory.set(j + 1, item1);
                }
            }
        }
        if (inventory.isEmpty()) {
            System.out.println("\nYour inventory is empty.");
        } else {
            System.out.println("Inventory: ");
            for (Item item : inventory) {
                System.out.println(BLUE + "- " + item.getName() + RESET);
            }
        }
    }

    // checks if player can unlock the exit puzzle or not
    public boolean unlockingDoor() {
        boolean hasKey = false;
        for (Item invItem : inventory) {
            if (invItem instanceof Solution) {
                hasKey = true;
                return hasKey;
            }
        }

        if (hasKey) {
            System.out.println("\nYou unlocked the path!");
            Array[p1][p2] = 4;  // Change to open door
        } else {
            System.out.println("\nThe exit is blocked. You must find something to open the path.");
            return hasKey;
        }
        return hasKey;
    }



    public void move() {


        while (Running) {

            Scanner input = new Scanner(System.in);

            try { // error handling for single letter prompts
                this.Move = input.next().substring(0, 2); // taking in prompts
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Please give a valid prompt (longer than one letter)\n");
                this.Move = input.next().substring(0, 2);
            }

            switch (Move) {
                case "so":
                case "So":

                    if (p1 < size - 1 && Array[p1 + 1][p2] != 2) { //prevents out of bounds
                        if (Array[p1][p2] == Array[5][level + 3 - 1] &&  unlockingDoor()) { // leave the  level if exit location is reached
                            System.out.println(YELLOW + exitD + " " + "Congratulations! You've moved on!\n" + RESET);
                            nextLevel();
                            Running = false;
                            break;
                        }
                        Array[p1][p2] = 0;
                        Array[p1 += 1][p2] = 1; // continue as normal if not at exit
                        checkTile();
                        break;
                    } else {
                        System.out.println("\nYour path here is blocked, try another way.\n");
                        break;
                    }

                case "no":
                case "No":

                    if (p1 > 0  && Array[p1 - 1][p2] != 2) { //prevents out of bounds
                        if (Array[p1][p2] == Array[5][level + 3 - 1] && unlockingDoor()) { // leave the  level if exit location is reached
                            System.out.println(YELLOW + exitD + " " + "Congratulations! You've moved on!\n" + RESET);
                            nextLevel();
                            Running = false;
                            break;
                        }
                        Array[p1][p2] = 0;
                        Array[p1 -= 1][p2] = 1;
                        checkTile();
                        break;
                    } else {
                        System.out.println("\nYour path here is blocked, try another way.\n");
                        break;
                    }
                case "ea":
                case "Ea":

                    if (p2 < size - 1 && Array[p1][p2 + 1] != 2) {
                        if (Array[p1][p2] == Array[5][level + 3 - 1] && unlockingDoor()) { // leave the  level if exit location is reached
                            System.out.println(YELLOW + exitD + " " + "Congratulations! You've moved on!\n" + RESET);
                            nextLevel();
                            Running = false;
                            break;
                        }
                        Array[p1][p2] = 0;
                        Array[p1][p2 += 1] = 1;
                        checkTile();
                        break;
                    } else {
                        System.out.println("Your path here is blocked, try another way.\n");
                        break;
                    }

                case "we":
                case "We":

                    if (p2 > 0 && Array[p1][p2 - 1] != 2) {
                        if (Array[p1][p2] == Array[5][level + 3 - 1] && unlockingDoor()) { // leave the  level if exit location is reached
                            System.out.println(YELLOW + exitD + " " + "Congratulations! You've moved on!\n" + RESET);
                            nextLevel();
                            Running = false;
                            break;
                        }
                        Array[p1][p2] = 0;
                        Array[p1][p2 -= 1] = 1;
                        checkTile();
                        break;
                    } else {
                        System.out.println("Your path here is blocked, try another way.\n");
                        break;
                    }

                case "le":
                case "Le":
                    System.out.println("You have exited the game...\n");
                    Running = false;
                    input.close();
                    break;

                case "in":
                case "In":
                    showInventory();
                    break;

                default:
                    System.out.println("I don't understand that.\n");
                    break;
            }



            // temporary printing of map for debugging
            /*for (int i = 0; i < size; i++) {
                for (int x = 0; x < size; x++) {
                    System.out.print(Array[i][x] + "\t");
                }
                System.out.println();
            }*/

        }

    }


    // getters

    // setters
}
    
