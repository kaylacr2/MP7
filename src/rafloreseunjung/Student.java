/**
 * Student class where a student has a name and major, and statistics for
 * their academics, health, social, and financial.
 */
package rafloreseunjung;

/**
 * @author Eunjung, Raflores
 */
public class Student {
	/** Basic attributes of student. */
	private String name;
	private String major;
	
	/** Stats for student. */
	private int academic;
	private int health;
	private int social;
	private int financial;
	
	/**
	 * Default constructor for student.
	 * @throws InvalidMajorException 
	 */
	public Student() throws InvalidMajorException {
		setName("default");
		setMajor("undecided");
		setAcademic(0);
		setHealth(0);
		setSocial(0);
		setFinancial(0);
	}
	
	/**
	 * Constructor that takes in a name and a major for a student.
	 * @param n
	 * @param m
	 * @throws InvalidMajorException
	 */
	public Student(String n, String m) throws InvalidMajorException {
		setName(n);
		setMajor(m);
		setAcademic(0);
		setHealth(0);
		setSocial(0);
		setFinancial(0);
	}
	
	/**
	 * Resets stats for the student.
	 */
	public void reset() {
		setAcademic(0);
		setHealth(0);
		setSocial(0);
		setFinancial(0);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) throws InvalidMajorException {
		if (!(major.equals("cs") || major.equals("business") || major.equals("psychology")
				|| major.equals("ece") || major.equals("mcb") || major.equals("undeclared")))
			throw new InvalidMajorException("That major is not within the given major list.");
		this.major = major;
	}

	/**
	 * @return the academic
	 */
	public int getAcademic() {
		return academic;
	}

	/**
	 * @param academic the academic to set
	 */
	public void setAcademic(int academic) {
		this.academic = academic;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the social
	 */
	public int getSocial() {
		return social;
	}

	/**
	 * @param social the social to set
	 */
	public void setSocial(int social) {
		this.social = social;
	}
	
	/**
	 * @return the financial
	 */
	public int getFinancial() {
		return financial;
	}

	/**
	 * @param financial the financial to set
	 */
	public void setFinancial(int financial) {
		this.financial = financial;
	}
}
