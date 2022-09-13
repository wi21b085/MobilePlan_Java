package MobilePlan.util;

import MobilePlan.entities.MobilePhoneContract;
import MobilePlan.provided.Matcher;

public class MobilePhoneContractHomeAddressMatcher implements Matcher<MobilePhoneContract> {
    private String pattern;

    public MobilePhoneContractHomeAddressMatcher(String pattern){
        this.pattern = pattern;
    }

    @Override
    public boolean matches(MobilePhoneContract mobilePhoneContract) {
        String city = mobilePhoneContract.getCustomer().getHome().getCity();
        String state = mobilePhoneContract.getCustomer().getHome().getState();
        if(city.contains(pattern) || state.contains(pattern))
            return true;
        return false;
    }
}
