package com.eventoapp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eventoapp.model.Evento;
import com.eventoapp.repository.EventoRepository;

@Service
public class EventoService {
	@Autowired
	private EventoRepository eventoRepository;

	public Evento atualizar(Long id, Evento evento) {
		Evento eventoSalvo = eventoRepository.findOne(id);
		if (eventoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(evento, eventoSalvo, "codigo");
		return eventoRepository.save(eventoSalvo);
	}
}
