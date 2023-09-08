package com.cjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.entity.Parent;
import com.cjc.service.ParentService;

@RestController
@RequestMapping("/parent-service")
public class ParentController {

	@Autowired
	private ParentService parentService;

	@GetMapping("/")
	public String Welcome() {
		return "Welcome to parent login";
	}

	@PostMapping("/saveParent")
	public String saveParent(@RequestBody Parent parent) {
		parentService.saveParent(parent);

		return "Parent save";
	}

	@GetMapping("/parentLogin/{username}/{password}")
	public ResponseEntity<String> parentLoginCheck(@PathVariable String username, @PathVariable String password) {
		boolean b = parentService.parentLoginCheck(username, password);
		if (b) {
			return new ResponseEntity<String>("login succes", HttpStatus.ACCEPTED);
		} else
			return new ResponseEntity<String>("invalid credentials", HttpStatus.NON_AUTHORITATIVE_INFORMATION);

	}

	@PutMapping("/saveParent")
	public ResponseEntity<String> updateParentDetails(@RequestBody Parent parent) {

		parentService.updateData(parent);

		return new ResponseEntity<String>("Parent Data Updated", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteParent/{pid}")
	public ResponseEntity<Parent> deleteParent(@PathVariable int pid) {
		return new ResponseEntity<Parent>(parentService.deleteParent(pid), HttpStatus.OK);
	}
}
