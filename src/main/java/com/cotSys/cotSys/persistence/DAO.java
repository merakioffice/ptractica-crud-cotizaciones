package com.cotSys.cotSys.persistence;

import com.cotSys.cotSys.models.Cotizacion;
import jakarta.persistence.EntityManager;

import java.util.Comparator;
import java.util.List;

public interface DAO {


    public List<Cotizacion> getAll();

    public void deleteCotizacion(int id);

    public void createCotizacion(Cotizacion cotizacion);

    public void modifyCotizacion(Cotizacion cotizacion);

    public List<Cotizacion> orderByDate();

    public List<Cotizacion> orderByPrice();

    public List<Cotizacion> orderByName();

    public List<Cotizacion> orderByRangeDate();






}
