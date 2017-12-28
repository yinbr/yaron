package com.yaron.actions;

import com.yaron.beans.ApplicationBean;
import com.yaron.beans.BaseBean;
import com.yaron.beans.ConnectionBean;
import com.yaron.beans.Role;
import com.yaron.beans.UserBean;
import com.yaron.server.stereotype.ViewAction;
import com.yaron.utils.ConnectionStatus;
import com.yaron.utils.Constants;
import com.yaron.utils.MockDataGenerator;
import com.yaron.utils.SelectItems;
import com.yaron.utils.ShowPage;

import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@ViewAction
@Scope("session")
public class LoginAction extends BaseBean {

    @Resource
    MockDataGenerator mockDataGenerator;
    @Resource
    SessionAction sessionAction;
    
    private UserBean loggedInUser;
    private String name = "test";
    private String password;
    
    
    
    public String login() {
    	System.out.println("test commit ");
    	for(UserBean user:mockDataGenerator.getUsers()) {
    		if(user.getUserName().equals(name)) {
    			if(user.getPassword().equals(password)) {
    				setLoggedInUser(user);
    				if(loggedInUser.getRole().equals(Role.ADMIN)) {
    					return ShowPage.SHOW_ADMIN_PAGE;
    				}if(loggedInUser.getRole().equals(Role.USER)) {
    					return ShowPage.SHOW_USER_PAGE;
    				}
    			}
    		}
    	}
    	return ShowPage.SHOW_LOGIN_PAGE;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserBean getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(UserBean loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
}
