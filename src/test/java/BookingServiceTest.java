import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.gb.BookingService;
import ru.gb.CantBookException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


public class BookingServiceTest {
    private static BookingService bookingService;
    private static LocalDateTime from;
    private static LocalDateTime to;
    private static String userId;

    private static final Logger logger
            = LoggerFactory.getLogger(BookingServiceTest.class);

    @BeforeAll
    static void setUp(){
        from = LocalDateTime.of(2024, 1,20, 14, 0);
        to = LocalDateTime.of(2024, 1,30, 14, 0);
        userId = "222";
    }

    @Test
    public void checkTimeInBDTest(){
        logger.info("Тест checkTimeInBDTest запущен");
        bookingService = mock(BookingService.class);

        logger.debug("Формирование мока для checkTimeInBD(from, to)");
        when(bookingService.checkTimeInBD(from, to)).thenReturn(true);

        assertTrue(bookingService.checkTimeInBD(from, to));
        verify(bookingService).checkTimeInBD(from, to);

    }

    @Test
    public void createBookTest(){
        logger.info("Тест createBookTest запущен");
        bookingService = mock(BookingService.class);

        logger.debug("Формирование мока для createBook(userId, from, to)");
        when(bookingService.createBook(userId, from, to)).thenReturn(true);

        assertTrue(bookingService.createBook(userId, from, to));
        verify(bookingService).createBook(userId, from, to);
    }

    @Test
    public void bookPositiveTest() throws CantBookException {
        logger.info("Тест bookPositiveTest запущен");
        bookingService = spy(new BookingService());

        logger.debug("Формирование spy для checkTimeInBD(from, to)");
        when(bookingService.checkTimeInBD(from, to)).thenReturn(true);
        logger.debug("Формирование spy для createBook(userId, from, to)");
        when(bookingService.createBook(userId, from, to)).thenReturn(true);

        assertTrue(bookingService.book(userId, from, to));
        verify(bookingService).checkTimeInBD(from, to);
        verify(bookingService).createBook(userId, from, to);

    }

    @Test
    public void bookNegativeTest(){
        logger.info("Тест bookNegativeTest запущен");
        bookingService = spy(new BookingService());

        logger.debug("Формирование spy для checkTimeInBD(from, to)");
        when(bookingService.checkTimeInBD(from, to)).thenReturn(false);

        assertThrows(CantBookException.class, () -> bookingService.book(userId, from, to));
        verify(bookingService).checkTimeInBD(from, to);
    }

}
