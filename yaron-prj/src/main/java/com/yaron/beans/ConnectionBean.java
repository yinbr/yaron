package com.yaron.beans;

import java.util.ArrayList;
import java.util.List;

import com.yaron.utils.ConnectionStatus;
import com.yaron.utils.Constants;


public class ConnectionBean extends BaseBean {

    private String name;
    private String comments;
    private ConnectionStatus status;
    private List<NetworkObjectBean> sources = new ArrayList<NetworkObjectBean>();
    private List<NetworkObjectBean> destinations = new ArrayList<NetworkObjectBean>();
    private List<ServiceBean> services = new ArrayList<ServiceBean>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<NetworkObjectBean> getSources() {
        return sources;
    }

    public void setSources(List<NetworkObjectBean> sources) {
        this.sources = sources;
    }

    public List<NetworkObjectBean> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<NetworkObjectBean> destinations) {
        this.destinations = destinations;
    }

    public List<ServiceBean> getServices() {
        return services;
    }

    public void setServices(List<ServiceBean> services) {
        this.services = services;
    }

    public ConnectionStatus getStatus() {
        return status;
    }

    public void setStatus(ConnectionStatus status) {
        this.status = status;
    }
}
