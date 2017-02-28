package com.botree.common;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * This is a backing bean which is used to display modules menu in the header
 * and corresponding screens in the left menu. This class encapsulates list of
 * 'Menu' which holds name of the menu and the url associated with it.
 * 
 */
@Component("navi")
@Scope("session")
public class Navigation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean renderModule = true;
	private String selectedUrl = "";

	public boolean isRenderModule() {
		return renderModule;
	}

	public void setRenderModule(boolean renderModule) {
		this.renderModule = renderModule;
	}

	public String getSelectedUrl() {
		return selectedUrl;
	}

	public void setSelectedUrl(String selectedUrl) {
		this.selectedUrl = selectedUrl;
	}

	@PostConstruct
	public void display() {
		renderModule = true;
	}

	public void selectUrl(String url) {
		renderModule = false;
		setSelectedUrl(url);
	}
	public void landingScreen() 
	
	{
		renderModule=true;
		setSelectedUrl("/pages/landing.xhtml");
		
	}

}