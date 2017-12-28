package com.yaron.actions;

import com.yaron.beans.ApplicationBean;
import com.yaron.beans.BaseBean;
import com.yaron.server.stereotype.ViewAction;
import com.yaron.utils.MockDataGenerator;
import com.yaron.utils.SelectItems;

import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.model.SelectItem;
import java.util.List;


@ViewAction
@Scope("session")
public class ApplicationListAction extends BaseBean {

    @Resource
    MockDataGenerator mockDataGenerator;

    private List<ApplicationBean> applications ;


    @PostConstruct
    public void init(){
       System.out.println("Getting the applications from DB");
//       applications = mockDataGenerator.getApplications();
    }

    public String createNewApplication() {
        return "";
    }

    public List<ApplicationBean> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationBean> applications) {
        this.applications = applications;
    }

}
