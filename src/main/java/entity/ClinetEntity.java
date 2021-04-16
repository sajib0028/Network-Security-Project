package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

@Entity
public class ClinetEntity {

	
	
	private static final long serialVersionUID = 1L;

  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;
  @NotEmpty
  private String Name;

  @NotEmpty
  private String Position;

  @javax.validation.constraints.Email
  private String Email;
  @NotEmpty
  private String Address;

  public int getId() {
      return Id;
  }

  public void setId(int id) {
      Id = id;
  }

  public String getName() {
      return Name;
  }

  public void setName(String name) {
      Name = name;
  }

  public String getPosition() {
      return Position;
  }

  public void setPosition(String position) {
      Position = position;
  }

  public String getEmail() {
      return Email;
  }

  public void setEmail(String email) {
      Email = email;
  }

  public String getAddress() {
      return Address;
  }

  public void setAddress(String address) {
      Address = address;
  }

  @Override
  public String toString() {
      return "Clientlist [Id=" + Id + ", Name=" + Name + ", Position=" + Position + ", Email="
              + Email + ", Address=" + Address + "]";
  }

}
