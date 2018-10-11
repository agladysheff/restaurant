package ru.agladyshev.restaurant.Wrappers;

public class StatusWrapper extends IdWrapper {

    private byte status;

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
