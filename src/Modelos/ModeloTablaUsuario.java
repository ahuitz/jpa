/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import persistence.Usuario;
/**
 *
 * @author EST1659109
 */
public class ModeloTablaUsuario extends AbstractTableModel{

    private List<Usuario> usuario;
    private String columna[]={"Nombre","Apellido","Edad"};
    
    //constructor, q devuelve la lista
    public ModeloTablaUsuario(List<Usuario> usuarios){
        this.usuario=usuarios;
    }
    @Override
    //devuelve el valor de elemntos de una lista
    public int getRowCount() {
        return usuario.size();
    }

    @Override
    //retorna el numero de columnas
    public int getColumnCount() {
        return columna.length;
    }

    @Override
    //saca cada uno de los valores de la columna, la informacion que se va poner en la tabla
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usr=this.usuario.get(rowIndex);//posicion de la fila
        switch(columnIndex){
            case 0:
                return usr.getNombre();
            case 1:
                return usr.getApellido();
            case 2:
                return usr.getEdad();
        }
        return null;
    }
    
    //editar contenido
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;//(para ser editable)(valor por defecto "false" se cambia a true
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
     switch(columnIndex){
         case 0:
             usuario.get(rowIndex).setNombre((String)aValue);
             break;
         case 1:
             usuario.get(rowIndex).setApellido((String)aValue);
             break;
         case 2:
             usuario.get(rowIndex).setEdad((int)aValue);
             break;
     }
    }
}
