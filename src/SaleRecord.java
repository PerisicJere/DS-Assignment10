/**
 *
 * @author Jere Perisic
 * @version November 22, 2023
 */
class SaleRecord {
    String date;
    String carMake;


    /**
     * SaleRecord constructor
     *
     * @param date
     * @param carMake
     */
    public SaleRecord(String date, String carMake) {
        this.date = date;
        this.carMake = carMake;

    }

    public String getCarMake() {
        return this.carMake;
    }

    public String getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return date ;
    }

}