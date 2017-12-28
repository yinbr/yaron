package com.yaron.actions;

import com.yaron.beans.ApplicationBean;
import com.yaron.beans.BaseBean;
import com.yaron.beans.NetworkObjectBean;
import com.yaron.beans.ServiceBean;
import com.yaron.beans.UserBean;
import com.yaron.server.stereotype.ViewAction;
import com.yaron.utils.MockDataGenerator;

import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;



@ViewAction
@Scope("session")
public class ResourcesAction extends BaseBean {

    @Resource
    MockDataGenerator mockDataGenerator;

    private List<ApplicationBean> applications = new ArrayList<ApplicationBean>();
    private List<ServiceBean> services = new ArrayList<ServiceBean>();
    private List<UserBean> users = new ArrayList<UserBean>();


    @PostConstruct
    public void init(){
       
        users = mockDataGenerator.getUsers();
    }

    public List<ApplicationBean> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationBean> applications) {
        this.applications = applications;
    }

    public List<ServiceBean> getServices() {
        return services;
    }

    public void setServices(List<ServiceBean> services) {
        this.services = services;
    }

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }
}
