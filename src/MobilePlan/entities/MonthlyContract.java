package MobilePlan.entities;

import MobilePlan.provided.Customer;

public class MonthlyContract extends MobilePhoneContract{
    private int includedUnits = 0;

    public MonthlyContract(Customer customer,
                           String imei,
                           String carrier,
                           int includedUnits){
        super(customer, imei, carrier);
        setIncludedUnits(includedUnits);
    }

    public void setIncludedUnits(int includedUnits) {
        if(includedUnits >= 0)
            this.includedUnits = includedUnits;
    }

    @Override
    public int unitsLeft() {
        int left = includedUnits - getUsedUnits();
        if(includedUnits < 0)
            left = 0;
        return left;
    }

    @Override
    public float additionalFee() {
        if(unitsLeft() > 0)
            return 0;
        float euro = (float) ((getUsedUnits() - includedUnits)*0.2);
        return euro;
    }
}
