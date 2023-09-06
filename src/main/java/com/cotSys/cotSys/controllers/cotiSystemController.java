package com.cotSys.cotSys.controllers;

import com.cotSys.cotSys.models.Cotizacion;
import com.cotSys.cotSys.persistence.CotizacionDAO;
import com.cotSys.cotSys.services.cotiSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class cotiSystemController {
cotiSystemService cotSys = new cotiSystemService();

@Autowired
CotizacionDAO cotizacionDAO;


    @RequestMapping(value = "api/cotizaciones", method = RequestMethod.GET)
    public List<Cotizacion> getAllValues(){

        return cotizacionDAO.getAll();
    }

    @RequestMapping(value = "api/cotizaciones/{id}", method = RequestMethod.DELETE)
    public void deleteCotizacion(@PathVariable int id){

        cotizacionDAO.deleteCotizacion(id);

    }

    @RequestMapping(value = "api/cotizaciones", method = RequestMethod.POST)
    public void createCotizacion(@RequestBody Cotizacion cotizacion){

        cotizacionDAO.createCotizacion(cotizacion);
    }

    @RequestMapping(value ="api/cotizaciones/{id}",method = RequestMethod.PUT)
    public void modifyCotizacion(@RequestBody Cotizacion cotizacion,@PathVariable int id){

        cotizacion.setId(id);

        cotizacionDAO.modifyCotizacion(cotizacion);

    }

    @RequestMapping(value="api/cotizaciones/orderDateQuery",method = RequestMethod.GET)
    public List<Cotizacion> getForDateQuery(){
        return cotizacionDAO.orderByDate();
    }

    @RequestMapping(value="api/cotizaciones/orderPriceQuery",method = RequestMethod.GET)
    public List<Cotizacion> getForPriceQuery(){
        return cotizacionDAO.orderByPrice();
    }
    @RequestMapping(value="api/cotizaciones/orderNameQuery",method = RequestMethod.GET)
    public List<Cotizacion> getForNameQuery(){
        return cotizacionDAO.orderByName();
    }




    /*@RequestMapping(value="api/cotizaciones/orderDate",method = RequestMethod.GET)
    public List<Cotizacion> getForDate(){
        List<Cotizacion> o = cotizacionDAO.getAll();

        Collections.sort(o,cotizacionDAO.ordenar);

        return o;

    }*/




}


