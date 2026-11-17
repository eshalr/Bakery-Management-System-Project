public class Cake extends Dessert {
/*Summary :  This is the Data Definition Class (Sub Class) extends to the dessert class for bakery management.
It contains all the necessary attributes like the message, layer amount, and price calculation  for the bakery 
order to handle these attributes. This includes the default and specific constructors for initializing the bakery 
objects, accessor methods, getMessage( ) and getLayers( ) to retrieve attribute values, mutator methods, setLayers( )
and setMessage( ) to modify those values, and any additional methods required for specific functionality such as toString.
 */


//instance variables
private String message;
private int layers;
//price of each cake 
public static final double PRICE = 11.50;

//Specific Constructor
public Cake(String flavor, int amount, String message, int layers) {
super(flavor, amount);
setMessage(message);
setLayers(layers);
}

//Accessor
public String getMessage() { return this.message; }

public int getLayers() { return this.layers; }


//Mutator
/* Ensures that the correct type of message and number of layers is specified by the user. */
public void setMessage(String message) {
    if (message.equals("") && message.isEmpty()) {
        throw new IllegalArgumentException("Error! There must be an input for message.\nIf no message is desired, please type 'No Message'");
    }
    this.message = message;
}


public void setLayers(int layers) {
    if (layers < 0 && layers > 5) {
        throw new IllegalArgumentException("Error! There must be at least one layer and\nour maximum layer count is 5!");
    }
   this.layers = layers;
}

//special purpose methods

/*Calculates the price and overrides the superclass' abstract method. First, the method checks if the amount
is applicable for the discount and if yes then the discount price is given. If not, then the normal price is given. */
public double calculatePrice() {
if(getAmount() > 5) {
        double discountPrice = (PRICE - (PRICE * 0.10)) * getAmount(); 
        return discountPrice;
    }
    else {
        return PRICE * getAmount();
    }
}

public String toString() {
    return "Cake Order: " + super.toString() + "      | " + this.getMessage() + "      | " + this.getLayers() + "      | $" + this.calculatePrice();
}
}
