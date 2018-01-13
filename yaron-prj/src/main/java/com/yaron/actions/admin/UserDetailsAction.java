package com.yaron.actions.admin;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;

import com.yaron.beans.UserBean;
import com.yaron.server.stereotype.ViewAction;
import com.yaron.utils.MockDataGenerator;



@ViewAction
@Scope("session")
public class UserDetailsAction {
	
	private List<UserBean> users;
	
	@Resource
    MockDataGenerator mockDataGenerator;
	
	
	 @PostConstruct
    public void prepareUsers() {
        users = mockDataGenerator.getUsers();
    }
	
	
	
	
	

	public List<UserBean> getUsers() {
		return users;
	}

	public void setUsers(List<UserBean> users) {
		this.users = users;
	}
	
	
	
	
	

}
