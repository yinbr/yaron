package com.yaron.utils;

import org.springframework.context.annotation.Scope;

import com.yaron.server.stereotype.ViewAction;

import javax.annotation.PostConstruct;
import java.io.Serializable;



@ViewAction
@Scope("singleton")
public class SelectItems implements Serializable {


    @PostConstruct
    public void init() {

    }
}
