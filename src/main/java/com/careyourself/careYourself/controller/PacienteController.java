package com.careyourself.careYourself.controller;

import com.careyourself.careYourself.model.Paciente;
import com.careyourself.careYourself.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente != null) {
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente createdPaciente = pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente existingPaciente = pacienteRepository.findById(id).orElse(null);
        if (existingPaciente != null) {
            paciente.setId(id);
            Paciente updatedPaciente = pacienteRepository.save(paciente);
            return ResponseEntity.ok(updatedPaciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente != null) {
            pacienteRepository.delete(paciente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}