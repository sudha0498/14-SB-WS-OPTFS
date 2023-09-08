package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.entity.Admin;
import com.cjc.entity.Book;
import com.cjc.entity.Tutor;
import com.cjc.service.AdminService;

@RestController
@RequestMapping("/admin-service")
public class AdminController {

	@Autowired
	private AdminService service;

	@GetMapping("/")
	public String Welcome() {
		return "Welcome to Admin Page";
	}

	@PostMapping("/saveAdmin")
	public String saveAdmin(@RequestBody Admin admin) {
		service.saveAdmin(admin);

		return "adminsave";

	}

	@GetMapping("/adminlogin/{username}/{password}")
	public String loginCheck(@PathVariable String username, @PathVariable String password) {
		boolean b = service.logincheck(username, password);
		if (b) {
			service.getSingledata(username);
			return "Admin login Successfull";

		} else
			return "invalid username, password";
	}

//	public RequestEntity<Book> saveBook(@RequestBody Book book) {
//
//		return new RequestEntity<Book>(service.addBook(book), HttpStatus.CREATED);
//	}
	@PostMapping("/saveBook")
	public String saveBook(@RequestBody Book book) {
		service.addBook(book);

		return "Book Save";
	}

	@DeleteMapping("/deleteBook/{bId}")
	public ResponseEntity<Book> deleteBook(@PathVariable int bId) {
		return new ResponseEntity<Book>(service.delete(bId), HttpStatus.OK);
	}

	@PutMapping("/saveBook/{bid}")
	public ResponseEntity<String> updateBookDetails(@RequestBody Book book, @PathVariable int bid) {
		service.updateBook(book, bid);

		return new ResponseEntity<String>("Book details Updated", HttpStatus.ACCEPTED);
	}

	@PostMapping("/saveTutor")
	public ResponseEntity<String> addTutor(@RequestBody Tutor tutor) {
		Tutor addTutor = service.addTutor(tutor);

		if (addTutor != null) {
			return new ResponseEntity<String>("Tutor Added", HttpStatus.CREATED);
		} else
			return new ResponseEntity<String>("Tutor not added", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/viewAllTutorDetails")
	public ResponseEntity<List<Tutor>> viewAllTutor() {
		List<Tutor> allTutor = service.viewAllTutor();

		return new ResponseEntity<List<Tutor>>(allTutor, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateTutorDetails/{tid}")
	public ResponseEntity<String> updateTutorDetails(@RequestBody Tutor tutor, @PathVariable int tid) {
		service.updateTutor(tutor, tid);

		return new ResponseEntity<String>("Tutor Details are Updated", HttpStatus.OK);

	}

}
