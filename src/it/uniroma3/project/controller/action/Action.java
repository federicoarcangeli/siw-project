package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;

public interface Action {
	
	public String execute(HttpServletRequest request);

}
