package com.udea.stock.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProductoPK implements Serializable {

    private Long id;
    private Long tipoProducto;

    public ProductoPK() {
    }

    public ProductoPK(Long id, Long tipoProducto) {
        this.id = id;
        this.tipoProducto = tipoProducto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(Long tipoProducto) {
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
        final ProductoPK other = (ProductoPK) obj;
        if (!java.util.Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        if (!java.util.Objects.equals(this.getTipoProducto(), other.getTipoProducto())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.getId());
        hash = 31 * hash + Objects.hashCode(this.getTipoProducto());
        return hash;
    }

    @Override
    public String toString() {
        return "ProductoPK{" + " id=" + id + ", tipoProducto=" + tipoProducto + '}';
    }

}