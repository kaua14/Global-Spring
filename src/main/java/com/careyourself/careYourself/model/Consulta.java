package com.careyourself.careYourself.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Consulta {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private LocalDate data;
private String descricao;

@ManyToOne
private Paciente paciente;

@ManyToOne
private Medico medico;

// getters e setters

public Long getId() {
        return id;
        }

public void setId(Long id) {
        this.id = id;
        }

public LocalDate getData() {
        return data;
        }

public void setData(LocalDate data) {
        this.data = data;
        }

public String getDescricao() {
        return descricao;
        }

public void setDescricao(String descricao) {
        this.descricao = descricao;
        }

public Paciente getPaciente() {
        return paciente;
        }

public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
        }

public Medico getMedico() {
        return medico;
        }

public void setMedico(Medico medico) {
        this.medico = medico;
        }
        }