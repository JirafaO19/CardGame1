import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateArithmeticExpParanthesisTest {

    private static int ind=0;
    public static Stack<String> ops = new Stack<>();
    public static Stack<Double> vals = new Stack<>();


    @Test
    void processExpression() {
        String STRING = "4*(10-12-8)";

        assertEquals(24,EvaluateArithmeticExpParanthesis.processExpression(STRING));
        }


    @Test
    @DisplayName("Empy stack, throws an exception")
    void processExpressionException() {
        assertThrows(EmptyStackException.class,
                ()->{
                    if(ops.isEmpty())
                    {  vals.pop();}
                    else{
                        while(!ops.isEmpty()){
                            String op=ops.pop();
                            if(op.equals("+")) {vals.push(vals.pop()+vals.pop());}
                            else if (op.equals("*")) {vals.push(vals.pop()*vals.pop());}
                            else if (op.equals("-")) {vals.push(-1*vals.pop()+vals.pop());}
                            else if (op.equals("/")) {vals.push(1/vals.pop()*vals.pop());}
                        }

                }

    } ); }

    @Test
    void stringOutput() {
    }

    @Test
    void searchNumber() {
        String string="7-((2-13)-6)";
        boolean result=EvaluateArithmeticExpParanthesis.SearchNumber("7",string);
        assertEquals(true,result);

       // String string="7-((2-13)-6)";
        boolean result1=EvaluateArithmeticExpParanthesis.SearchNumber("8",string);

        assertFalse(false, String.valueOf(result1));
    }
}