/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j3_parcial;



package unitec.elementosmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin


public class ControladorCliente {
    
  @Autowired
    RepoCliente repoCliente;

    @GetMapping("/mensaje")

    public List<Cliente> buscarTodos() {
        return repoCliente.findAll();
    }

    // caso b) buscar por id
    
    @GetMapping("/mensaje/{Id}")

    public Cliente bucarPorId(@PathVariable String Id) {
        Cliente client = new Cliente();
        return repoCliente.findById(Id).get();
    }
    
    //caso c) guardar
    @PostMapping("/mensaje")
    public Tarjeta guardar(@RequestBody String json) throws Exception{
        
        //primero convertimos este string json a un objeto java
        ObjectMapper maper=new ObjectMapper();
        Cliente client= maper.readValue(json,Cliente.class);
        repoCliente.save(client);
        System.out.println("Este objeto se convirtio:"+client);
       Tarjeta estatus=new Tarjeta();
        estatus.setSucess(true);
        estatus.setTarjeta("Mensaje guardado con exito!!!");
        return estatus;
       
    }
    
    //caso d) actualizar
    @PutMapping("/mensaje")
    public Estatus actualizar(@RequestBody String json) throws Exception{
        ObjectMapper maper=new ObjectMapper();
        Mensaje mensa= maper.readValue(json, Mensaje.class);
        repoCliente.save(mensa);
        System.out.println("Este objeto se convirtio:"+mensa);
        Estatus estatus=new Estatus();
        estatus.setSucess(true);
        estatus.setMensaje("Mensaje guardado con exito!!!");
        return estatus;
    }
    //caso e) borrar
    @DeleteMapping("/mensaje/{id}")
    public Estatus borrarPorId(@PathVariable String id){
        ObjectMapper maper=new ObjectMapper();
        Mensaje mensa= new Mensaje();
        repoCliente.deleteById(id);
        Estatus e=new Estatus();
        e.setSucess(true);
        e.setMensaje("Mensaje borrado con exito!!!");
        return e;
    }
}


