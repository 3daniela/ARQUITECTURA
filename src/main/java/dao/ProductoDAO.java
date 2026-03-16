package dao;

import DB.ConexionDB;
import model.Producto;

import java.sql.*;
import java.util.ArrayList;

public class ProductoDAO {

    public void agregarProducto(Producto p){

        try{

            Connection conn = ConexionDB.conectar();

            String sql = "INSERT INTO producto VALUES (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,p.getId());
            ps.setString(2,p.getNombre());
            ps.setDouble(3,p.getPrecio());
            ps.setInt(4,p.getCantidad());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Producto> listarProductos(){

        ArrayList<Producto> lista = new ArrayList<>();

        try{

            Connection conn = ConexionDB.conectar();

            String sql = "SELECT * FROM producto";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                Producto p = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad")
                );

                lista.add(p);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return lista;
    }

    public void eliminarProducto(int id){

        try{

            Connection conn = ConexionDB.conectar();

            String sql = "DELETE FROM producto WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,id);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}