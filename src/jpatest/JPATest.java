/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpatest;
import Modelos.ModeloTablaUsuario;
import javax.persistence.*;
import persistence.Usuario;
import controladores.UsuarioJpaController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author EST1659109
 */
public class JPATest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //EntityManagerFactory administrador de entidad, abtraccion
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPATestPU");
        EntityManager em=emf.createEntityManager();
        
        UsuarioJpaController contoladorUsuario=new UsuarioJpaController(emf);
        Usuario nuevoUsuario=new Usuario();//como trabajar con una fila de la tabla
        nuevoUsuario.setId(1);
        nuevoUsuario.setNombre("Fulano");
        nuevoUsuario.setApellido("Perez");
        
        Usuario nuevoUsuario2=new Usuario();
        nuevoUsuario2.setId(2);
        nuevoUsuario2.setNombre("Persona");
        nuevoUsuario2.setApellido("Mendez");
        //insertar datos
        try{
            contoladorUsuario.create(nuevoUsuario);
            contoladorUsuario.create(nuevoUsuario2);
            
        }catch (PersistenceException ex){
           Logger.getLogger(JPATest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JPATest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Usuario> usuarios;
        
        usuarios=contoladorUsuario.findUsuarioEntities();
        ModeloTablaUsuario mtabla=new ModeloTablaUsuario(usuarios);
        Principal p= new Principal(mtabla);;
        p.setVisible(true);
        /*Query q;
        q=em.createNamedQuery("Usuario.findNombreLike");
        //'nombre' es el parametro que esta en la clase usuario ':nombre'
        q.setParameter("nombre", "F%");
        usuarios=q.getResultList();*/
        for(Usuario u:usuarios){
            System.out.println(u);
        }
        
        emf.close();//cerrar conexion con la BD para que la BD quede disponible
    }
    
}
