package com.zjx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjx.dao.PersonDao;
import com.zjx.entity.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;

	@Transactional
	public void save(Person person) {
		personDao.save(person);
		int i = 12/0;
	}

}
