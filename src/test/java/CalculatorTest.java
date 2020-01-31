import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc = new Calculator();

    @Test
    void test() throws Exception{
        assertEquals(0, calc.add(""));
        assertEquals(1, calc.add("1"));
        assertEquals(2, calc.add("1,1"));
        assertEquals(10, calc.add("1,2,3,4"));
        assertEquals(10, calc.add("1,2,3,4"));
        assertEquals(6, calc.add("1\n2,3"));
        assertEquals(3, calc.add("//;\n1;2"));
        assertEquals(3, calc.add("//4\n142"));
        assertEquals(3, calc.add("//;\n1000;1;2"));
        assertEquals(6, calc.add("//***\n1***2***3"));
        assertEquals(6, calc.add("//[:D][%]\n1:D2%3"));
        assertEquals(6, calc.add("//[***][%%%]\n1***2%%%3"));
        assertEquals(0, calc.add("//[(-_-')][%]\n1(-_-')2%3"));
        assertEquals(7, calc.add("//[abc][777][:(]\n1abc27773:(1"));
    }
    @Test
    void negetives() {
        Exception exception = assertThrows(Exception.class, () -> {
            calc.add("-1,-2,3,4"); });
        String Message = exception.getMessage();
        assertFalse(Message.contains("Error : Negatives not allowed"));
    }
    @Test
    void delimVal() throws Exception {
        calc.add("//;\n1000;1;2;");
    }
    @Test
    void delimVal1() {
        Exception exception = assertThrows(Exception.class, () -> {
            calc.add("   //;\n1000,1;2"); });
        String Message = exception.getMessage();
        assertFalse(Message.contains("Invalid Input"));
    }
    @Test
    void delimVal2() {
        Exception exception = assertThrows(Exception.class, () -> {
            calc.add("1,2,3//;\n1000,1;2"); });
        String Message = exception.getMessage();
        assertFalse(Message.contains("the value is invalid"));
    }
}