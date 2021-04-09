package com.example.productosparcial;

public class Producto {
    String nombre;
    String codigo;
    int valor;
    boolean isExcento;
    String descripcion;
    String categoria;

    public Producto(String nombre, String codigo, int valor, boolean isExcento, String descripcion, String categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.valor = valor;
        this.isExcento = isExcento;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isExcento() {
        return isExcento;
    }

    public void setExcento(boolean excento) {
        isExcento = excento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", valor=" + valor +
                ", isExcento=" + isExcento +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
