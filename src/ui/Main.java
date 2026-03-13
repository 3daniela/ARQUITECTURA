package ui;

import model.Estudiante;
import service.EstudianteService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EstudianteService service = new EstudianteService();

        int opcion;

        do{
            System.out.println("1 Crear estudiante");
            System.out.println("2 Listar estudiantes");
            System.out.println("3 Buscar estudiante");
            System.out.println("4 Actualizar estudiante");
            System.out.println("5 Eliminar estudiante");
            System.out.println("6 Salir");

            opcion = scanner.nextInt();

            switch (opcion){

                case 1:
                    System.out.println("ID: ");
                    System.out.print("ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();

                    service.crearEstudiante(id,nombre,edad);

                    System.out.println("Estudiante creado");

                    break;

                case 2:

                    List<Estudiante> lista = service.listarEstudiantes();

                    for(Estudiante e : lista){
                        System.out.println(e);
                    }

                    break;


                case 3:

                    System.out.print("Ingrese ID: ");
                    int idBuscar = scanner.nextInt();

                    Estudiante estudiante = service.buscarEstudiante(idBuscar);

                    if(estudiante != null){
                        System.out.println(estudiante);
                    }else{
                        System.out.println("No encontrado");
                    }

                    break;


                case 4:

                    System.out.print("ID del estudiante: ");
                    int idAct = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nombreAct = scanner.nextLine();

                    System.out.print("Nueva edad: ");
                    int edadAct = scanner.nextInt();

                    boolean actualizado = service.actualizarEstudiante(idAct,nombreAct,edadAct);

                    if(actualizado){
                        System.out.println("Estudiante actualizado");
                    }else{
                        System.out.println("Estudiante no encontrado");
                    }

                    break;

            }

        }while(opcion != 5);

    }

}