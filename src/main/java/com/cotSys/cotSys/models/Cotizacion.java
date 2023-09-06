package com.cotSys.cotSys.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@Entity
@Table(name = "Cotizaciones")
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    @Getter @Setter
    private LocalDateTime date;

    @Getter @Setter
    @Column(name = "price")
    private double price;


    @Column(name = "exchange_rate")
    @Getter @Setter
    private String exchange_rate;


    public Cotizacion(int id, LocalDateTime date, double price, String exchange_rate) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.exchange_rate = exchange_rate;
    }

    public Cotizacion() {
    }

    // Método para devolver una representación en forma de cadena de la cotización
    public String toString () {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern ("yyyy-MM-dd HH:mm:ss");
        return "Cotizacion{" +
                "id=" + id +
                ", date=" + date.format(formato) +
                ", price=" + price +
                ", exchange_rate='" + exchange_rate + '\'' +
                '}';
    }
}
