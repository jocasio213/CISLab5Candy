package cis232.Candy;

public class CandyController {

	 private String name; 
	 private String flavor; 
	 private int year;
	 private int cal;
	 

	 public void setName(String name) {
			this.name = name;
		}
	public String getName() {
		return name;
	}
	
	 public void setFlavor(String flavor) {
			this.flavor = flavor;
		}
	public String getFlavor() {
		return flavor;
	}

	public void setYear(int year) {
		this.year = year;
		if (year<0)
		{
			throw new IllegalArgumentException();
		}
	}
	
	public int getYear() {
		return year;
	}

	public void setCal(int cal) {
		this.cal = cal;
		if (cal<0)
		{
			throw new IllegalArgumentException();
		}
	} 
	
	public double getCal() {
		return cal;
	}

	public String toString()
	{
		return String.format("Inserted", name, flavor, year, cal );
	}
}
