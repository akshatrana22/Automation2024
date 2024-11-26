package com.test.BS.base;

public abstract class SuperBase {
	
	public abstract String  getTheTitleOfPage();
	
	public abstract String getCurrentURLOfPage();
	
	public abstract void navigateTo(String Url);
	
	public abstract void navigateBack();
	
	public abstract void navigateForward();

	public abstract void switchToChild();
	
	public abstract void switchToParent();


}
