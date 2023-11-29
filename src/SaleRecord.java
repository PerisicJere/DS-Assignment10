/**
 *
 * @author Jere Perisic
 * @version November 22, 2023
 */
class SaleRecord {
    String date;
    String salesperson;
    String customerName;
    String carMake;
    String carModel;
    int carYear;
    double salePrice;
    double commissionRate;
    double commissionEarned;


    /**
     * SaleRecord constructor
     *
     * @param date
     * @param salesperson
     * @param customerName
     * @param carMake
     * @param carModel
     * @param carYear
     * @param salePrice
     * @param commissionRate
     * @param commissionEarned
     */
    public SaleRecord(String date, String salesperson, String customerName, String carMake, String carModel, int carYear, double salePrice, double commissionRate, double commissionEarned) {
        this.date = date;
        this.salesperson = salesperson;
        this.customerName = customerName;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carYear = carYear;
        this.salePrice = salePrice;
        this.commissionRate = commissionRate;
        this.commissionEarned = commissionEarned;
    }

    public String getCarMake() {
        return this.carMake;
    }

    /**
     * retrieve name of customer, but I have noticed that some names hav MD and PHD so it's ignored, and second to last name is retrieved
     *
     * @return last name of customer
     */

    public String getCustomerLastName() {
        String[] nameParts = customerName.split(" ");

        if (nameParts.length >= 2) {
            String lastPart = nameParts[nameParts.length - 1].toUpperCase();
            if (lastPart.equals("PHD") || lastPart.equals("MD")) {
                return nameParts[nameParts.length - 2];
            } else {
                return nameParts[nameParts.length - 1];
            }
        } else {
            return customerName;
        }
    }

    /**
     * retrieve name of sales person, but I have noticed that some names hav MD and PHD so it's ignored, and second to last name is retrieved
     *
     * @return last name of salesperson
     */
    public String getSalespersonLastName(){
        String[] nameParts = salesperson.split(" ");
        if (nameParts.length >= 2) {
            String lastPart = nameParts[nameParts.length - 1].toUpperCase();
            if (lastPart.equals("PHD") || lastPart.equals("MD")) {
                return nameParts[nameParts.length - 2];
            } else {
                return nameParts[nameParts.length - 1];
            }
        } else {
            return salesperson;
        }
    }

        @Override
        public String toString() {
            return "SaleRecord {" + " " +
                    date + ", " +'\'' +
                    salesperson + ", " +'\'' +
                    customerName + ", " +'\'' +
                    carMake + ", " +'\'' +
                    carModel + ", " +'\'' +
                    carYear +", " +
                    salePrice +", " +
                    commissionRate +", " +
                    commissionEarned +" " +
                    '}';

    }

}