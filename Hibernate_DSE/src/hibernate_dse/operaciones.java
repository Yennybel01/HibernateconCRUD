/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_dse;

import desktop_app.opciones;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 *
 * @author yooo
 */
public class operaciones {

    private Session sesion;
    
    private void iniciarOperacion(){
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        sesion = sessionFactory.openSession(); 
        sesion.getTransaction().begin();
    }
    private void terminarOperacion(){
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    public void guardarEstudiante(Estudiantes estudiante){
        iniciarOperacion();
        sesion.save(estudiante);
        terminarOperacion();
    }
    public void actualizarEstudiante (Estudiantes estudiante){
        iniciarOperacion();
        sesion.update(estudiante);
        terminarOperacion();
    }
    public void eliminarEstudiante (Estudiantes estudiante){
        iniciarOperacion ();
        sesion.delete(estudiante);
        terminarOperacion();
    }
    
    public Estudiantes obtenerEstudiante (int codEst){
        Estudiantes estudiante =null;
        iniciarOperacion();
        estudiante = (Estudiantes) sesion.get(Estudiantes.class, codEst);
        terminarOperacion();
        return estudiante;
    }
    
    public List<Estudiantes> ListaDeEstudiantes(){
        List<Estudiantes> listaEstudiante = null;
        iniciarOperacion();
        listaEstudiante = sesion.createQuery("from Estudiantes").list();
        terminarOperacion();
        return listaEstudiante;
    }

    public operaciones() {
    }
    public static void main(String[] args) {
        // TODO code application logic here
         opciones v= new opciones();
        v.setVisible(true);
    }
    
}
