package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "CLIENTES_ID")
    private int id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "CONTACTO")
    private String contacto;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "FDC")
    private String fdc;
    
}
