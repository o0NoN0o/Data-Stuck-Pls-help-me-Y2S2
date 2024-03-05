package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
	
	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
		setName(name);
		setBloodCost(bloodCost);
		setPower(power);
		setHealth(health);
		setFlavorText(flavorText);
		
	}
	
	public void setName(String name) {
		if(name.isBlank()) {
			this.name = "Creature";
		} else {
			this.name = name;
		}
	}
	
	public void setBloodCost(int bloodCost) {
		if(bloodCost < 0) {
			this.bloodCost = 0;
		} else {
			this.bloodCost = bloodCost;
		}
	}
	
	public void setPower(int power) {
		if(power < 0) {
			this.power = 0;
		} else {
			this.power = power;
		}
	}
	
	public void setHealth(int health) {
		if(health < 1) {
			this.health =  1;
		} else {
			this.health = health;
		}
	}
	
	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBloodCost() {
		return this.bloodCost;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public String getFlavorText() {
		return this.flavorText;
	}
	
	public boolean equals(UnitCard other) {
		return this.name.equals(other.getName());
	}
}
