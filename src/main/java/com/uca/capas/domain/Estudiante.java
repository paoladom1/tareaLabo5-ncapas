package com.uca.capas.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(schema = "public", name="estudiante")
public class Estudiante {
    @Id
    @Column(name="c_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cUsuario;

    @Column(name="nombre")
    private String Nombre;

    @Column(name="apellido")
    private String Apellido;

    @Column(name="carne")
    private String Carne;

    @Column(name="carrera")
    private String Carrera;

    public Estudiante() {
    }

    public Integer getcUsuario() {
        return cUsuario;
    }

    public void setcUsuario(Integer cUsuario) {
        this.cUsuario = cUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCarne() {
        return Carne;
    }

    public void setCarne(String carne) {
        Carne = carne;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }
}
