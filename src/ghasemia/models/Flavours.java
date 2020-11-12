package ghasemia.models;

/**
 * Assignment 4
 *
 * Program : Developing a class that models a ordering pet food
 *
 * This class name is Flavours, and it contains the constant variables of the
 * program.
 *
 * @author Amirmahdi Ghasemi, 2020
 *
 */
public enum Flavours {
    /*
     * Constants of Flavours enum class
     */
    DUCK(2.99, "Duck"),
    HALIBUT(3.99, "Halibut"),
    BISON(5.99, "Bison");
    /**
     * This is a private double, and its name is price.
     */
    private double price;
    /**
     * This is a private String, and its name is name.
     */
    private String name;

    /**
     * This is a constructor of Flavours class, and it contains 2 parameters
     * that you can find them here.
     *
     * @param price
     * @param name
     */
    private Flavours(double price, String name) {
        this.price = price;
        this.name = name;
    }

    /**
     * This method gets the price, and it is constant.
     *
     * @return this price
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method gets the name, and it is constant.
     *
     * @return this name
     */
    public String getName() {
        return name;
    }

}
