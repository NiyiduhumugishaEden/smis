package rw.ac.rca.smis.orm;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import java.utils*;
@Entity
@Table(name="instructor")
public class Instructor extends Person{
	  
	  public Instructor( String name, Date date, char gender) {
		super( name, date, gender);
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	  @JoinColumn(name = "address_id")
	  private  Address address;
	  
	  @ManyToMany
	  @JoinTable(name = "instructor_course", joinColumns = { @JoinColumn(name = "instructor_id") }, inverseJoinColumns = { @JoinColumn(name = "course_id") })
	  private  List <Course> courses;
	  
  
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
 
   

}
