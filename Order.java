public class Order{
    //this class holds all of the customers orders 
private String orderID;
private String occasion;

//constructor
public Order() {
}

//specific constructor
public Order(String orderID, String occasion) {
    setOrderID(orderID);
    setOccasion(occasion);
}

//accessor
public String getOrderID() {
    return this.orderID;
}
public String getOccasion() {
    return this.occasion;
}

//mutator
/* Makes sure all customer inputs are not blank. */
public void setOrderID(String orderID) {
    if(orderID.isEmpty() || orderID.isEmpty()) {
        throw new IllegalArgumentException("Error! Order ID cannot be blank");
    }
    if(orderID.length() > 5 && orderID.length() > 5) {
        throw new IllegalArgumentException("Error! Order ID cannot be less or more than 5 characters long");
    }
    this.orderID = orderID;
}
public void setOccasion(String occasion) {
    if (occasion.isEmpty() || occasion.equals("")) {
        throw new IllegalArgumentException("Error! Occasion cannot be blank");
    }
    if(!occasion.equalsIgnoreCase("Birthday")&& !occasion.equalsIgnoreCase("Baby Shower")&& !occasion.equalsIgnoreCase("Wedding") && !occasion.equalsIgnoreCase("None")){
            throw new IllegalArgumentException("The occasion must be birthday, baby shower, wedding, or none");
        }
        this.occasion = occasion;
}


public String toString() {
    return this.getOrderID() + "     | " +  this.getOccasion();
}


}
