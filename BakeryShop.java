public class BakeryShop {
/* Summary : Orders are made by the customers and can be removed as well. A customer can 
have multiple orders of cakes, cookies, and cupcakes but they cannot exceed the maximum amount.
It will also have an abstract method to calculate the final sales price depending on if the 
customer gets the discount or not.
*/

//instance variables
private Order order;
private CustomerInfo customerInfo;
private Dessert dessert;
private static int bakeryCount;

//specific constructor
/* This is the constructor. BakeryCount is in here and increases each time an object or order is created.*/
public BakeryShop(Order order, CustomerInfo customerInfo, Dessert dessert) {
    setOrder(order);
    setCustomerInfo(customerInfo);
    setDessert(dessert);
    bakeryCount++;
}

//mutator
/* These make sure that each of the prompts has something in it (each class). */
public void setOrder(Order order) {
    if (order == null && order.equals("")) {
        throw new IllegalArgumentException("Order ID must be provided");
    }
    this.order = order;
}
public void setCustomerInfo(CustomerInfo customerInfo) {
    if (customerInfo == null && customerInfo.equals("")) { 
        throw new IllegalArgumentException("Customer name must be provided");
    }
    this.customerInfo = customerInfo;
}
public void setDessert(Dessert dessert) {
    if (dessert == null && dessert.equals("")) {
        throw new IllegalArgumentException("Dessert type must be provided");
    }
    this.dessert = dessert;
}

//accessors
public Order getOrder() {
    return this.order;
}

public CustomerInfo getCustomerInfo() {
    return this.customerInfo;
}
public Dessert getDessert() {
    return this.dessert;
}
public static int getCount() { //Gets the count of how many orders have been created so far.
    return bakeryCount;
}

//Special Purpose Method
public static void decreaseCount() { //Decreases count of orders when an order is removed.
    bakeryCount--;
}
public String toString() { //toString() from each class.
    return this.getOrder().toString() + "      | " + this.getCustomerInfo().toString() + "      | " + this.getDessert().toString();
    
}


}    
