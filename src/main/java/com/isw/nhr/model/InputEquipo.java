package com.isw.nhr.model;

import java.util.ArrayList;
import java.util.List;

public class InputEquipo {
	
	
	List<String> ids = new ArrayList<>();
	
	
	private String nameEquipo;
	
    private String director="";


	
    

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String getNameEquipo() {
		return nameEquipo;
	}

	public void setNameEquipo(String nameEquipo) {
		this.nameEquipo = nameEquipo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	
    
    
	
	
	
    

}