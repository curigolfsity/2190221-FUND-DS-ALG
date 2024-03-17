package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;
	
	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
		this.setName(name);
		this.setBloodCost(bloodCost);
		this.setPower(power);
		this.setHealth(health);
		this.setFlavorText(flavorText);
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
	
	public void setName(String name) {
		this.name = (name.isBlank()) ? "Creature" : name;
	}
	
	public void setBloodCost(int bloodCost) {
		this.bloodCost = (bloodCost < 0) ? 0 : bloodCost;
	}
	
	public void setPower(int power) {
		this.power = (power < 0) ? 0 : power;
	}
	
	public void setHealth(int health) {
		this.health = (health < 1) ? 1 : health;
	}
	
	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}
	
	public boolean equals(UnitCard other) {
		return this.name == other.getName();
	}

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
}
