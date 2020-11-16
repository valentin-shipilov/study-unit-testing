package com.example.mockito;

import java.util.Optional;

public interface SubscriberRepository {
    Optional<String> searchForActiveSubscriberWithNumber(String phoneNumber);

    Optional<String> searchForLastInactiveSubscriberWithNumber(String phoneNumber);
}
