package com.pm.login_20.Model;

public class Empleado {
    private Long id;
    private String correo;
    private String nombre;
    private String password;

    public Empleado() {
    }

    public Empleado(Long id, String correo, String nombre, String password) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
