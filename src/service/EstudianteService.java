package service;

import model.Estudiantes;
import repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class EstudianteService implements CrudRepository<Estudiantes> {

    private List<Estudiantes> lista = new ArrayList<>();

    @Override
    public void agregar(Estudiantes e) {
        lista.add(e);
    }

    @Override
    public List<Estudiantes> listar() {
        return lista;
    }

    @Override
    public Estudiantes
    buscar(int id) {

        for(Estudiantes e : lista){

            if(e.getId() == id){
                return e;
            }

        }

        return null;
    }

    @Override
    public boolean eliminar(int id) {

        Estudiantes e = buscar(id);

        if(e != null){
            lista.remove(e);
            return true;
        }

        return false;
    }

}