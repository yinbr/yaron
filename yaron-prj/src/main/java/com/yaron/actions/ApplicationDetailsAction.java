package com.yaron.actions;

import com.yaron.beans.ApplicationBean;
import com.yaron.beans.BaseBean;
import com.yaron.beans.ConnectionBean;
import com.yaron.server.stereotype.ViewAction;
import com.yaron.utils.ConnectionStatus;
import com.yaron.utils.Constants;
import com.yaron.utils.MockDataGenerator;
import com.yaron.utils.SelectItems;

import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@ViewAction
@Scope("session")
public class ApplicationDetailsAction extends BaseBean {

    @Resource
    MockDataGenerator mockDataGenerator;

    private ApplicationBean selectedApplication = new ApplicationBean();

    public enum ApplicationSortBy {
        DATE("Date"),
        NAME("Name"),
        STATUS("Status"),
        OWNER("Owner");

        private String label;

        private ApplicationSortBy(String label) {
            this.label = label;
        }

        public String getLabel() {
            return this.label;
        }
    }

    private ApplicationSortBy selectedSortBy = ApplicationSortBy.DATE;

//    @PostConstruct
//    public void init(){
//        selectedApplication = mockDataGenerator.getApplications().get(0);
//    }

    public ApplicationBean getSelectedApplication() {
        return selectedApplication;
    }

    public void setSelectedApplication(ApplicationBean selectedApplication) {
        this.selectedApplication = selectedApplication;
    }

    public ApplicationSortBy[] getApplicationSortByOptions() {
        return ApplicationSortBy.values();
    }

    public ApplicationSortBy getSelectedSortBy() {
        return selectedSortBy;
    }

    public void setSelectedSortBy(ApplicationSortBy selectedSortBy) {
        this.selectedSortBy = selectedSortBy;
    }



    public void changeConnectionStatus(ConnectionBean connectionBean, ConnectionStatus newStatus) {
        ConnectionBean conn = findConnectionInApplication(connectionBean);
        if(conn != null) {
            conn.setStatus(newStatus);
        }
    }

    private ConnectionBean findConnectionInApplication(ConnectionBean connectionBean) {
        for(ConnectionBean bean : selectedApplication.getConnections()) {
            if(bean.getId() == connectionBean.getId()) return bean;
        }
        return null;
    }
}
