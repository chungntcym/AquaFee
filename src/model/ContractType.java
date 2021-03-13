package model;

public class ContractType {

	private int id;
	private String name;

	public ContractType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ContractType() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
