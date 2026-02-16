/**
 * Savings Account System
 * Represents a basic savings account with deposit, withdrawal, and balance inquiry operations
 * 
 * @author TechSoft S.A.
 * @version 1.0
 */
public class SavingsAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
    
    /**
     * Constructor to create a new savings account
     * @param accountNumber Unique account identifier
     * @param ownerName Name of the account owner
     */
    public SavingsAccount(String accountNumber, String ownerName) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de cuenta no puede estar vacío");
        }
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del titular no puede estar vacío");
        }
        
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }
    
    /**
     * Deposit money into the account
     * @param amount Amount to deposit
     * @return true if operation was successful
     * @throws IllegalArgumentException if amount is invalid
     */
    public boolean deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto del depósito debe ser mayor a cero");
        }
        
        this.balance += amount;
        System.out.println("✓ Depósito exitoso: $" + String.format("%.2f", amount));
        System.out.println("  Nuevo saldo: $" + String.format("%.2f", this.balance));
        return true;
    }
    
    /**
     * Withdraw money from the account
     * @param amount Amount to withdraw
     * @return true if operation was successful
     * @throws IllegalArgumentException if amount is invalid
     * @throws InsufficientFundsException if balance is insufficient
     */
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto del retiro debe ser mayor a cero");
        }
        
        if (amount > this.balance) {
            throw new InsufficientFundsException(
                "Fondos insuficientes. Saldo actual: $" + String.format("%.2f", this.balance) +
                ", Solicitado: $" + String.format("%.2f", amount)
            );
        }
        
        this.balance -= amount;
        System.out.println("✓ Retiro exitoso: $" + String.format("%.2f", amount));
        System.out.println("  Nuevo saldo: $" + String.format("%.2f", this.balance));
        return true;
    }
    
    /**
     * Get current account balance
     * @return Current balance
     */
    public double getBalance() {
        return this.balance;
    }
    
    /**
     * Get account number
     * @return Account number
     */
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    /**
     * Get owner name
     * @return Owner name
     */
    public String getOwnerName() {
        return this.ownerName;
    }
    
    /**
     * Display account information
     */
    public void displayAccountInfo() {
        System.out.println("\n════════════════════════════════════");
        System.out.println("      INFORMACIÓN DE LA CUENTA      ");
        System.out.println("════════════════════════════════════");
        System.out.println("Número de Cuenta: " + this.accountNumber);
        System.out.println("Titular: " + this.ownerName);
        System.out.println("Saldo Actual: $" + String.format("%.2f", this.balance));
        System.out.println("════════════════════════════════════\n");
    }
}
