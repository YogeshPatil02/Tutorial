package com.demo1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "emp1000")
public class Employee {
@Id
private int id1;
private String fnm,lnm;

public int getId() {
	return id1;
}
public void setId(int id1) {
	this.id1 = id1;
}
public String getFirstName() {
	return fnm;
}
public void setFirstName(String fnm) {
	this.fnm = fnm;
}
public String getLastName() {
	return lnm;
}
public void setLastName(String lnm) {
	this.lnm = lnm;
}


}
