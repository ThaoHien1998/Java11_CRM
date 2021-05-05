package cybersoft.java11.crm.model;

import java.sql.Date;

public class Project {
	/* properties */
	private int id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private User createUser;
	
	/* constructors */
	public Project() {
		// TODO Auto-generated constructor stub
		id = -1;
		name = "";
		description = "";
		startDate = new Date(-1);
		endDate = new Date(-1);
		createUser = null;
	}
	
	public Project(int id, String name, String description, Date start_date, Date end_date, User create_user) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = start_date;
		this.endDate = end_date;
		this.createUser = create_user;
	}

	/* getters - setters */
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getStart_date() {
		return startDate;
	}

	public Date getEnd_date() {
		return endDate;
	}

	public User getCreate_user() {
		return createUser;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStart_date(Date start_date) {
		this.startDate = start_date;
	}

	public void setEnd_date(Date end_date) {
		this.endDate = end_date;
	}

	public void setCreate_user(User create_user) {
		this.createUser = create_user;
	}
}
