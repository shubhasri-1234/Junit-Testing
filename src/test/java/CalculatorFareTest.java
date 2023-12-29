import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.CabInvoiceGenerator;
import org.example.InvoiceSummary;
import org.example.Ride;
import org.junit.jupiter.api.Test;

public class CalculatorFareTest {

    @Test
    public void testCalculateFare(){
            CabInvoiceGenerator cabInvoiceGEnerator = new CabInvoiceGenerator();
            double fare = cabInvoiceGEnerator.calculateNormalFare(5,15);
            assertEquals(65.0, fare);  //5km * 10 rs + 15 min * 1 rs/min
    }

    @Test
    public void testMinimumFare(){
            CabInvoiceGenerator cabInvoiceGEnerator = new CabInvoiceGenerator();
            double fare = cabInvoiceGEnerator.calculatePremiumFare(0.2,2);
            assertEquals(20.0, fare);  //2km * 10 rs + 5 min * 1 rs/min
    }
    

    @Test
    public void testCalculateInvoice() {
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = {
            new Ride(2.0, 5, "NORMAL"),
            new Ride(1.0, 1, "PREMIUM")
        };

        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);

        assertEquals(2, invoiceSummary.getTotalRides());
        assertEquals(31.0, invoiceSummary.getTotalFare());
        assertEquals(15.5, invoiceSummary.getAverageFare());
    }
}
