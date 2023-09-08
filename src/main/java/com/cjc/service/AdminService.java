package com.cjc.service;

import java.util.List;

import com.cjc.entity.Admin;
import com.cjc.entity.Book;
import com.cjc.entity.Tutor;

public interface AdminService {

	Admin saveAdmin(Admin admin);

	boolean logincheck(String username, String password);

	Admin getSingledata(String username);

	Book addBook(Book book);

	Book delete(int bId);

	Book updateBook(Book book, int bid);

	Tutor addTutor(Tutor tutor);

	List<Tutor> viewAllTutor();

	Tutor updateTutor(Tutor tutor, int tid);

}
