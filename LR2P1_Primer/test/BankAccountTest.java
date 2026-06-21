import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeAll
    static void initAll() {
        System.out.println("Starting BankAccount tests...");
    }

    @BeforeEach
    void setUp() {
        account = new BankAccount("Ivan Petrov", 1000.0);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test finished.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("All BankAccount tests completed.");
    }

    @Test
    @DisplayName("Deposit increases balance")
    void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Successful withdrawal decreases balance")
    void testWithdrawSuccess() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Withdrawal fails when insufficient funds")
    void testWithdrawFail() {
        assertFalse(account.withdraw(1500.0));
        assertEquals(1000.0, account.getBalance(), 0.001);
    }
}