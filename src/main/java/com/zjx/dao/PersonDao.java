package com.zjx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zjx.entity.Person;

@Repository
public class PersonDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Person person) {
		String sql = "insert into person(name, age) values(?, ?)";
		jdbcTemplate.update(sql, person.getName(), person.getAge());
	}

}
