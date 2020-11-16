package com.example.mockito;

public interface SubscriberViewBuilder {
    String renderViewForActiveSubscriber(String subscriberName, String phoneNumber);
    String renderViewForInactiveSubscriber(String subscriberName, String phoneNumber);
    String renderViewForInvalidPhoneNumber(String phoneNumber);
}
