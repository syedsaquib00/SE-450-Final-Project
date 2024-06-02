import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest {

    @Test
    public void testLog() {
        // Redirect console output to capture printed messages
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));

        // Create a Logger instance
        Logger logger = new Logger();
        String message = "Test log message";

        // Log a message
        logger.log(message);

        // Restore original console output
        System.setOut(originalOut);

        // Get the printed message
        String printedMessage = outputStreamCaptor.toString().trim();

        // Check if the message was logged in the expected format
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String expectedTimestamp = timestamp.format(formatter);
        String expectedOutput = "[" + expectedTimestamp + "] " + message;
        
        assertEquals(expectedOutput, printedMessage);
    }

    // Additional tests for other methods or configurations in the Logger class can be added here
}
