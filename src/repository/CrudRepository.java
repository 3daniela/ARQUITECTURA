package repository;

import java.util.List;

public interface CrudRepository<T> {

    void agregar(T objeto);

    List<T> listar();

    T buscar(int id);

    boolean eliminar(int id);

}