package com.baiyu.learn.protocol.learn_14_HTTP_XML;

/**
 * @auther baiyu
 * @date 2020/1/7
 */
public class Order {

    private long orderNumber;
    private Customer custormer;
    /* Billing address information. */
    private Address billTo;

    private Shipping shipping;
    /**
     * Shipping address information. If missing, the billing
     * address is also used as the shipping address.
     */
    private Address shipTo;

    private Float total;

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustormer() {
        return custormer;
    }

    public void setCustormer(Customer custormer) {
        this.custormer = custormer;
    }

    public Address getBillTo() {
        return billTo;
    }

    public void setBillTo(Address billTo) {
        this.billTo = billTo;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
