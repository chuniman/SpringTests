
package com.educacionit.student.api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.student.api.model.StudentModel;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping ("students")
public class StudentController {

	@GetMapping(value = "/all")
    //@RequestMapping (method = RequestMethod.GET)
    public ResponseEntity<?> getAll () {


        List<StudentModel> list = new ArrayList<>();

        list.add (new StudentModel ("Homer", "Simpson", "90909098", "hsimpson@gmail.com", "1512121212"));
        list.add (new StudentModel ("Bart", "Simpson", "90909046", "bsimpson@gmail.com", "1515121213"));


        return ResponseEntity.ok(list);
    }

}