package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	private Integer id;
	private String name;
	private String adress;
	private Date birthDate;
	private Integer roleId;
	private Integer hobby_id;
	private Role role;
	private Hobby hobby;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "adress")
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name = "role_id")
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public Integer getHobby_id() {
		return hobby_id;
	}

	public void setHobby_id(Integer hobby_id) {
		this.hobby_id = hobby_id;
	}

	@ManyToOne
	@JoinColumn(name="role_id", referencedColumnName="id", insertable=false, updatable=false, foreignKey=@ForeignKey(name="FK_users_roles"))
	
    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@ManyToOne
	@JoinColumn(name="hobby_id", referencedColumnName="id", insertable=false, updatable=false, foreignKey=@ForeignKey(name="FK_users_hobbies"))
	
	public Hobby getHobby() {
		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", adress=" + adress + ", birthDate=" + birthDate + ", roleId="
				+ roleId + ", hobby_id=" + hobby_id + ", role=" + role + ", hobby=" + hobby + "]";
	}
}
