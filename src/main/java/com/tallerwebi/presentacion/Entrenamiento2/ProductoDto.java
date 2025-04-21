package com.tallerwebi.presentacion.Entrenamiento2;

import java.util.Objects;

public class ProductoDto {
    private final Long id;
    private final String nombre;
    private final String descripcion;
    private final Double precio;

    public ProductoDto(Long id, String nombre, String descripcion, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductoDto that = (ProductoDto) o;
        return Objects.equals(id, that.id);
    }
}
