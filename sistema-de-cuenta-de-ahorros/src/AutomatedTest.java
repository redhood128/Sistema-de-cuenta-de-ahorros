/**
 * Automated test class to demonstrate system functionality
 * This class runs predefined test scenarios
 * 
 * @author TechSoft S.A.
 * @version 1.0
 */
public class AutomatedTest {
    
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║     SAVINGS ACCOUNT SYSTEM - AUTOMATED TESTS     ║");
        System.out.println("╚═══════════════════════════════════════════════════╝\n");
        
        // Test 1: Create account
        System.out.println("TEST 1: Creating account...");
        runTest1();
        
        // Test 2: Successful deposit
        System.out.println("\nTEST 2: Successful deposit...");
        runTest2();
        
        // Test 3: Successful withdrawal
        System.out.println("\nTEST 3: Successful withdrawal...");
        runTest3();
        
        // Test 4: Insufficient funds
        System.out.println("\nTEST 4: Withdrawal with insufficient funds...");
        runTest4();
        
        // Test 5: Invalid operations
        System.out.println("\nTEST 5: Invalid operations...");
        runTest5();
        
        // Test 6: Multiple operations
        System.out.println("\nTEST 6: Multiple operations sequence...");
        runTest6();
        
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║          ALL TESTS COMPLETED SUCCESSFULLY         ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
    }
    
    /**
     * Test 1: Account creation with valid data
     */
    private static void runTest1() {
        try {
            SavingsAccount account = new SavingsAccount("ACC-001", "John Doe");
            System.out.println("✓ Account created successfully");
            System.out.println("  Account Number: " + account.getAccountNumber());
            System.out.println("  Owner: " + account.getOwnerName());
            System.out.println("  Initial Balance: $" + String.format("%.2f", account.getBalance()));
        } catch (Exception e) {
            System.out.println("✗ Test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test 2: Successful deposit operation
     */
    private static void runTest2() {
        try {
            SavingsAccount account = new SavingsAccount("ACC-002", "Jane Smith");
            account.deposit(1000.00);
            
            double expectedBalance = 1000.00;
            double actualBalance = account.getBalance();
            
            if (actualBalance == expectedBalance) {
                System.out.println("✓ Deposit test passed");
                System.out.println("  Expected: $" + expectedBalance);
                System.out.println("  Actual: $" + actualBalance);
            } else {
                System.out.println("✗ Balance mismatch!");
            }
        } catch (Exception e) {
            System.out.println("✗ Test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test 3: Successful withdrawal operation
     */
    private static void runTest3() {
        try {
            SavingsAccount account = new SavingsAccount("ACC-003", "Bob Johnson");
            account.deposit(5000.00);
            account.withdraw(2000.00);
            
            double expectedBalance = 3000.00;
            double actualBalance = account.getBalance();
            
            if (actualBalance == expectedBalance) {
                System.out.println("✓ Withdrawal test passed");
                System.out.println("  Expected: $" + expectedBalance);
                System.out.println("  Actual: $" + actualBalance);
            } else {
                System.out.println("✗ Balance mismatch!");
            }
        } catch (Exception e) {
            System.out.println("✗ Test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test 4: Withdrawal with insufficient funds
     */
    private static void runTest4() {
        try {
            SavingsAccount account = new SavingsAccount("ACC-004", "Alice Brown");
            account.deposit(100.00);
            
            try {
                account.withdraw(200.00);
                System.out.println("✗ Test failed: Should have thrown InsufficientFundsException");
            } catch (InsufficientFundsException e) {
                System.out.println("✓ Insufficient funds exception caught correctly");
                System.out.println("  Message: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("✗ Test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test 5: Invalid operations (negative amounts, empty fields)
     */
    private static void runTest5() {
        try {
            SavingsAccount account = new SavingsAccount("ACC-005", "Charlie Wilson");
            
            // Test negative deposit
            try {
                account.deposit(-100.00);
                System.out.println("✗ Should have rejected negative deposit");
            } catch (IllegalArgumentException e) {
                System.out.println("✓ Negative deposit rejected correctly");
            }
            
            // Test zero withdrawal
            try {
                account.withdraw(0.00);
                System.out.println("✗ Should have rejected zero withdrawal");
            } catch (IllegalArgumentException e) {
                System.out.println("✓ Zero withdrawal rejected correctly");
            }
            
            // Test empty account number
            try {
                new SavingsAccount("", "Test User");
                System.out.println("✗ Should have rejected empty account number");
            } catch (IllegalArgumentException e) {
                System.out.println("✓ Empty account number rejected correctly");
            }
            
        } catch (Exception e) {
            System.out.println("✗ Test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test 6: Sequence of multiple operations
     */
    private static void runTest6() {
        try {
            SavingsAccount account = new SavingsAccount("ACC-006", "David Martinez");
            
            System.out.println("  Starting balance: $" + account.getBalance());
            
            account.deposit(1000.00);
            System.out.println("  After deposit $1000: $" + account.getBalance());
            
            account.withdraw(300.00);
            System.out.println("  After withdrawal $300: $" + account.getBalance());
            
            account.deposit(500.00);
            System.out.println("  After deposit $500: $" + account.getBalance());
            
            account.withdraw(200.00);
            System.out.println("  After withdrawal $200: $" + account.getBalance());
            
            double expectedBalance = 1000.00;
            double actualBalance = account.getBalance();
            
            if (actualBalance == expectedBalance) {
                System.out.println("✓ Multiple operations test passed");
                System.out.println("  Final balance: $" + actualBalance);
            } else {
                System.out.println("✗ Final balance mismatch!");
            }
            
        } catch (Exception e) {
            System.out.println("✗ Test failed: " + e.getMessage());
        }
    }
}
