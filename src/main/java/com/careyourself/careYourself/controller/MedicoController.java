package com.careyourself.careYourself.controller;

import com.careyourself.careYourself.model.Medico;
import com.careyourself.careYourself.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable Long id) {
        Medico medico = medicoRepository.findById(id).orElse(null);
        if (medico != null) {
            return ResponseEntity.ok(medico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Medico> createMedico(@RequestBody Medico medico) {
        Medico createdMedico = medicoRepository.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Long id, @RequestBody Medico medico) {
        Medico existingMedico = medicoRepository.findById(id).orElse(null);
        if (existingMedico != null) {
            medico.setId(id);
            Medico updatedMedico = medicoRepository.save(medico);
            return ResponseEntity.ok(updatedMedico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.findById(id).orElse(null);
        if (medico != null) {
            medicoRepository.delete(medico);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}