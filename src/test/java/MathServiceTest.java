
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.gb.MathService;
import ru.gb.NotFoundAnswerException;
import ru.gb.Pair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathServiceTest {
    private MathService mathService;

    @BeforeEach
    public void setUp(){
        mathService = new MathService();
    }

    @Test
    public void getDTest(){
        assertEquals(-3, mathService.getD(1, 1, 1));
        assertEquals(0, mathService.getD(1, -2, 1));
        assertEquals(1, mathService.getD(1, -3, 2));
    }

    @Test
    public void noRootsExceptionTest(){
        NotFoundAnswerException exception = assertThrows(NotFoundAnswerException.class, () -> {
            mathService.getAnswer(1, 1, 1);});

        String expectedMessage = "Корни не могут быть найдены";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @CsvSource({"1, -2, 1, 1, 1"})
    public void oneRootTest(int a, int b, int c, double x1, double x2) throws NotFoundAnswerException {
        assertEquals("Answer{first="+x1+", second="+x2+"}", mathService.getAnswer(a,b,c).toString());
    }

    @ParameterizedTest
    @CsvSource({"1, -3, 2, 1"})
    public void twoRootTest(int a, int b, int c, int d) throws NotFoundAnswerException {
        double expectedX1 = (-b + Math.sqrt(d)) / (2 + a);
        double expectedX2 = (-b - Math.sqrt(d)) / (2 + a);

        assertEquals(new Pair(expectedX1, expectedX2).toString(), mathService.getAnswer(a,b,c).toString());
    }


}
