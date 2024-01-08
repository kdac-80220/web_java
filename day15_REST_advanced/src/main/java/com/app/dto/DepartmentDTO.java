package com.app.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * Add in the resp DTO : id , name location
 */
@Getter
@Setter
@ToString
public class DepartmentDTO {
	//@JsonProperty=> annotation to customize json properties
	//value: json property name
	//access:this property will be used during serilization but
	//skipped during deserilization
	@JsonProperty(value="dept_id",access = Access.READ_ONLY)
	private Long id;
	private String name;
	private String location;

}
