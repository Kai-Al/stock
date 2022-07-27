package com.udea.stock.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Null;

/**
 * @author kaiki
 */
@Entity(name = "TipoProducto")
public class TipoProducto {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    @Null(message = "id requerido")
    private Long id;
    @Basic
    @Column(nullable = false)
    @Null(message = "Tipo producto requerido")
    private String tipoProducto;
    @OneToMany(mappedBy = "tipoProducto")
    private List<Producto> productoes;

    public TipoProducto(Long id, String tipoProducto) {
        this.id = id;
        this.tipoProducto = tipoProducto;
    }

    public TipoProducto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public List<Producto> getProductoes() {
        if (productoes == null) {
            productoes = new ArrayList<>();
        }
        return productoes;
    }

    public void setProductoes(List<Producto> productoes) {
        this.productoes = productoes;
    }

    public void addProducto(Producto producto) {
        getProductoes().add(producto);
        producto.setTipoProducto(this);
    }

    public void removeProducto(Producto producto) {
        getProductoes().remove(producto);
        producto.setTipoProducto(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final TipoProducto other = (TipoProducto) obj;
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
        return "TipoProducto{" + " id=" + id + ", tipoProducto=" + tipoProducto + '}';
    }

}