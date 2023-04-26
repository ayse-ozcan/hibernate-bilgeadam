package com.ayseozcan.repository;

import com.ayseozcan.entity.User;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class UserRepositoryImpl {
    
    /**
     * Optional -> null olarak dönülecek var olmayan değerleri özel bir şekilde
     * sarmalayarak kontrol edilmesine izin veren nullcheck işleminden bizi kurtaran
     * bir Anahtar Kelimedir. Uygulamalarımızda sıklıkla kullanıtız.
     * 
     */
   
    /**
     * Bu method bize bir bağlantı açmayı dener ve Connection nesnesi döner, Ancak bir hata ile 
     * karşılaşır ise Connection null olacaktır, bu istemediğimiz bir durum bu nedenle null
     * değer dönmek yerine Optional kullanmak daha anlamlı olacaktır.
     * @return 
     */
    public Optional<Connection> openConnection(){
         Connection conn=null;
         try{
            Driver.class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/MusteriTakipDB"; // connectionString
            String username = "postgres";
            String password = "12330125689Aa.";
            conn = DriverManager.getConnection(url, username, password);            
        }catch(Exception ex){
            System.out.println("Beklenmeye bir hata oldu...: "+ ex.toString());
        }  
        return Optional.of(conn); 
    }
    
    public UserRepositoryImpl(){
              
    }
    
    public void save(User user){
        Optional<Connection> conn  = openConnection();
        if(conn.isPresent()){
            String SQL = "insert into tbluser(username,pwd,email)"
                   + " values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"')";
           try{
               PreparedStatement pr = conn.get().prepareCall(SQL);
               pr.executeUpdate();
               conn.get().close();
           }catch(Exception ex){
               System.out.println("save işlemi sırasında beklenmeyen hata...: "+ ex.toString());
           }        
        }     
    }
    public void update(){}
    public void delete(){}    
    public void findAll(){}    
    public boolean isUser(String username, String password){
        Optional<Connection> conn = openConnection();
        if(conn.isPresent()){
             String SQL = "select * from tbluser where username='"+username+"' and pwd='"+password+"'";
            try{
                 PreparedStatement pr = conn.get().prepareCall(SQL);
                 ResultSet rs = pr.executeQuery();
                 boolean result = rs.next();
                 conn.get().close();
                 return result;
            }catch(Exception ex){
                System.out.println("isUser da Beklenmeyen hata...: "+ex.toString());           
            }        
        }       
        return false;
    }
}
