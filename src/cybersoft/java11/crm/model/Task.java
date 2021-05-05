package cybersoft.java11.crm.model;

import java.sql.Date; // de parse qua Date trong database

public class Task {
	/* properties */
	private int id;
	private String name;
	private String description;
	private Date startDate;
	private Date dueDate;
	private User assignee;
	private Project project;
	private Status status;
	
	/* constructors */
	public Task() {
		// TODO Auto-generated constructor stub
		id = -1;
		name = "";
		description = "";
		startDate = new Date(-1);
		dueDate = new Date(-1);
		assignee = null;
		project = null;
		status = null;
	}

	public Task(int id, String name, String description, Date start_date, Date due_date, User assignee, Project project,
			Status status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = start_date;
		this.dueDate = due_date;
		this.assignee = assignee;
		this.project = project;
		this.status = status;
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

	public Date getDue_date() {
		return dueDate;
	}

	public User getAssignee() {
		return assignee;
	}

	public Project getProject() {
		return project;
	}

	public Status getStatus() {
		return status;
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

	public void setDue_date(Date due_date) {
		this.dueDate = due_date;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
