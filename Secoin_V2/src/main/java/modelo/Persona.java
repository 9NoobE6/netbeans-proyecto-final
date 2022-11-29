package modelo;

/**
 *
 * @author ruben
 */

public class Persona{
    private int idpersona;
    public String nombre_completo;
    public String num_telefonico;
    public String dnipersona;

    public Persona(){}

    public Persona(int idpersona, String nombre_completo, String num_telefonico, String dnipersona) {
        this.idpersona = idpersona;
        this.nombre_completo = nombre_completo;
        this.num_telefonico = num_telefonico;
        this.dnipersona = dnipersona;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getNum_telefonico() {
        return num_telefonico;
    }

    public void setNum_telefonico(String num_telefonico) {
        this.num_telefonico = num_telefonico;
    }

    public String getDnipersona() {
        return dnipersona;
    }

    public void setDnipersona(String dnipersona) {
        this.dnipersona = dnipersona;
    }

    
    
}
