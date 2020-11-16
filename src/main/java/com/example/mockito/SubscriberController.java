package com.example.mockito;

import java.util.Optional;

public class SubscriberController {
    private final SubscriberRepository subscriberRepository;
    private final SubscriberViewBuilder subscriberViewBuilder;

    public SubscriberController(
            SubscriberRepository subscriberRepository,
            SubscriberViewBuilder subscriberViewBuilder
    ) {
        super();
        this.subscriberRepository = subscriberRepository;
        this.subscriberViewBuilder = subscriberViewBuilder;
    }

    /*
    *   1) Ищем активного абонента по номеру, если он есть, то отрисовываем его
    *   2) Если нет активного абонента с таким номером, то ищем неактивного и отрисовываем его
    *   3) Если нет и не было абонентов с таким номером, то отрисовываем ошибку
    */
    public String searchForSubscriber(String phoneNumber) {
        Optional<String> activeSubscriber = subscriberRepository.searchForActiveSubscriberWithNumber(
                phoneNumber);

        if (activeSubscriber.isPresent()) {
            return subscriberViewBuilder.renderViewForActiveSubscriber(
                    activeSubscriber.get(),
                    phoneNumber);
        }

        Optional<String> lastInactiveSubscriber = subscriberRepository.searchForLastInactiveSubscriberWithNumber(
                phoneNumber);

        if (lastInactiveSubscriber.isPresent()) {
            return subscriberViewBuilder.renderViewForInactiveSubscriber(
                    lastInactiveSubscriber.get(),
                    phoneNumber);
        }

        return subscriberViewBuilder.renderViewForInvalidPhoneNumber(
                phoneNumber);
    }
}
