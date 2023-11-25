package com.careyourself.careYourself.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nome;
private int idade;
private String endereco;

// getters e setters

public Long getId() {
        return id;
        }

public void setId(Long id) {
        this.id = id;
        }

public String getNome() {
        return nome;
        }

public void setNome(String nome) {
        this.nome = nome;
        }

public int getIdade() {
        return idade;
        }

public void setIdade(int idade) {
        this.idade = idade;
        }

public String getEndereco() {
        return endereco;
        }

public void setEndereco(String endereco) {
        this.endereco = endereco;
        }
        }