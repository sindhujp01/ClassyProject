package com.niit.classybackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Authentication {
	@Id
private String roleid;

private String rolename="ROLE_USER";
private String username;

public Authentication()
{
	this.roleid="AUTH"+UUID.randomUUID().toString().substring(30).toUpperCase();
}

public String getRoleid() {
	return roleid;
}

public void setRoleid(String roleid) {
	this.roleid = roleid;
}

public String getRolename() {
	return rolename;
}

public void setRolename(String rolename) {
	this.rolename = rolename;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

}
