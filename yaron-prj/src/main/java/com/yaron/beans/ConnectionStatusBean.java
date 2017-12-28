package com.yaron.beans;


public class ConnectionStatusBean extends BaseBean {

    public enum ConnectionMonitoring {
         ON, OFF;
    }

    public enum ConnectionIcon {
        OPEN, CLOSED, NONE;
    }

    private ConnectionMonitoring monitoring;
    private ConnectionIcon icon;
    private int ticketsCount;

    public ConnectionMonitoring getMonitoring() {
        return monitoring;
    }

    public void setMonitoring(ConnectionMonitoring monitoring) {
        this.monitoring = monitoring;
    }

    public ConnectionIcon getIcon() {
        return icon;
    }

    public void setIcon(ConnectionIcon icon) {
        this.icon = icon;
    }

    public int getTicketsCount() {
        return ticketsCount;
    }

    public void setTicketsCount(int ticketsCount) {
        this.ticketsCount = ticketsCount;
    }
}
