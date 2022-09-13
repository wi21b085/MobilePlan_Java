package MobilePlan.entities;

import MobilePlan.provided.Customer;

public class PrePaidCard extends MobilePhoneContract {
    private float preloadedAmount = (float) 0.0;

    public PrePaidCard(Customer customer,
                       String imei,
                       String carrier,
                       float preloadedAmount) {
        super(customer, imei, carrier);
        setPreloadedAmount(preloadedAmount);
    }

    public PrePaidCard(Customer customer,
                       java.lang.String imei,
                       java.lang.String carrier) {
        super(customer, imei, carrier);
        this.preloadedAmount = (float) 0.0;
    }

    private void setPreloadedAmount(float preloadedAmount) {
        if (preloadedAmount >= 0.0)
            this.preloadedAmount = preloadedAmount;
    }

    @Override
    public int unitsLeft() {
        int left = (int) (preloadedAmount / 0.4F) - getUsedUnits();
        if (left < 0)
            left = 0;
        return left;
    }

    @Override
    public float additionalFee() {
        return 0;
    }

    public void topUp(float additionalAmount) {
        if ((additionalAmount % 5) == 0)
            preloadedAmount += additionalAmount;
    }
}
