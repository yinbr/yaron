package com.yaron.utils;

import org.springframework.context.annotation.Scope;

import com.yaron.server.stereotype.ViewAction;



@ViewAction
@Scope("application")
public enum ConnectionStatus {
    CONNECTED, NOT_CONNECTED
}
