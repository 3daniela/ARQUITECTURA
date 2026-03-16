package view;

import dao.ProductoDAO;
import model.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductoView extends JFrame {

    private JTextField txtId, txtNombre, txtPrecio, txtCantidad;
    private JTable tabla;

    private ProductoDAO dao = new ProductoDAO();

    public ProductoView(){

        setTitle("CRUD Productos");
        setSize(700,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5,2,10,10));
        panel.setBackground(new Color(240,240,240));

        txtId = new JTextField();
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtCantidad = new JTextField();

        panel.add(new JLabel("ID"));
        panel.add(txtId);

        panel.add(new JLabel("Nombre"));
        panel.add(txtNombre);

        panel.add(new JLabel("Precio"));
        panel.add(txtPrecio);

        panel.add(new JLabel("Cantidad"));
        panel.add(txtCantidad);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");

        btnAgregar.setBackground(new Color(52,152,219));
        btnAgregar.setForeground(Color.WHITE);

        btnEliminar.setBackground(new Color(231,76,60));
        btnEliminar.setForeground(Color.WHITE);

        panel.add(btnAgregar);
        panel.add(btnEliminar);

        add(panel, BorderLayout.NORTH);

        tabla = new JTable(new DefaultTableModel(
                new Object[]{"ID","Nombre","Precio","Cantidad"},0
        ));

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> agregar());
        btnEliminar.addActionListener(e -> eliminar());

        cargarDatos();
    }

    private void agregar(){

        Producto p = new Producto(
                Integer.parseInt(txtId.getText()),
                txtNombre.getText(),
                Double.parseDouble(txtPrecio.getText()),
                Integer.parseInt(txtCantidad.getText())
        );

        dao.agregarProducto;

        cargarDatos();
    }

    private void eliminar(){

        int fila = tabla.getSelectedRow();

        if(fila >=0){

            int id = (int) tabla.getValueAt(fila,0);

            dao.eliminarProducto(id);

            cargarDatos();
        }
    }

    private void cargarDatos(){

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        modelo.setRowCount(0);

        for(Producto p : dao.listarProductos()){

            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getPrecio(),
                    p.getCantidad()
            });

        }
    }
}