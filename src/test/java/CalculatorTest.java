import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddingTwoNumbers() {

        Calculator calculator = new Calculator();
        assertEquals(6, calculator.add(3,3));
    }
}
