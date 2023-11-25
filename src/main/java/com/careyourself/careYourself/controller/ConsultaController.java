package com.careyourself.careYourself.controller;

import com.careyourself.careYourself.model.Consulta;
import com.careyourself.careYourself.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable Long id) {
        Consulta consulta = consultaRepository.findById(id).orElse(null);
        if (consulta != null) {
            return ResponseEntity.ok(consulta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Consulta> createConsulta(@RequestBody Consulta consulta) {
        Consulta createdConsulta = consultaRepository.save(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConsulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> updateConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        Consulta existingConsulta = consultaRepository.findById(id).orElse(null);
        if (existingConsulta != null) {
            consulta.setId(id);
            Consulta updatedConsulta = consultaRepository.save(consulta);
            return ResponseEntity.ok(updatedConsulta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        Consulta consulta = consultaRepository.findById(id).orElse(null);
        if (consulta != null) {
            consultaRepository.delete(consulta);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}