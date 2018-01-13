package com.yaron.utils;

import org.springframework.context.annotation.Scope;

import com.yaron.server.stereotype.ViewAction;

@ViewAction
@Scope("application")
public class ShowPage {
	public static String SHOW_LOGIN_PAGE ="showLoginPage";
	
	
	// ADMIN SECTION
	public static String SHOW_ADMIN_HOME_PAGE ="showAdminHomePage";
	public static String SHOW_KINDER_GARDEN_LIST_PAGE ="showKinderGardenListPage";
	public static String SHOW_USER_DETAILS_PAGE ="showUserDetailsPage";
	
	//USERS SECTION
	
	public static String SHOW_USER_HOME_PAGE ="showUserHomePage";
	public static String SHOW_HOUR_REPORT_PAGE ="showHourReportPage";
	
	

			
			
			
			
			
			
			
			
	
}
