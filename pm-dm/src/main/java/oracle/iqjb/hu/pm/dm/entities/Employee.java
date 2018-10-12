package oracle.iqjb.hu.pm.dm.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee extends IqjbEntity {
    
    private String loginName;
    private String password;
    private String firstName;
    private String lastName;
    private String title;
    private int salary;  
    
    @ManyToOne //egy departmenthez tobb ember is tartozhat
    @JoinColumn(name = "departmentId", referencedColumnName = "id")
    private Department department;    
    
    @ManyToOne //egy fonokhoz tobb ember is tartozhat
    @JoinColumn(name = "bossId", referencedColumnName = "id")
    private Employee boss;
    
    @Embedded
    private Address address;
    
    @ManyToMany
    @JoinTable(name = "EmployeeRoles", 
	joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"))
    private Set<Role> roles;

    public Employee() {
        this.roles = new HashSet<>();
    }

    public Employee(String loginName, String password, String firstName, String lastName, String title, int salary, Department department, Employee boss, Address address, Set<Role> roles) {
        this.loginName = loginName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.salary = salary;
        this.department = department;
        this.boss = boss;
        this.address = address;
        this.roles = roles;
    }
    
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }    
    
}
