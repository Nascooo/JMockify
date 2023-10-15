package com.main.jmockify.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "STUDENT")
@Data
@NoArgsConstructor
public class Student {

	@Id
	private Integer id;

	private String name;

	private String address;

}
