public class Item {

    // instance variables (item features)

    private String type; // there are type locks and type keys which can be used to perform their tasks
    private String name; // item name
    private boolean pickedUp; //for user to pick up items

    // constructor
    
   public Item(){
        this.type = type;
        this.name = name;
        this.pickedUp = false;
    }

  
    // getters 
    
    public String getType() {
        return this.type;
    }

    public String getName(){
        return this.name;
    }
    
    public boolean isPickedUp() {
        return pickedUp;
    }

    
    // setters
    public void setType(String t) {
		type = t;
	}
	
    public void setName(String n) {
		name = n;
	}
	
    public void pickUp() {
        this.pickedUp = true;
    }
}
