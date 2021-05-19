import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class timeTest {

    private time time1,
                 time2;
    private long counter;

    @BeforeEach
    void set_up(){
        this.time1 = new time(23, 59);
        this.time2 = new time(14, 30);
    }

    @AfterEach
    void tear_down(){
        this.time1 = null;
        this.time2 = null;
    }

    @Test
    @DisplayName("here we test, if calculate_time adds 1 time instances correctly to another one or subtracts 1 time instance from the other")
    void test_result_of_calculate_time() {
        try{
            counter = 0;
            assertEquals((time1.calculate_time(time2, "-")).toString(), new time(9, 29).toString(), "oops, something went wrong no."  + ++counter);
            assertEquals((time1.calculate_time(time2, "+")).toString(), new time(37, 89).toString(), "oops something went wrong no."  + ++counter);
        } catch (final Exception E){
            E.printStackTrace();
        }
    }

    @Test
    @DisplayName("here we test if we get an exception if we enter an illegal operator")
    void test_if_exception_thrown_in_calculate_time(){
        try{
            counter = 0;
            assertThrows(java.lang.Exception.class, () -> time2.calculate_time(time1, "/"), "oops something went wrong no." + ++counter);
        } catch (final Exception E){
            E.printStackTrace();
        }
    }


}