package CodeExamples;

import org.junit.jupiter.api.Test;
import org.passau.CodeExamples.OriginalCode.classA;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class classATest {
    @Test
    public void testMethodWithZero() {
        classA classAinstance = new classA();
        int result = classAinstance.methodA(0);
        assertEquals(10, result);
    }

    @Test
    public void testMethodWithOne() {
        classA classAinstance = new classA();
        int result = classAinstance.methodA(1);
        assertEquals(99, result);
    }
}
