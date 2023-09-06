package com.cotSys.cotSys.services;

import com.cotSys.cotSys.models.Cotizacion;
import com.cotSys.cotSys.persistence.CotizacionDAO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class cotiSystemService {

    CotizacionDAO cotizacionJpa = new CotizacionDAO();
    Cotizacion cotizacion = new Cotizacion();



    //Mostrar todas las cotizaciones
    public List<Cotizacion> getCotizaciones(){
        return cotizacionJpa.getAll();
    }





    //Crear una nueva cotizacion
   // public void createCotizacion(Cotizacion nuevaCotizacion) {


  //  }

    //Modificar cotizacion
    /*public void mofidyCotizacion(Integer id){
        Cotizacion cotizacion;
        for(int i =0; i<listaCot.size();i++){
            if(listaCot.get(i).getId() == id){
                cotizacion = listaCot.get(i);
            }*/
        }

