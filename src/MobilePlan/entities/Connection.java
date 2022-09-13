package MobilePlan.entities;

import MobilePlan.provided.ConnectionType;
import MobilePlan.provided.DateTime;

import java.util.LinkedList;

/**
 * 
 * A connection, aka a call between two contracts. A "phone call".<br>
 * 
 */
public class Connection {
    private MobilePhoneContract callee;
    private MobilePhoneContract caller;
    private DateTime dateTime;
    private ConnectionType type;
    private int units;

    public Connection(MobilePhoneContract caller,
                      MobilePhoneContract callee,
                      ConnectionType type,
                      DateTime dt,
                      int units){
        if(caller == null)
            throw new IllegalArgumentException("caller can not be null");
        if(callee == null)
            throw new IllegalArgumentException("callee can not be null");
        if(dt == null)
            throw new IllegalArgumentException("dateTime can not be null");
        if(units <= 0)
            throw new IllegalArgumentException("units can not be 0 or less");
        this.caller = caller;
        this.callee = callee;
        this.type = type;
        this.dateTime = dt;
        this.units = units;
        caller.addConnection(this);
        callee.addConnection(this);
    }

    public int getUnits(){
        return units;
    }

    public MobilePhoneContract getCaller() {
        return caller;
    }

    /**
     *  Creates a string representation of this connection.<br>
     */
    @Override
    public String toString() {
        return "\nConnection [caller=" + caller.getImei() + ", callee=" + callee.getImei() + ", type=" + type
                + ", units=" + units + ", DateTime=" + dateTime + "]";
    }

}
