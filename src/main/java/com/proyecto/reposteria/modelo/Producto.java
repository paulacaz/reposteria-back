package com.proyecto.reposteria.modelo;

import jakarta.persistence.*;

@Entity(name = "producto")
public class Producto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;
        private String nombre;
        private String descripcion;
        private String imagen;
        private double precio;
        private int stock;
        @ManyToOne
        private Categoria categoria;

        public Producto() {
        }

        public Producto(Long id, String nombre, String descripcion, String imagen, double precio, int stock, Categoria categoria) {
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.imagen = imagen;
            this.precio = precio;
            this.stock = stock;
            this.categoria = categoria;
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

        public String getImagen() {
            return imagen;
        }

        public double getPrecio() {
            return precio;
        }

        public int getStock() {
            return stock;
        }

        public Categoria getCategoria() {
            return categoria;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }
}
