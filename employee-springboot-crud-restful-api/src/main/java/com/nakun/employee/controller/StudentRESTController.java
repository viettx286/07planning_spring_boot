package com.nakun.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nakun.employee.entities.Name;
import com.nakun.employee.entities.StudentV1;
import com.nakun.employee.entities.StudentV2;

@RestController
@RequestMapping("/api")
public class StudentRESTController {

	@GetMapping({"v1/students/greeting", "v2/students/greeting"})
	public String greeting() {
		return "greeting using all Rest versions";
	}

	@GetMapping("v1/students")
	public StudentV1 studentV1() {
		return new StudentV1("Bob Charlie");
	}

	@GetMapping("v2/students")
	public StudentV2 studentV2() {
		return new StudentV2(new Name("Bob", "Charlie"));
	}

}