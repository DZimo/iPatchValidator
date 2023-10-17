package CodeExamples;

import org.junit.jupiter.api.Test;
import org.passau.CodeExamples.OriginalCode.classA;

public class classATest {
    @Test
    public void testMethodWithZero() {
        classA classAinstance = new classA();  // Replace 'YourClass' with the name of the actual class that contains the 'method'
        classAinstance.methodA(0);
        //assertEquals("end of method\n", outContent.toString());
    }

    @Test
    public void testMethodWithOne() {
        classA classAinstance = new classA();  // Replace 'YourClass' with the name of the actual class that contains the 'method'
        classAinstance.methodA(1);
        //assertEquals("end of method\n", outContent.toString());
    }
}
