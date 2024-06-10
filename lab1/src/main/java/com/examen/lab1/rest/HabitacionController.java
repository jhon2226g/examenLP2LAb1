package com.examen.lab1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import com.examen.lab1.model.Habitacion;
import com.examen.lab1.services.IHabService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class HabitacionController {
	
	@Autowired
	IHabService HabitacionServicio;
	public HabitacionController( IHabService HabitacionServicio) {
		this.HabitacionServicio = HabitacionServicio;
	}
	
	@GetMapping("/habs")
	public List<Habitacion> getAll() {
		return HabitacionServicio.GetAllHabitacion();
	}
		
	@GetMapping("/hab/{id}")
	public Habitacion getHab(@PathVariable int id) {
		return HabitacionServicio.findHabById(id);
	}
	
	@PostMapping("/hab")
	public Habitacion savehab(@RequestBody Habitacion entity) {
		return HabitacionServicio.saveHab(entity);
	}
	
	@PutMapping("/habUp/{id}")
	public Habitacion putHab(@PathVariable int id, @RequestBody Habitacion entity) {
		return HabitacionServicio.updateHab(id, entity);
	}
	
	@DeleteMapping("/habDel/{id}")
	public void delHab(@PathVariable int id) {
		HabitacionServicio.deleteHab(id);
	}
		
}
