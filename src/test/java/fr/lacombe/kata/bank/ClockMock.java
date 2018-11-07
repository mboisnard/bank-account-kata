package fr.lacombe.kata.bank;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClockMock {

    static final LocalDateTime DEFAULT_CLOCK_TIME = LocalDateTime.parse("2018-10-30T22:00:00");

    static Clock givenTimeIs(LocalDateTime time) {
        Clock clock = mock(Clock.class);

        when(clock.getTime()).thenReturn(time);

        return clock;
    }

    static Clock withDefaultClockTime() {
        return givenTimeIs(DEFAULT_CLOCK_TIME);
    }
}
