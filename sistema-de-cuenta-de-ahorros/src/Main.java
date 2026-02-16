import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Main application class for Savings Account System
 * Provides a console-based user interface 
 * Integrantes: Juan Andres Toro, Daniel Cubillan y Daniel Cano
 * @author TechSoft S.A.
 * @version 1.0
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SavingsAccount account = null;
    
    public static void main(String[] args) {
        displayWelcomeMessage();
        createAccount();
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            int option = readMenuOption();
            
            switch (option) {
                case 1:
                    performDeposit();
                    break;
                case 2:
                    performWithdrawal();
                    break;
                case 3:
                    displayBalance();
                    break;
                case 4:
                    account.displayAccountInfo();
                    break;
                case 5:
                    running = false;
                    displayGoodbyeMessage();
                    break;
                default:
                    System.out.println("\n✗ Opción inválida. Por favor intente de nuevo.\n");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Display welcome message
     */
    private static void displayWelcomeMessage() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN DE CUENTA DE     ║");
        System.out.println("║              AHORROS                   ║");
        System.out.println("║          TechSoft S.A. - 2025          ║");
        System.out.println("╚════════════════════════════════════════╝\n");
    }
    
    /**
     * Create new savings account
     */
    private static void createAccount() {
        System.out.println("Vamos a crear tu cuenta de ahorros\n");
        
        System.out.print("Ingrese el número de cuenta: ");
        String accountNumber = scanner.nextLine().trim();
        
        System.out.print("Ingrese el nombre del titular: ");
        String ownerName = scanner.nextLine().trim();
        
        try {
            account = new SavingsAccount(accountNumber, ownerName);
            System.out.println("\n✓ ¡Cuenta creada exitosamente!\n");
        } catch (IllegalArgumentException e) {
            System.out.println("\n✗ Error: " + e.getMessage());
            System.out.println("Por favor reinicie la aplicación.\n");
            System.exit(1);
        }
    }
    
    /**
     * Display main menu
     */
    private static void displayMenu() {
        System.out.println("┌────────────────────────────────────┐");
        System.out.println("│           MENÚ PRINCIPAL           │");
        System.out.println("├────────────────────────────────────┤");
        System.out.println("│ 1. Depositar dinero                │");
        System.out.println("│ 2. Retirar dinero                  │");
        System.out.println("│ 3. Consultar saldo                 │");
        System.out.println("│ 4. Ver información de cuenta       │");
        System.out.println("│ 5. Salir                           │");
        System.out.println("└────────────────────────────────────┘");
        System.out.print("\nSeleccione una opción: ");
    }
    
    /**
     * Read menu option from user
     * @return Selected option number
     */
    private static int readMenuOption() {
        try {
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return option;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }
    
    /**
     * Perform deposit operation
     */
    private static void performDeposit() {
        System.out.println("\n─── DEPOSITAR DINERO ───");
        System.out.print("Ingrese el monto a depositar: $");
        
        try {
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            
            account.deposit(amount);
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            System.out.println("✗ Error: Monto inválido. Por favor ingrese un número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error inesperado: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Perform withdrawal operation
     */
    private static void performWithdrawal() {
        System.out.println("\n─── RETIRAR DINERO ───");
        System.out.print("Ingrese el monto a retirar: $");
        
        try {
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            
            account.withdraw(amount);
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            System.out.println("✗ Error: Monto inválido. Por favor ingrese un número válido.");
        } catch (InsufficientFundsException e) {
            System.out.println("✗ Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error inesperado: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Display current balance
     */
    private static void displayBalance() {
        System.out.println("\n─── SALDO DE LA CUENTA ───");
        System.out.println("Saldo actual: $" + String.format("%.2f", account.getBalance()));
        System.out.println();
    }
    
    /**
     * Display goodbye message
     */
    private static void displayGoodbyeMessage() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   ¡Gracias por usar nuestro sistema!  ║");
        System.out.println("║          ¡Hasta pronto!                ║");
        System.out.println("╚════════════════════════════════════════╝\n");
    }
}
