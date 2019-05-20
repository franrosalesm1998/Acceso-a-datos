
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import java.util.Scanner;
import org.bson.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franr
 */
public class Main {
    
    
    public static void main(String[] args){
    MongoClient client=MongoClients.create("mongodb://127.0.0.1:27017");
    MongoDatabase  bdinstrumentos=client.getDatabase("instrumentos");

        
       /* MongoCollection coleccion=bdinstrumentos.getCollection("instrumento");
        FindIterable iterable=coleccion.find();
        System.out.println("Introduce un instrumento");
        Scanner s=new Scanner(System.in);
        String nombre=s.nextLine();
        coleccion.insertOne(new Document("nombre",nombre));
        
        
        
        MongoCursor iterator=iterable.iterator();
        Document actual;
        
        
        
        do{
            actual=(Document)iterator.tryNext();
            if(actual!=null){
                System.out.println(actual.get("nombre"));
            }
        }while(actual!=null);

             
        System.out.println("Elimina un instrumento");
        Scanner t=new Scanner(System.in);
        String nombre2=t.nextLine();
        coleccion.findOneAndDelete(new Document("nombre",nombre2));
        
        iterable=coleccion.find();
        iterator=iterable.iterator();
        do{
            actual=(Document)iterator.tryNext();
            if(actual!=null){
                System.out.println(actual.get("nombre"));
            }
        }while(actual!=null);*/
        //insertar usuario
        MongoCollection usuarios=bdinstrumentos.getCollection("usuarios");
        Document miUsuario=new Document();
        miUsuario.append("_id","miguel.paramos@cenecmalaga.es");
        miUsuario.append("nombre","Miguel");
        miUsuario.append("contraseña","123123");
       // usuarios.insertOne(miUsuario);
        
        //hacer que el usuario te lo pida por scanner entero
        //hacer un login: que pida por Scanner email y contraseña y con find te busque el email y la contraseña
        //que le has puesto. Si lo encuentra, que te muestre todos los datos de ese usuario por pantalla. Si no,
        //Que diga "Login incorrecto".
     String email;
        Document actual;
        do{
        System.out.println("Introduce un email");
        Scanner u=new Scanner(System.in);
        email=u.nextLine();
        
        System.out.println("Introduce la contraseña: ");
        Scanner w=new Scanner(System.in);
        String contraseña=w.nextLine();
        Document usuario=new Document("_id",email);
        usuario.append("contraseña",contraseña);
        FindIterable iterable2=usuarios.find(usuario);
        
        MongoCursor iterator=iterable2.iterator();
        
        
        
       
            actual=(Document)iterator.tryNext();
            if(actual!=null){
                System.out.println(actual.get("_id"));
                System.out.println(actual.get("contraseña"));
                System.out.println("Login correcto!");
            }
            else{
                System.out.println("Login incorrecto");
        }
        }while(actual==null);
        
        MongoCollection instrumentos=bdinstrumentos.getCollection("instrumentos");
        Document instrumento=new Document("musico",email);
        FindIterable iterable3=instrumentos.find(instrumento);
        
        MongoCursor iterator2=iterable3.iterator();
        
        actual=(Document)iterator2.tryNext();
        
        do{
        
              if(actual!=null){
                System.out.println(actual.get("musico")+" : "+actual.get("nombre"));
                
             
            }
            else{
                System.out.println("Login incorrecto");
        }
        }
        while(actual==null);
        

      
        
        
        
        
        
        
}

}
