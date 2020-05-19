
package com.educacionit.student.api.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name="Student")
@Table(name="student")
public class StudentModel {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private String name;

    private String lastName;

    private String dni;

    private String email;

    private String mobile;
}