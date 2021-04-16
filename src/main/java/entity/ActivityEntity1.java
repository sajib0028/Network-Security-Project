package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

@Entity
public class ActivityEntity1 {

	private static final long serialVersionUID = 1L;


  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;
  @NotEmpty
  private String Title;

  @NotEmpty
  private String Description;

  @NotEmpty
  private String ActivityDate;
  @NotEmpty
  private String Time;

  public int getId() {
      return Id;
  }

  public void setId(int id) {
      Id = id;
  }

  public String getTitle() {
      return Title;
  }

  public void setTitle(String title) {
      Title = title;
  }

  public String getDescription() {
      return Description;
  }

  public void setDescription(String description) {
	  Description = description;
  }

  public String getActivityDate() {
      return ActivityDate;
  }

  public void setActivityDate(String activityDate) {
	  ActivityDate = activityDate;
  }

  public String getTime() {
      return Time;
  }

  public void setTime(String time) {
	  Time = time;
  }

  @Override
  public String toString() {
      return "Activity [Id=" + Id + ", Title=" + Title + ", Description=" + Description + ", ActivityDate="
              + ActivityDate + ", Time=" + Time + "]";
  }

}

