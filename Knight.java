public class Knight {

    // instance variables (knight features)
    private String name;
    private int score;

    // constructors (if given name or not)

    public Knight(String name) {
        this.name = name;
        this.score = 0;
    }

     public Knight() {
        this.name = "Lancelot";
    }
  
    // getters 

    public String getName() {
        return this.name;
    }
    
    // setters

    public int increaseScore(int num) {

        this.score += num;
    } // increase score easily

    public int decreaseScore(int num) {

        this.score -= num;
    } // decrease score easily
}
