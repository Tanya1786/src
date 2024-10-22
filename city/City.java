package csis3475;

public class City {
	
	String name;
	int population;
	
	public City(String n, int p) {
		name = n;
		population = p;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", population=" + population + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	

}
