package com.example;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class FtBootStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtBootStarterApplication.class, args);
	}
}
@Component
class FtCLRunner implements CommandLineRunner{
	@Override
	public void run(String... arg0) throws Exception {
		personRepository.findAll().forEach(System.out::println);
	}
	
	@Autowired
	PersonRepository personRepository;
}

@RestController
class PersonRestController{
	@Autowired
	PersonRepository personRepository;
	@RequestMapping(path="/")
	public List<Person> getAllPerson1(){
		return getAllPerson();
	}
	@RequestMapping(path="/allPerson")
	public List<Person> getAllPerson(){
		return personRepository.findAll();
	}
} 

interface PersonRepository extends JpaRepository<Person, Long>{
	
}

@Entity
class Person{
	@Id @GeneratedValue
	private Long id;
	private String name;
	
	public Person(){
		
	}
	public Person(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	
}