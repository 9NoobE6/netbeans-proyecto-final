/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ruben
 */
public class Usuario extends Persona{
    private String idusuario;
    private Persona persona;
    private String usuario;
    private String contraseña;

    public Usuario() {}

    public Usuario(String idusuario, Persona persona, String usuario, String contraseña, int idpersona, String nombre_completo, String num_telefonico, String dnipersona) {
        super(idpersona, nombre_completo, num_telefonico, dnipersona);
        this.idusuario = idusuario;
        this.persona = persona;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //sobrecarga de metodos por Herencia 
    
    @Override
    public String getNombre_completo() {
        return nombre_completo;
    }

    @Override
    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    @Override
    public String getNum_telefonico() {
        return num_telefonico;
    }

    @Override
    public void setNum_telefonico(String num_telefonico) {
        this.num_telefonico = num_telefonico;
    }
    
    @Override
    public String getDnipersona() {
        return dnipersona;
    }

    @Override
    public void setDnipersona(String dnipersona) {
        this.dnipersona = dnipersona;
    }
    
}
