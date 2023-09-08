package com.cjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.entity.Parent;
import com.cjc.repository.BookRepository;
import com.cjc.repository.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService {
	@Autowired
	private ParentRepository repoParent;

	private BookRepository repoBook;

	@Override
	public Parent saveParent(Parent parent) {
		// TODO Auto-generated method stub
		return repoParent.save(parent);
	}

	@Override
	public boolean parentLoginCheck(String username, String password) {
		if (repoParent.existsByUsername(username) && repoParent.existsByPassword(password)) {
			return true;
		} else
			return false;
	}

	@Override
	public Parent getSingleData(String username) {
		// TODO Auto-generated method stub
		return repoParent.findByUsername(username);
	}

	@Override
	public Parent updateData(Parent parent) {
		// TODO Auto-generated method stub

		return repoParent.save(parent);
	}

	@Override
	public Parent deleteParent(int pid) {
		// TODO Auto-generated method stub
		if (repoParent.existsById(pid)) {
			Parent parent = repoParent.findById(pid).get();
			repoParent.delete(parent);
			return parent;

		}
		return null;
	}
	

}
