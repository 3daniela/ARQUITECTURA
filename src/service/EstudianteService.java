package service;

import model.Estudiante;
import repository.EstudianteRepository;

import java.util.List;

public class EstudianteService {

    private EstudianteRepository repository = new EstudianteRepository();

    public void crearEstudiante(int id, String nombre, int edad) {
        Estudiante estudiante = new Estudiante(id, nombre, edad);
        repository.guardar(estudiante);
    }

    public List<Estudiante> listarEstudiantes() {
        return repository.listar();
    }

    public Estudiante buscarEstudiante(int id) {
        return repository.buscarPorId(id);
    }

    public boolean eliminarEstudiante(int id) {
        return repository.eliminar(id);
    }

    public boolean actualizarEstudiante(int idAct, String nombreAct, int edadAct) {

        return false;
    }

}
