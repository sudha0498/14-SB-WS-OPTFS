package com.cjc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cjc.entity.Admin;
import com.cjc.entity.Book;
import com.cjc.entity.Tutor;
import com.cjc.repository.AdminReopository;
import com.cjc.repository.BookRepository;
import com.cjc.repository.TutorRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminReopository repo;
	@Autowired
	private BookRepository repoBook;
	@Autowired
	private TutorRepository repoTutor;
	@Autowired
	private JavaMailSender sender;

	@Override
	public Admin saveAdmin(Admin admin) {

		return repo.save(admin);
	}

	@Override
	public boolean logincheck(String username, String password) {
		if (repo.existsByUsername(username) && (repo.existsByPassword(password))) {
			return true;
		} else
			return false;

	}

	@Override
	public Admin getSingledata(String username) {
		// TODO Auto-generated method stub
		return repo.findByUsername(username);
	}

	public Book addBook(Book book) {
		return repoBook.save(book);
	}

	@Override
	public Book delete(int bId) {
		// TODO Auto-generated method stub
		if (repoBook.existsById(bId)) {
			Book book = repoBook.findById(bId).get();
			repoBook.delete(book);
			return book;
		} else

			return null;
	}

	@Override
	public Book updateBook(Book book, int bid) {
		// TODO Auto-generated method stub
		if (repoBook.existsById(bid)) {
			Book save = repoBook.save(book);
			return save;
		} else
			return null;
	}

	@Override
	public Tutor addTutor(Tutor tutor) {
		// TODO Auto-generated method stub
		Tutor tutor1 = repoTutor.save(tutor);

		SimpleMailMessage massage = new SimpleMailMessage();
		massage.setFrom("sudhanshuraut1998@gmail.com");
		massage.setTo(tutor1.getTemailId());
		massage.setSubject("profile register");
		massage.setText("Hi sir,\nYour Profile Added in our Online Tutor System \n" + "Username::"
				+ tutor.getTusername() + "\n" + "Password::" + tutor1.getTpassword() + "\n"
				+ "You can Login to our Website using this username and password\n Thank You!\n"
				+ "Regards Online Tutor Team");
		sender.send(massage);
		System.out.println("Tutor added Successfully");

		return tutor1;
	}

	@Override
	public List<Tutor> viewAllTutor() {

		List<Tutor> list = repoTutor.findAll();
		System.out.println("tutor details retraive succesfully");

		return list;
	}

	@Override
	public Tutor updateTutor(Tutor tutor, int tid) {
		if (repoTutor.existsById(tid)) {
			Tutor updateTutor = repoTutor.save(tutor);
			return updateTutor;
		} else
			return null;
	}

}
