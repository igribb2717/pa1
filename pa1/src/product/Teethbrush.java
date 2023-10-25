package product;

/**
 * A class that represents the teethbrush object.
 * 
 * @author Ian Gribb, James Madison University
 * @version 1.0 - 10/21/2023 This work complies with the JMU Honor Code.
 * 
 * References and Acknowledgments: I received no outside help with this
 * programming assignment.
 */
public class Teethbrush {

    protected static final double BASE_HEAD_COST = 2.00;
    private static final double HARDNESS_UPCHARGE = 0.10;
    private static final double LARGE_ORDER_DISCOUNT = 0.30;
    private static final double POLISHED_UPCHARGE = 0.75;
    private static final double STOCKING_COST = 25.00;
    private static final double UNIT_SHIPPING_COST_OVERSEAS = 0.30;
    private static final double UNIT_SHIPPING_COST_LOCAL = 0.10;
    private static final int LARGE_ORDER = 1000;
    private boolean polished;
    private int hardness;
    private int inventory;
    private String model;

    /**
     * Constructor for teethbrush object.
     * 
     * @param model Identifying that the model is a teethbrush not an electric
     * one
     * @param hardness Identifying the hardness scale of the teethbrush
     * @param polished Identify if the teethbrush is polished or not
     */
    public Teethbrush(String model, int hardness, boolean polished) {
        this.model = model;
        this.hardness = hardness;
        this.polished = polished;

    }

    /**
     * Can be used to increase or decrease the inventory attribute.
     * 
     * @param amount The amount in the order
     * @return True or false depending on if the inventory contains the amount
     */
    public boolean changeInventory(int amount) {
        if ((inventory + amount) < 0) {
            return false;
        }
        inventory += amount;
        return true;

    }

    /**
     * Determine the cost of the teethbrush object ordered.
     * 
     * @return The ultimate cost of the teethbursh ordered
     */
    public double cost() {
        double baseCost = BASE_HEAD_COST;
        if (polished) {
            baseCost += POLISHED_UPCHARGE;
        }
        return baseCost + (HARDNESS_UPCHARGE * hardness);

    }

    /**
     * Retreive the hardness, if it is less then 0 then hardness will be set to
     * 0. If it is greater than 5 then hardness will be set to 5 because the
     * hardness scale only ranges from 0-5.
     * 
     * @return The hardness level
     */
    public int getHardness() {
        if (hardness < 0) {
            this.hardness = 0;
        } else if (hardness > 5) {
            this.hardness = 5;
        }

        return hardness;
    }

    public int getInventory() {
        return inventory;
    }

    public String getModel() {
        return model;

    }

    public boolean isPolished()   {
        return polished;
    }

    /**
     * Check the hardness level and if it exceeds or is less than the intial
     * range then it is set back to 0.
     * 
     * @param hardness The initial hardness of the teethbrush object
     */
    public void setHardness(int hardness) {
        this.hardness = hardness;

    }

    /**
     * Determine the shipping cost of the order.
     * 
     * @param orderSize The size of the order
     * @param overseas If the order is going to be shipped overseas or not
     * @return The ultimate cost of shipping for the order
     */
    public double shippingCost(int orderSize, boolean overseas) {
        double unitShippingCost = overseas ? UNIT_SHIPPING_COST_OVERSEAS
                : UNIT_SHIPPING_COST_LOCAL;

        if (orderSize > LARGE_ORDER) {
            unitShippingCost -= (unitShippingCost * LARGE_ORDER_DISCOUNT);
        }
        double cost = unitShippingCost * orderSize;

        if (orderSize > inventory) {
            cost += STOCKING_COST;
        }

        return cost;

    }
}
