package com.bank;

import com.bank.impl.AccountImpl;
import com.bank.impl.ClientImpl;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Account account;


    @Before
    public void setUp() {
        //Given
        Client client = new ClientImpl("1", "pierre-jean");
        account = new AccountImpl("1", client, 100, Currency.EUR);
    }

    @Test
    public void testWithdraw10EURFrom100EURAccountShouldReturnAccountWith90EURBalance() throws IllegalStateException {
        // When
        account.withdraw(10, Currency.EUR);

        // Then
        assertThat(account.getBalanceMoney()).isEqualTo(90);
        assertThat(account.getBalanceCurrency()).isEqualTo(Currency.EUR);
    }

    @Test
    public void testWithdraw0EURFrom100EURAccountShouldReturnAccountWith100EURBalance() throws IllegalStateException {
        // When
        account.withdraw(0, Currency.EUR);

        // Then
        assertThat(account.getBalanceMoney()).isEqualTo(100);
        assertThat(account.getBalanceCurrency()).isEqualTo(Currency.EUR);
    }

    @Test(expected = IllegalStateException.class)
    public void testWithdraw110EURFrom100EURAccountShouldThrowIllegalStateException() {
        // When
        account.withdraw(110, Currency.EUR);

        // Then
        //illegal state exception
    }


    @Test(expected = IllegalStateException.class)
    public void testWithdraw10USDFrom100EURAccountShouldThrowIllegalStateException() {
        // When
        account.withdraw(0, Currency.USD);

        // Then
        //illegal state exception
    }

}