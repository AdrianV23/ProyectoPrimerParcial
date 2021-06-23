package BusinessModelLayer;

import DataAccessLayer.DataAccess;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adrian
 */
public class Farmacia {
    private DataAccess dataAccess = DataAccess.Instance();
    private int idFarmacia;
    private String nombre;
    private String dirección;
    private String telefono;
    private int activo;
    
    public Farmacia(){}

    public Farmacia(int idFarmacia, String nombre, String dirección, String telefono, int activo) {
        this.idFarmacia = idFarmacia;
        this.nombre = nombre;
        this.dirección = dirección;
        this.telefono = telefono;
        this.activo = activo;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getTeléfono() {
        return telefono;
    }

    public void setTeléfono(String teléfono) {
        this.telefono = teléfono;
    }

    public int isActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
     public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM farmacias";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM farmacias WHERE idFarmacia = " + idFarmacia;
        DefaultTableModel res = dataAccess.Query(query);
        idFarmacia = (int)res.getValueAt(0, 0);
        nombre = (String)res.getValueAt(0, 1);
        dirección = (String)res.getValueAt(0, 2);
        telefono = (String)res.getValueAt(0, 3);
        activo = (int)res.getValueAt(0, 4); 
    }
    
    public boolean Add(){
        String query = "INSERT INTO farmacias(nombre, direccion , telefono, activo ) "
                + "VALUES('" + nombre + "','" + dirección + "','" + telefono +  "'," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Delete(){
        String query = "DELETE FROM farmacias WHERE idFarmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Update(){
        String query = "UPDATE farmacias SET " +
                "nombre = '" + nombre + "', " +
                "direccion = '" + dirección + "', " +
                "telefono = '" + telefono + "', " +
                "activo = " + activo + " " +
                "WHERE idfarmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }
    
    
}
