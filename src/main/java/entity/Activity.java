package entity;

public class Activity {

    public Activity(){
        super();
    }

    public String Id;
    public String Title;
    public String Description;
    public String ActivityDate;
    public String Time;


    public void setId(String id) {
        this.Id = id;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setDaten(String activityDate) {
        this.ActivityDate = activityDate;
    }

    public void setTime(String time) {
        this.Time = time;
    }

    public String getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getActivityDate() {
        return ActivityDate;
    }

    public String getTime() {
        return Time;
    }
}
