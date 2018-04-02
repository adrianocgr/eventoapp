package com.eventoapp.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventoapp.model.Evento;
import com.eventoapp.repository.EventoRepository;
import com.eventoapp.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoResource {

	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	EventoService eventoService;

	@GetMapping
	public List<Evento> listar() {
		return eventoRepository.findAll();
	}

	@PostMapping
	public Evento salvar(@RequestBody @Valid Evento evento) {
		return eventoRepository.save(evento);
	}

	@GetMapping("/{id}")
	public Evento buscarPeloId(@PathVariable Long id) {
		return eventoRepository.findOne(id);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		eventoRepository.delete(id);
	}
	
	@PutMapping("/{id}")
	public Evento atualizar(@PathVariable Long id, @Valid @RequestBody Evento evento) {
		return eventoService.atualizar(id, evento);
	}

}
