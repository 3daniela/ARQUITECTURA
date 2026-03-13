package repository;

import model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteRepository {

    private List<Estudiante> estudiantes = new ArrayList<>();

    public void guardar(Estudiante estudiante){
        estudiantes.add(estudiante);
    }

    public List<Estudiante> listar(){
        return estudiantes;
    }

    public Estudiante buscarPorId(int id){

        for(Estudiante e : estudiantes){

            if(e.getId() == id){
                return e;
            }

        }

        return null;
    }

    public boolean eliminar(int id){

        Estudiante estudiante = buscarPorId(id);

        if(estudiante != null){
            estudiantes.remove(estudiante);
            return true;
        }

        return false;
    }
    public boolean actualizar(Estudiante estudiante){

        for(int i = 0; i < estudiantes.size(); i++){

            if(estudiantes.get(i).getId() == estudiante.getId()){

                estudiantes.set(i, estudiante);
                return true;

            }
        }

        return false;
    }

    public boolean actualizarEstudiante(int id, String nombre, int edad, EstudianteRepository EstudianteRpository){

        Estudiante estudiante = new Estudiante(id,nombre,edad);

        return EstudianteRpository.actualizar(estudiante);

    }
}


