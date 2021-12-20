/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo_servicio;
    
    @Basic
    private String nombre;
    private String descripcion;
    private String destino_servicio;
    private Date fecha_servicio;
    private double costo_servicio;
    private boolean habilitado;


    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "listaServicios")
    private List<Paquete> listaPaquetes = new ArrayList<>();
    
    
    
     @OneToMany(mappedBy = "servicio")
     private List<Venta> listaVentas = new ArrayList<>() ;
    
    
    
    public Servicio() {

    }

    public Servicio(String nombre, String descripcion, String destino_servicio, Date fecha_servicio, double costo_servicio, boolean habilitado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.destino_servicio = destino_servicio;
        this.fecha_servicio = fecha_servicio;
        this.costo_servicio = costo_servicio;
        this.habilitado = habilitado;
    }

    
    
    

    public int getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(int codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDestino_servicio() {
        return destino_servicio;
    }

    public void setDestino_servicio(String destino_servicio) {
        this.destino_servicio = destino_servicio;
    }

    public Date getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(Date fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    public double getCosto_servicio() {
        return Math.floor(costo_servicio *100) / 100;
    }

    public void setCosto_servicio(double costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public List<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<Paquete> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Servicio{" + "codigo_servicio=" + codigo_servicio + ", nombre=" + nombre + ", descripcion=" + descripcion + ", destino_servicio=" + destino_servicio + ", fecha_servicio=" + fecha_servicio + ", costo_servicio=" + costo_servicio + ", habilitado=" + habilitado + '}';
    }
    
    
    

    
    
}
