import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Logger {
    public void log(String message) {
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = timestamp.format(formatter);
        
        System.out.println("[" + formattedTimestamp + "] " + message);
        // Here, you might log the message to a file or a more sophisticated logging system
    }
    
    // Other logging methods or configurations can be added here
}
