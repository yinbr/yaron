package com.yaron.actions;

import org.springframework.context.annotation.Scope;

import com.yaron.server.stereotype.ViewAction;

import java.io.Serializable;

@ViewAction
@Scope("session")
public class SessionAction implements Serializable {
	private static String PAGE_SELECTED_HOME = "home";
	private static String PAGE_SELECTED_REPORTS = "reports";


	private String selectedPage = PAGE_SELECTED_HOME;

	public String getSelectedPage() {
		return selectedPage;
	}

	public void setSelectedPage(String selectedPage) {
		this.selectedPage = selectedPage;
	}
	
}
