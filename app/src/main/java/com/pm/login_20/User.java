package com.pm.login_20;

public class User {
    public String nombre;
    public String apellido;
    public int edad;
    public String pais;
    public String estado;
    public String email;
    public String password;
    public String verify_password;
    public String token;
    public String code;
    public String status;
    public String newPassword;

    public User() {
    }

    public User(String nombre, String apellido, int edad, String pais, String estado,
                String email, String password, String verify_password, String token,
                String code, String status, String newPassword) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pais = pais;
        this.estado = estado;
        this.email = email;
        this.password = password;
        this.verify_password = verify_password;
        this.token = token;
        this.code = code;
        this.status = status;
        this.newPassword = newPassword;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify_password() {
        return verify_password;
    }

    public void setVerify_password(String verify_password) {
        this.verify_password = verify_password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
