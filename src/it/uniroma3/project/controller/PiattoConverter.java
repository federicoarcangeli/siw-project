package it.uniroma3.project.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import it.uniroma3.project.facade.CategoriaPiattoFacade;
import it.uniroma3.project.facade.PiattoFacade;
import it.uniroma3.project.model.CategoriaPiatto;
import it.uniroma3.project.model.Piatto;

@ManagedBean
@RequestScoped
public class PiattoConverter implements Converter, Serializable {  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7484982149036906341L;
	@EJB
	private PiattoFacade piattoFacade;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) throws ConverterException {
		CategoriaPiatto categoria = null;
		if(arg2!=null) {
			categoria = new CategoriaPiatto();
			categoria.setId(Long.parseLong(arg2));
		}
		return categoria;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) throws ConverterException {
		System.out.println("getAsString:"+arg2);
		if(arg2==null)
			return "";
		if(arg2 instanceof CategoriaPiatto)
			return String.valueOf(((CategoriaPiatto)arg2).getId());
		else
			throw new ConverterException(new FacesMessage("ciaone proprio getAsString"));
	}


}
