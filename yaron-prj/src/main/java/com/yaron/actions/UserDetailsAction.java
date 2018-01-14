package com.yaron.actions;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import com.yaron.beans.BaseBean;
import com.yaron.beans.UserBean;
import com.yaron.server.stereotype.ViewAction;
import com.yaron.utils.MockDataGenerator;


@ViewAction
@Scope("session")
public class UserDetailsAction extends BaseBean {

    @Resource
    MockDataGenerator mockDataGenerator;
    @Resource
    SessionAction sessionAction;
    
    private List<UserBean> users;
    private UserBean selectedUser;
    
    @PostConstruct
    public void init() {
    	users = mockDataGenerator.getUsers();
    }
    
    
    
    
    

	public List<UserBean> getUsers() {
		return users;
	}

	public void setUsers(List<UserBean> users) {
		this.users = users;
	}

	public UserBean getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserBean selectedUser) {
		this.selectedUser = selectedUser;
	}
  
}
