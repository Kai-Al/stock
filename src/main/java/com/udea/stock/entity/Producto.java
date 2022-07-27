package com.udea.stock.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author kaiki
 */

@Entity
@IdClass(ProductoPK.class)
@NamedQuery(name = "Producto.findAll", query = "Select e from Producto e")
@NamedQuery(name = "Producto.findByNombre", query = "Select p from Producto p where p.nombre=:nombre")
@NamedQuery(name = "Producto.findByFechaIngreso", query = "Select p from Producto p where p.fechaIngreso=:fechaIngreso")
@NamedQuery(name = "Producto.findByPrecio", query = "Select p from Producto p where p.precio=:precio")
@NamedQuery(name = "Producto.findByCantidadDisponible", query = "Select p from Producto p where p.cantidadDisponible=:cantidadDisponible")
@NamedQuery(name = "Producto.findByDescripcion", query = "Select p from Producto p where p.descripcion=:descripcion")
@NamedQuery(name = "Producto.findByEmailProveedor", query = "Select p from Producto p where p.emailProveedor=:emailProveedor")
public class Producto implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @NotNull(message = "Id requerido")
    private Long id;
    @Basic
    @Column(name = "nombre", nullable = false)
    @NotNull(message = "nombre requerido")
    private String nombre;
    @Basic
    @Column(name = "fechaIngreso", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Fecha requerida")
    @PastOrPresent(message = "Debe ingresar una fecha igual o anterior a la acutal")
    private Date fechaIngreso;
    @Basic
    @Column(name = "precio", nullable = false)
    @NotNull(message = "Precio requerido")
    @PositiveOrZero(message = "Ingrese un valor igual o superior a 0")
    private Double precio;
    @Basic
    @Column(name = "cantidadDisponible", nullable = false)
    @NotNull(message = "Cantidad requerida")
    @Max(value = 1000, message = "El valor mÃ¡ximo es 1000 productos")
    @PositiveOrZero(message = "Debe ingresar valores positivos o cero")
    private int cantidadDisponible;
    @Basic
    @Column(name = "descripcion", nullable = false)
    @NotNull(message = "DescripciÃ³n requerida")
    private String descripcion;
    @Basic
    @Column(name = "emailProveedor", nullable = false)
    @NotNull(message = "Email Requerido")
    //@Email(regexp = ".+[@].+[\\.].+ ", message = "Email en formato invalido ")
    private String emailProveedor;
    @Id
    @ManyToOne
    private TipoProducto tipoProducto;

    public Producto(Long id, String nombre, Date fechaIngreso, Double precio, int cantidadDisponible, String descripcion, String emailProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.descripcion = descripcion;
        this.emailProveedor = emailProveedor;
    }

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!java.util.Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public String toString() {
        return "Producto{" + " id=" + id + ", nombre=" + nombre + ", fechaIngreso=" + fechaIngreso + ", precio=" + precio + ", cantidadDisponible=" + cantidadDisponible + ", descripcion=" + descripcion + ", emailProveedor=" + emailProveedor + '}';
    }

}