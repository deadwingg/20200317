package edu.educacionit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TablaB")
public class B {
    @Id
    @Column(name="id")
    public String id;
    @Column(name="nombre")
    public String nombre;

    public B(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
