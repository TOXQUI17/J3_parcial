/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j3_parcial;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface RepoCliente extends MongoRepository<Cliente,String>{
    
}