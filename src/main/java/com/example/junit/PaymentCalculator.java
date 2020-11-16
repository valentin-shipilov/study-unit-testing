package com.example.junit;

public class PaymentCalculator {
    private static final long SILVER_LIMIT = 5L;
    private static final long GOLDEN_LIMIT = 3L;

    private final long costForMinute;

    public PaymentCalculator(long costForMinute) {
        super();
        this.costForMinute = costForMinute;
    }

    /*
    * Платеж рассчитывается по следующему правилу:
    * 1. Если клиент обычный, то тарифицируется каждая минута
    * 2. Если клиент "серебряный", то
    *    а) тарифицируется каждая минута, начиная с пятой, если разговор длился пять минут и более
    *    б) если разговор длился менее пяти минут, снимается фиксированная плата за одну минуту
    * 3. Если клиент "золотой", то тарифицируется каждая минута, начиная с третьей,
    *    первые три минуты - бесплатно
    */
    Long calculatePayment(CustomerCategory customerCategory, long numberOfMinutes) {
        if (numberOfMinutes < 0) {
            throw new IllegalArgumentException("Invalid number of minutes: " +  numberOfMinutes);
        }

        switch (customerCategory) {
            case REGULAR_CUSTOMER:
                return paymentForMinutes(numberOfMinutes);
            case SILVER_CUSTOMER:
                return numberOfMinutes > SILVER_LIMIT
                        ? paymentForMinutes(numberOfMinutes - SILVER_LIMIT)
                        : paymentForMinutes(1);
            case GOLDEN_CUSTOMER:
                return numberOfMinutes > GOLDEN_LIMIT
                        ? paymentForMinutes(numberOfMinutes - GOLDEN_LIMIT)
                        : 0L;
            default:
                throw new IllegalArgumentException("Unknown customer category: " + customerCategory);
        }
    }

    private Long paymentForMinutes(long numberOfMinutes) {
        return numberOfMinutes * costForMinute;
    }
}
