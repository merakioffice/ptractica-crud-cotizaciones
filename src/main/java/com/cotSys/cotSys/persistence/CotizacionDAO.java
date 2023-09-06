package com.cotSys.cotSys.persistence;
import com.cotSys.cotSys.models.Cotizacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class CotizacionDAO implements DAO{

    @PersistenceContext
   EntityManager em;



    @Override
    public List<Cotizacion> getAll() {
        String query = "FROM Cotizacion";
        return em.createQuery(query).getResultList();
    }

    @Override
    public void deleteCotizacion(int id) {
        Cotizacion cotizacion = em.find(Cotizacion.class,id);

       em.remove(cotizacion);
    }

    @Override
    public void createCotizacion(Cotizacion cotizacion) {

        em.merge(cotizacion);
    }

    @Override

    public void modifyCotizacion(Cotizacion cotizacion) {

        Cotizacion coti = em.find(Cotizacion.class, cotizacion.getId());

        coti.setDate(cotizacion.getDate());
        coti.setPrice(cotizacion.getPrice());
        coti.setExchange_rate(cotizacion.getExchange_rate());

        em.persist(coti);
    }


    @Override
    public List<Cotizacion> orderByDate() {
        String query = "FROM Cotizacion order by date asc";
        return em.createQuery(query).getResultList();
    }

    @Override
    public List<Cotizacion> orderByPrice() {
        String query = "FROM Cotizacion order by price asc";
        return em.createQuery(query).getResultList();
    }

    @Override
    public List<Cotizacion> orderByName() {
        String query = "FROM Cotizacion order by date asc";
        return em.createQuery(query).getResultList();
    }

    @Override
    public List<Cotizacion> orderByRangeDate(String fecha) {
        //String query ="FROM Cotizacion WHERE date BETWEEN 'start_date' AND 'end_date'";
        String query = "FROM Cotizacion WHERE date > :date";
        List<Cotizacion> cotizaciones = em.createQuery(query, Cotizacion.class)
                .setParameter("date", fecha)
                .getResultList();
        return em.createQuery(query).getResultList();
    }


   /* public static Comparator<Cotizacion> ordenar = new Comparator<Cotizacion>() {
        @Override
        public int compare(Cotizacion t, Cotizacion t1) {
            return t.getDate().compareTo(t1.getDate());
        }
    };*/


}
