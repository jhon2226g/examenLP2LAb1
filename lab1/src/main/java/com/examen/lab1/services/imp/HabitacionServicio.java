package com.examen.lab1.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.lab1.model.Habitacion;
import com.examen.lab1.repository.IHabRepository;
import com.examen.lab1.services.IHabService;

@Service
public class HabitacionServicio implements IHabService {

	@Autowired
	
	IHabRepository _habitaRepository;
	
	
	public HabitacionServicio(IHabRepository habitacionRepository) {
		_habitaRepository = habitacionRepository;
	}
	
	@Override
	public List<Habitacion> GetAllHabitacion() {
		return _habitaRepository.findAll();
	}

	@Override
	public Habitacion saveHab(Habitacion entity) {
		return _habitaRepository.save(entity);
	}


	@Override
	public Habitacion findHabById(int id) {
		Optional<Habitacion> row = _habitaRepository.findById(id);
		if(row.isPresent())
			return row.get();
		return new Habitacion();
	}

	@Override
	public Habitacion updateHab(int id, Habitacion entity) {
		Optional<Habitacion> row = _habitaRepository.findById(id);
		if(row.isPresent()) {
			row.get().setPrecioHora(entity.getPrecioHora());
			row.get().setTipo(entity.getTipo());
			_habitaRepository.save(row.get());
			return row.get();
		}
		else
		return new Habitacion();	
	}

	@Override
	public void deleteHab(int id) {
		 _habitaRepository.deleteById(id);
	}

}
