package ngdemo.dao;

import ngdemo.domain.Receta;

import javax.ejb.Stateless;

/**
 * Created by rodri on 10/24/2015.
 */
@Stateless
public class RecetaDao extends GenericDao{

    public void create(Receta receta) {
        entityManager.find(Receta.class,receta.getNombre());
    }
}
