package ui;

import model.Estudiantes;
import service.EstudianteService;

import javax.swing.*;
import java.awt.*;

public class VentanaEstudiantes extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextArea area;

    private EstudianteService service = new EstudianteService();

    public VentanaEstudiantes(){

        setTitle("CRUD Estudiantes");
        setSize(400,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("ID"));
        txtId = new JTextField(10);
        add(txtId);

        add(new JLabel("Nombre"));
        txtNombre = new JTextField(10);
        add(txtNombre);

        add(new JLabel("Edad"));
        txtEdad = new JTextField(10);
        add(txtEdad);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnListar = new JButton("Listar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnEliminar = new JButton("Eliminar");

        add(btnAgregar);
        add(btnListar);
        add(btnBuscar);
        add(btnEliminar);

        area = new JTextArea(10,30);
        add(area);


        btnAgregar.addActionListener(e -> {

            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());

            Estudiantes est = new Estudiantes(id,nombre,edad);

            service.agregar(est);

            area.setText("Estudiante agregado");

        });


        btnListar.addActionListener(e -> {

            area.setText("");

            for(Estudiantes est : service.listar()){
                area.append(est + "\n");
            }

        });


        btnBuscar.addActionListener(e -> {

            int id = Integer.parseInt(txtId.getText());

            Estudiantes est = service.buscar(id);

            if(est != null){
                area.setText(est.toString());
            }else{
                area.setText("No encontrado");
            }

        });


        btnEliminar.addActionListener(e -> {

            int id = Integer.parseInt(txtId.getText());

            boolean eliminado = service.eliminar(id);

            if(eliminado){
                area.setText("Estudiante eliminado");
            }else{
                area.setText("No encontrado");
            }

        });

    }

    public static void main(String[] args) {

        new VentanaEstudiantes().setVisible(true);

    }

}