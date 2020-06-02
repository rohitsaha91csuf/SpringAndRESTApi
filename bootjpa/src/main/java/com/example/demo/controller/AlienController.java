package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;

/*	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		repo.save(alien);
		
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView addAlien(@RequestParam int aid) {
		
		ModelAndView mv=new ModelAndView("showAlien.jsp");
		Alien alien =repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		
		System.out.println(repo.findByTech("java"));
		
		System.out.println(repo.findByTechSorted("java"));
		
		
		return mv;
	}*/
	
	//REST API//
	
	//@RequestMapping(path= "/aliens",produces= {"application/xml"})
	@RequestMapping(path= "/aliens")
	//@ResponseBody(mention controlled as rest controller)
	public List<Alien> getAliens() {
		
		
		return repo.findAll();
	}
	
	@GetMapping(path="/alien/{aid}", produces= {"application/json"})
	//@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		
		return repo.findById(aid);
	}
	
	@PostMapping(path="/alien",consumes= {"application/json"})
	public Alien addAlien(@RequestBody Alien alien) {
		
		repo.save(alien);
		
		return alien;
	}
	
	@DeleteMapping(path="/alien/{aid}")
	public Optional<Alien> deleteAlien(@PathVariable("aid") int id) {
		
		Optional<Alien> a = repo.findById(id);
		
		repo.deleteById(id);
		
		return a;
	}
	@PutMapping(path="/alien",consumes= {"application/json"})
	public Alien addOrUpdateAlien(@RequestBody Alien alien) {
		
		repo.save(alien);
		
		return alien;
	}
	
	
}
