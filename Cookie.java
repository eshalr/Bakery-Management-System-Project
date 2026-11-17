public class Cookie extends Dessert{
/*Summary : This is the Data Definition Class (Sub Class) extends to the dessert super class for bakery management. 
It contains all the necessary attributes like the topping, shape, and price calculation for the bakery order to handle
these attributes. This includes the default and specific constructors for initializing the bakery objects, accessor methods,
getTopping( ) and getShape( )  to retrieve attribute values, mutator methods, setTopping( ) setShape() and to modify those values,
 and any additional methods required for specific functionality such as toString.
 */

//instance variables
private String topping;
private String shape;
private final double PRICE = 3.25;

//specific constructor
public Cookie(String flavor, int amount, String topping, String shape) {
    super(flavor, amount);
    setTopping(topping);
    setShape(shape);
}

//mutators
/* Makes sure that topping and shape variables have something typed into them and aren't blank. */
public void setTopping(String topping) {
    if (topping.equals("") || topping.isEmpty()) {
        throw new IllegalArgumentException("Error! There must be an input for topping");
    }
    if(!topping.equalsIgnoreCase("Chocolate Chips")&& !topping.equalsIgnoreCase("Sprinkles")&& !topping.equalsIgnoreCase("Frosting")){
            throw new IllegalArgumentException("The topping must be chocolate chips, sprinkles, or frosting.");
        }
    this.topping = topping;
    
}
public void setShape(String shape) {
    if (shape.equals("") || shape.isEmpty()) {
        throw new IllegalArgumentException("Error! There must be an input for shape");
    }
    if(!shape.equalsIgnoreCase("Heart")&& !shape.equalsIgnoreCase("Circle")&& !shape.equalsIgnoreCase("Star")){
            throw new IllegalArgumentException("The shape must be heart, circle, or star");
        }

    this.shape = shape;
}

//accesors
public String getTopping() {
    return this.topping;
}
public String getShape() {
    return this.shape;
}


//special purpose methods

/*Calculates the price and overrides the superclass' abstract method. First, the method checks if the amount
is applicable for the discount and if yes then the discount price is given. If not, then the normal price is given. */
public double calculatePrice() {
    if(getAmount() > 40) {
        double discountPrice = (PRICE - (PRICE * 0.20)) * getAmount();
        return discountPrice;
    }
    else {
        return PRICE * getAmount();
    }
}

public String toString() {
    return "Cookie Order: " + super.toString() + "      |" + this.getTopping() + "      | " + this.getShape() + "      | $" + this.calculatePrice();
}

}
