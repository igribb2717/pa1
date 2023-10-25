package product;


/**
 * A class that that uses inheritance from the Teethbrush class to create an
 * ElectricTeethbrush object.
 * 
 * @author Ian Gribb, James Madison University
 * @version 1.0 - 10/21/2023 This work complies with the JMU Honor Code.
 * 
 * References and Acknowledgments: I received no outside help with this
 * programming assignment.
 */
public class ElectricTeethbrush extends Teethbrush {

    private static final double BASE_BODY_COST = 5.00;
    private static final double RECHARGEABLE_UPCHARGE = 20.00;
    private static final double ULTRASONIC_UPCHARGE = 10.00;
    private static final int NUMBER_OF_HEADS = 5;
    private boolean rechargeable;
    private boolean ultrasonic;

    /**
     * EelctricTeethbrush constructor that invokes the Teethbrush constructor.
     * 
     * @param model Inherited from Teethbrush constructor which determines the
     * model of the Teethbrush
     * @param hardness Inherited from the Teethbrush which determines the
     * hardness of the bristles
     * @param polished Inherited from the Teethbrush which determines if the
     * bristles are polished or not
     * @param rechargeable Determine if the ElectricTeethbrush is rechargeable
     * @param ultrasonic Determine if the ElectricTeethbrush is ultrasonic
     */
    public ElectricTeethbrush(String model, int hardness, boolean polished,
            boolean rechargeable, boolean ultrasonic) {
        super(model, hardness, polished);
        this.rechargeable = rechargeable;
        this.ultrasonic = ultrasonic;
    }

    /**
     * Determine the ultimate cost of the ElectricTeethbrush object using the
     * inherited cost() method from Teethbrush.
     * @return The ultimate cost of the ElectricTeethbrush object 
     */
    public double cost() {
        double baseCost = (NUMBER_OF_HEADS * super.cost()) + BASE_BODY_COST;
        if (rechargeable) {
            baseCost += RECHARGEABLE_UPCHARGE;

        } 
        if (ultrasonic) {
            baseCost += ULTRASONIC_UPCHARGE;
        }
        return baseCost;

    }

    public boolean isRechargeable() {
        return rechargeable;

    }

    public boolean isUltrasonic() {
        return ultrasonic;

    }
   
    

}
