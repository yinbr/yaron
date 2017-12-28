package com.yaron.beans;

import java.io.Serializable;

public class BaseBean implements Serializable {
    private long id;

    public BaseBean() {
        this.id = ((long)(Math.random()))*100000000;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
