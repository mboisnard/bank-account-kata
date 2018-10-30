package fr.lacombe.kata.bank;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

class DateProviderMock {

    static final LocalDateTime PROVIDER_TIME = LocalDateTime.parse("2018-10-30T22:00:00");

    static DateProvider getMock() {
        return mock(DateProvider.class);
    }
}
