package com.yaron.beans;

import java.sql.Connection;
import java.util.List;


public class ApplicationBean extends BaseBean {

    private String name;
    private List<ConnectionBean> connections;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ConnectionBean> getConnections() {
        return connections;
    }

    public void setConnections(List<ConnectionBean> connections) {
        this.connections = connections;
    }

}
