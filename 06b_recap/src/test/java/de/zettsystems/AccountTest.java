package de.zettsystems;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Wir wollen das Konto über alle Methoden testen
class AccountTest {
    public static final long ACCOUNT_NO = 123L;
    public static final String OWNER = "Tester";
    private Account testee;

    @BeforeAll
    void setUp() {
        testee = new Account(OWNER, ACCOUNT_NO, 0F);
    }

    @Order(1)
    @Test
    @DisplayName("We start with zero.")
    void checkGetter(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

        assertThat(testee.getAccountNumber()).isEqualTo(123L);
        assertThat(testee.getBalance()).isZero();
        assertThat(testee).hasToString("123\tTester\t0,00 €");
    }

    @Order(2)
    @Test
    @DisplayName("We must not allow negative depositions.")
    void checkNotDepositNegativeValue(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

        assertFalse(testee.deposit(-0.5F));
        assertThat(testee.getBalance()).isZero();
    }

    @Order(3)
    @Test
    @DisplayName("We like positive depositions.")
    void checkDepositPositiveValue(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

        assertTrue(testee.deposit(100.0F));
        assertThat(testee.getBalance()).isEqualTo(100.0F);
    }

    @Order(4)
    @Test
    @DisplayName("We do not allow negative withdrawals.")
    void checkNegativeWithdraw(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

        assertFalse(testee.withdraw(-0.1F, 1.0F));
        assertThat(testee.getBalance()).isEqualTo(100.0F);
    }

    @Order(5)
    @Test
    @DisplayName("We do not allow negative fees.")
    void checkNegativeFee(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

        assertFalse(testee.withdraw(0.1F, -1.0F));
        assertThat(testee.getBalance()).isEqualTo(100.0F);
    }

    @Order(6)
    @Test
    @DisplayName("We do not withdraw too much.")
    void checkWithdrawTooMuch(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

        assertFalse(testee.withdraw(testee.getBalance() + 0.1F, 1.0F));
        assertThat(testee.getBalance()).isEqualTo(100.0F);
    }

    @Order(7)
    @Test
    @DisplayName("We are able to calculate interest.")
    void checkInterest(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

        testee.addInterest();

        assertThat(testee.getBalance()).isEqualTo(104.5F);
    }

    @Order(8)
    @Test
    @DisplayName("Withdrawals up to the balance are ok.")
    void checkWithdraw(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

        assertTrue(testee.withdraw(testee.getBalance(), 1.0F));
        assertThat(testee.getBalance()).isEqualTo(-1.0F);
    }

}