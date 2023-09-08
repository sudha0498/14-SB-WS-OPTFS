package com.cjc.service;

import com.cjc.entity.Book;
import com.cjc.entity.Parent;

public interface ParentService {

	Parent saveParent(Parent parent);

	boolean parentLoginCheck(String username, String password);

	Parent getSingleData(String username);

	Parent updateData(Parent parent);

	Parent deleteParent(int pid);

	
}