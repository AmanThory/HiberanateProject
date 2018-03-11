package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	@Id
	private int pid;
	private int pcost;
	private String pname;
	
	@ManyToMany
	private Collection<Supplier> supplier = new ArrayList<Supplier>();

	public Collection<Supplier> getSupplier() {
		return supplier;
	}
	public void setSupplier(Collection<Supplier> supplier) {
		this.supplier = supplier;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}

}
