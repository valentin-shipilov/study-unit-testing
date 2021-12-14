package com.example.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class SubscriberControllerTest {
    @Mock
    private SubscriberRepository mockedSubscriberRepository;
    @Mock
    private SubscriberViewBuilder mockedSubscriberViewBuilder;
    @InjectMocks
    private SubscriberController testee;

    private final String givenPhoneNumber = "(999)123-45-67";

    private final String givenActiveSubscriber = "John Doe";

    private final String givenViewForActiveSubscriber = "Hello, John Doe";


    @Test
    void should_search_for_active_subscriber_at_first() {
        // when
        runCatching(()  -> testee.searchForSubscriber(givenPhoneNumber));

        // then
        then(mockedSubscriberRepository).should().searchForActiveSubscriberWithNumber(givenPhoneNumber);
    }

    @Test
    void given_active_subscriber_exists_then_should_render_view_for_him() {
        // given
        given(mockedSubscriberRepository.searchForActiveSubscriberWithNumber(anyString()))
                .willReturn(Optional.of(givenActiveSubscriber));

        // when
        runCatching(()  -> testee.searchForSubscriber(givenPhoneNumber));

        // then
        then(mockedSubscriberViewBuilder).should().renderViewForActiveSubscriber(
                givenActiveSubscriber,
                givenPhoneNumber);
    }

    @Test
    void given_active_subscriber_exists_then_should_return_rendered_view() {
        // given
        given(mockedSubscriberRepository.searchForActiveSubscriberWithNumber(anyString()))
                .willReturn(Optional.of(givenActiveSubscriber));
        given(mockedSubscriberViewBuilder.renderViewForActiveSubscriber(anyString(), anyString()))
                .willReturn(givenViewForActiveSubscriber);

        // when
        String actualView = testee.searchForSubscriber(givenPhoneNumber);

        // then
        assertEquals(givenViewForActiveSubscriber, actualView, "view");
    }

    // Задание: добавить остальные тесты для метода  searchForSubscriber

    private void runCatching(Executable executable) {
        try {
            executable.execute();
        } catch (Throwable ex) {
            // do nothing
        }
    }
}
