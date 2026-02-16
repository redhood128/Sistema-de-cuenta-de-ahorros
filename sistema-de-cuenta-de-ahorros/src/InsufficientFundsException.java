/**
 * Custom exception for insufficient funds scenario
 * 
 * @author TechSoft S.A.
 * @version 1.0
 */
public class InsufficientFundsException extends RuntimeException {
    
    /**
     * Constructor with error message
     * @param message Error description
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}
