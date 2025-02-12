package com.spring.ems.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manager {
	@Id
	private String managerid;
	private int empID;
	private int workclass;
	/*
	 * @OneToMany(mappedBy="manager", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 * private List<Employee> empList;
	 */
}
