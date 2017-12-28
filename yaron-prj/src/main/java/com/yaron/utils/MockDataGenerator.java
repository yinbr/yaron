package com.yaron.utils;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.yaron.beans.Role;
import com.yaron.beans.UserBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public class MockDataGenerator {
	    
    private List<UserBean> users = new ArrayList<UserBean>();

   
   

    @PostConstruct
    public void prepareUsers() {
        users = fillUsers(20);
    }

   
    private List<UserBean> fillUsers(int howMany) {
        List<UserBean> userBeans = new ArrayList<UserBean>();
        
        //Create admin user
        UserBean admin = new UserBean();
        admin.setFirstName("Yaron");
        admin.setLastName("Brosh");
        admin.setPassword("admin");
        admin.setUserName("admin");
        admin.setRole(Role.ADMIN);
        userBeans.add(admin);
        
        
        //Create test user
        UserBean test = new UserBean();
        test.setFirstName("Test");
        test.setLastName(" User" );
        test.setPassword("test");
        test.setUserName("test");
        test.setRole(Role.USER);
        userBeans.add(test);
        
        return userBeans;
    }

   
    public List<UserBean> getUsers() {
        return users;
    }

}
