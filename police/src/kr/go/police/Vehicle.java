package kr.go.police;

import java.io.Serializable;

public class Vehicle implements Serializable {
	private static final long serialVersionUID = -9014465200066681900L;

	private String no;
	private String model;
	private int cc;

	public Vehicle() {
	}

	public Vehicle(String no, String model, int cc) {
		this.no = no;
		this.model = model;
		this.cc = cc;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
}
