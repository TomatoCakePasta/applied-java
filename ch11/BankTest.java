package ch11;

import java.beans.Transient;

import org.junit.jupiter.api.*;

public class BankTest {
    @Test
    public void test01() {
        Bank bank = new Bank();

        assertThrows(IllegalAccessException.class, () -> {
            b.setName("ab");
        });
    }

    @Test
    public void test02() {
        Bank bank = new Bank();

        bank.setName("abc");
        assertEquals("abc", bank.getName());
    }

    @Test
    public void test03() {
        try {
            Bank b = new Bank();
            b.setName(null);
        } catch (NullPointerException e) {
            return;
        }

        fail();
    }
}
