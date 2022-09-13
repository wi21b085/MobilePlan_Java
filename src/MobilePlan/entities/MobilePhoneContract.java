package MobilePlan.entities;

import java.util.LinkedList;
import java.util.List;

import MobilePlan.provided.Customer;

/**
 * A MobilePhoneContract base class.<br>
 * Concrete sub types must implement the units and fee structure.
 */
public abstract class MobilePhoneContract implements Comparable<MobilePhoneContract>{
	private String carrier;
	private List<Connection> connections = new LinkedList<>();
	private Customer customer;
	private String imei;

	public MobilePhoneContract(Customer customer,
							   String imei,
							   String carrier){
		if(customer == null)
			throw new IllegalArgumentException("invalid customer");
		if(imei == null || imei.isEmpty())
			throw new IllegalArgumentException("invalid imei");
		if(carrier == null || imei.isEmpty())
			throw new IllegalArgumentException("invalid carrier");

		this.carrier = carrier;
		this.customer = customer;
		this.imei = imei;
	}

	public List<Connection> outgoingConnections(){
		List<Connection> out = new LinkedList<>();
		for(Connection c: connections)
			if(c.getCaller() == this)
				out.add(c);
		return out;
	}

	public abstract int unitsLeft();

	public abstract float additionalFee();

	public MobilePhoneContract setImei(String imei){
		if(imei == null || imei.isEmpty())
			return this;
		this.imei = imei;
		return this;
	}

	public int getUsedUnits(){
		List<Connection> out = outgoingConnections();
		int sum = 0;
		for(Connection c : out)
			sum += c.getUnits();
		return sum;
	}

	@Override
	public int compareTo(MobilePhoneContract a){
		return this.getUsedUnits()-a.getUsedUnits();
	}

	public Customer getCustomer(){
		return customer;
	}

	public String getImei(){
		return imei;
	}

	public boolean addConnection(Connection connection){
		return connections.add(connection);
	}

    /**
     * Creates a string representation of this MobilePhoneContract.<br>
     * <p>
     * The returned string contains the values
     * <ul>
     * <li>customer string</li>
     * <li>imei number</li>
     * <li>carrier name</li>
     * <li>used units</li>
     * <li>units left</li>
     * <li>additional fees to pay</li>
     * <li>a summary of all outgoing calls</li>
     * </ul>
     *
     * @ProgrammingProblem.Hint provided
     */
    @Override
    public String toString() {
        return "MobilePhoneContract [\ncarrier=" + carrier + ", customer=" + customer
                + ", imei=" + imei + ", usedUnits=" + getUsedUnits() + ",\nconnections=" + outgoingConnections() + "\n]";
    }


}
