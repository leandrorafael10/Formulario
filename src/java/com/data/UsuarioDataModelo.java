/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.data;


import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**

public class UsuarioDataModelo extends ListDataModel<Usuario> implements SelectableDataModel<Usuario>{

    public UsuarioDataModelo() {
    }

    public UsuarioDataModelo(List<Usuario> list) {
        super(list);
    }

    @Override
    public Object getRowKey(Usuario t) {
        return t.getIdusuario().toString();
    }

    @Override
    public Usuario getRowData(String string) {
        List<Usuario> usuarios = (List<Usuario>)getWrappedData();
        for(Usuario u: usuarios){
            if(u.getIdusuario().toString().equals(string)){
                return u;
            }
        }
        return null;
    }
    
   
    
}
* 
 *
 * @author usuario-X
 */