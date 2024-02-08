// Delta College - CST 283 - Homework 1
// Name: Aaron Pelto
// Winter 2024

// This program calculates the charge for electricity usage based on the month and energy usage.
// Months 12, 1 and 2 are considered winter months.  All other months are considered summer months.
// Winter rates are $0.223 per kilowatt-hour for the first 800 kilowatt-hours and $0.315 per kilowatt-hour for over 800 kilowatt-hours.
// Summer rates are $0.184 per kilowatt-hour for the first 700 kilowatt-hours and $0.293 per kilowatt-hour for over 700 kilowatt-hours.


public class ElectricBill {
    final static double WINTER_RATE = 0.223;
    final static double WINTER_RATE_OVER = 0.315;
    final static double SUMMER_RATE = 0.184;
    final static double SUMMER_RATE_OVER = 0.293;
    final static int WINTER_OVER_RATE = 800;
    final static int SUMMER_OVER_RATE = 700;

    public static void main(String[] args) {

        System.out.println("Your Electrical Bill is $" + calcElecBill(12, 750));
        System.out.println("Your Electrical Bill is $" + calcElecBill(3, 750));
        System.out.println("Your Electrical Bill is $" + calcElecBill(2, 932));
        System.out.println("Your Electrical Bill is $" + calcElecBill(1, 777));
        System.out.println("Your Electrical Bill is $" + calcElecBill(8, 456));
    }

    // The method calcElecBill takes two parameters, month and energy, and returns the charge for electricity.
    public static double calcElecBill(int month, int energy) {
        double bill;
        if (month == 1 || month == 2 || month == 3) {
            if (energy <= 800) {
                bill = WINTER_RATE * energy;
            } else {
                bill = WINTER_RATE * WINTER_OVER_RATE + ((energy - WINTER_OVER_RATE) * WINTER_RATE_OVER);
            }
        } else {
            if (energy <= 700) {
                bill = SUMMER_RATE * energy;
            } else {
                bill = SUMMER_RATE * SUMMER_OVER_RATE + ((energy - SUMMER_OVER_RATE) * SUMMER_RATE_OVER);
            }
        }
        return Double.parseDouble(String.format("%.2f", bill));
    }

}

