import org.example.PopulationSearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PopulationSearchTest {
    PopulationSearch obj=null;
    @BeforeEach
    public void setUp(){
        obj = new PopulationSearch();
    }
    @Test
    public void findPopulation(){
        String city = "Mumbai";
        int exceptedPopulation = 20000;
        int count = obj.getPopulation(city);
        assertEquals(exceptedPopulation,count);
    }

    @Test
    public void findPopulationEmptyInput(){
        String city = "";
        // int exceptedPopulation = 0;
        // assertEquals(exceptedPopulation,count);
        Throwable exception = assertThrows(NullPointerException.class, ()->{
            obj.getPopulation(city);
        });

        assertEquals("Input shouldn't be empty", exception.getMessage());
    }

     @Test
    public void findPopulationInvalidInput(){
        String city = "Delhi";
        // assertEquals(exceptedPopulation,count);
        Throwable exception = assertThrows(NullPointerException.class, ()->{
            obj.getPopulation(city);
        });

        assertEquals("Invalid Input or City not present", exception.getMessage());
    }
}
