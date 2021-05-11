package movierental.tests;

import movierental.Customer;
import movierental.Movie;
import movierental.Rental;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private static Customer customer;
    private static Movie m1 ;
    private static Movie m2;
    private static Rental r1;
    private static Rental r2;

    @BeforeAll
    public static void initialize() {
        customer = new Customer ("joe");
        m1 = new Movie("movie1", 1);
        m2 = new Movie("movie2", 2);
        r1 = new Rental(m1, 10);
        r2 = new Rental(m2, 5);
        customer.addRental(r1);
        customer.addRental(r2);
    }

    @Test
    public void testOutcome(){
        Assertions.assertEquals("Rental Record for joe\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points", customer.statement());;
    }
}