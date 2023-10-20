package CodeExamples;
import org.junit.jupiter.api.Test;
import org.passau.CodeExamples.SourceCodeSimple;

public class SourceCodeSimpleTest {

    @Test
    public void testMethodWithAEqualsOne() {
        SourceCodeSimple sourceCodeSimple = new SourceCodeSimple();  // Replace 'YourClass' with the name of the actual class that contains the 'method'
        sourceCodeSimple.method(1);
        //assertEquals("end of method\n", outContent.toString());
    }

    @Test
    public void testMethodWithANotEqualsOne() {
        SourceCodeSimple sourceCodeSimple = new SourceCodeSimple();  // Replace 'YourClass' with the name of the actual class that contains the 'method'
        sourceCodeSimple.method(2);
        //assertEquals("end of method\n", outContent.toString());
    }
}
