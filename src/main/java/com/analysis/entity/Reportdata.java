package com.analysis.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reportdata database table.
 * 
 */
@Entity
@NamedQuery(name="Reportdata.findAll", query="SELECT r FROM Reportdata r")

public class Reportdata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String fromsite;

	private String itemcategory;

	private String itemname;

	private double rating1;

	private double rating2;

	private double rating3;

	private double rating4;

	private double rating5;

	private String updatedDate;

	public Reportdata() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromsite() {
		return this.fromsite;
	}

	public void setFromsite(String fromsite) {
		this.fromsite = fromsite;
	}

	public String getItemcategory() {
		return this.itemcategory;
	}

	public void setItemcategory(String itemcategory) {
		this.itemcategory = itemcategory;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public double getRating1() {
		return this.rating1;
	}

	public void setRating1(double rating1) {
		this.rating1 = rating1;
	}

	public double getRating2() {
		return this.rating2;
	}

	public void setRating2(double rating2) {
		this.rating2 = rating2;
	}

	public double getRating3() {
		return this.rating3;
	}

	public void setRating3(double rating3) {
		this.rating3 = rating3;
	}

	public double getRating4() {
		return this.rating4;
	}

	public void setRating4(double rating4) {
		this.rating4 = rating4;
	}

	public double getRating5() {
		return this.rating5;
	}

	public void setRating5(double rating5) {
		this.rating5 = rating5;
	}

	public String getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

}
