package com.examen.lab1.services;
import java.util.List;
import com.examen.lab1.model.Habitacion;


public interface IHabService {
	List<Habitacion> GetAllHabitacion();
	Habitacion saveHab(Habitacion entity);
	Habitacion findHabById(int id);
	Habitacion updateHab(int id, Habitacion entity);
	void deleteHab(int id);
}
