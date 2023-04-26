package com.ayseozcan.repository;

import com.ayseozcan.entity.Musteri;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MusteriRepositoryImpl {
    
     public Optional<Connection> openConnection(){
         Connection conn=null;
         try{
            Driver.class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/MusteriTakipDB"; // connectionString
            String username = "postgres";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);            
        }catch(Exception ex){
            System.out.println("Beklenmeye bir hata oldu...: "+ ex.toString());
        }  
        return Optional.of(conn); 
    }
    
    public void save(Musteri musteri){
        Optional<Connection> conn = openConnection();
        if(conn.isPresent()){
            String SQL ="insert into tblmusteri(ad,adres,telefon,avatar,state)"
                    + " values('"+musteri.getAd()+"','"
                    +musteri.getAdres()+"','"
                    +musteri.getTelefon()+"','"
                    +musteri.getAvatar()+"',"
                    +musteri.getState()+")";
            try{
                PreparedStatement pr = conn.get().prepareCall(SQL);
                pr.executeUpdate();
                conn.get().close();
            }catch(Exception ex){
                
            }            
        }
    }
    public void update(Musteri musteri){
        Optional<Connection> conn = openConnection();
        if(conn.isPresent()){
            String SQL = "update tblmusteri set ad='"
                    +musteri.getAd()+"', adres='"
                    +musteri.getAdres()+"',telefon='"
                    +musteri.getTelefon()+"',avatar='"
                    +musteri.getAvatar()+"',state="
                    +musteri.getState()+" where id="+musteri.getId();
            try{
                PreparedStatement pr = conn.get().prepareCall(SQL);
                pr.executeUpdate();
                conn.get().close();
            }catch(Exception ex){
                
            }            
        }
    }
    public void delete(Long id){
        Optional<Connection> conn = openConnection();
            if(conn.isPresent()){
                String SQL = "delete from tblmusteri where id="+id;
                try{
                    PreparedStatement pr = conn.get().prepareCall(SQL);
                    pr.executeUpdate();
                    conn.get().close();
                }catch(Exception ex){

                }            
            }
    }
    
    public List<Musteri> findAll(){
        /**
         * Müşteri Kabı oluşturduk
         */
        List<Musteri> mlist = new ArrayList<>();
        Optional<Connection> conn = openConnection();
        try{
            String SQL = "select * from tblmusteri";
            if(conn.isPresent()){
                PreparedStatement pr = conn.get().prepareCall(SQL);
                /**
                 * Tüm tabloyu ResultSet içine çektik
                 */
                ResultSet rs = pr.executeQuery();
                while(rs.next()){
                    /**
                     * Müşteri nesnesi oluşturarak tablo içindeki tüm datayı 
                     * müşteri bilgilerine yazdık.
                     */
                    Musteri musteri = new Musteri();
                    musteri.setId(rs.getLong("id"));
                    musteri.setAd(rs.getNString("ad"));
                    musteri.setAdres(rs.getNString("adres"));
                    musteri.setAvatar(rs.getNString("avatar"));
                    musteri.setTelefon(rs.getNString("telefon"));
                    musteri.setState(rs.getInt("state"));
                    mlist.add(musteri);
                }
                conn.get().close();
            }
        }catch(Exception ex){
        }
                
        return mlist;                
    }
    
    public Musteri findById(Long id){
        Musteri musteri = new Musteri();
        Optional<Connection> conn = openConnection();
        try{
            String SQL = "select * from tblmusteri where id="+id;
            if(conn.isPresent()){
                PreparedStatement pr = conn.get().prepareCall(SQL);
                /**
                 * Tüm tabloyu ResultSet içine çektik
                 */
                ResultSet rs = pr.executeQuery();
                while(rs.next()){
                    /**
                     * Müşteri nesnesi oluşturarak tablo içindeki tüm datayı 
                     * müşteri bilgilerine yazdık.
                     */                   
                    musteri.setId(rs.getLong("id"));
                    musteri.setAd(rs.getNString("ad"));
                    musteri.setAdres(rs.getNString("adres"));
                    musteri.setAvatar(rs.getNString("avatar"));
                    musteri.setTelefon(rs.getNString("telefon"));
                    musteri.setState(rs.getInt("state"));                   
                }
                conn.get().close();
            }
        }catch(Exception ex){
        }                
        return musteri; 
    }
    
    public List<Musteri> findByAd(String ad){
         /**
         * Müşteri Kabı oluşturduk
         */
        List<Musteri> mlist = new ArrayList<>();
        Optional<Connection> conn = openConnection();
        try{
            String SQL = "select * from tblmusteri where ad like %"+ad+"%";
            if(conn.isPresent()){
                PreparedStatement pr = conn.get().prepareCall(SQL);
                /**
                 * Tüm tabloyu ResultSet içine çektik
                 */
                ResultSet rs = pr.executeQuery();
                while(rs.next()){
                    /**
                     * Müşteri nesnesi oluşturarak tablo içindeki tüm datayı 
                     * müşteri bilgilerine yazdık.
                     */
                    Musteri musteri = new Musteri();
                    musteri.setId(rs.getLong("id"));
                    musteri.setAd(rs.getNString("ad"));
                    musteri.setAdres(rs.getNString("adres"));
                    musteri.setAvatar(rs.getNString("avatar"));
                    musteri.setTelefon(rs.getNString("telefon"));
                    musteri.setState(rs.getInt("state"));
                    mlist.add(musteri);
                }
                conn.get().close();
            }
        }catch(Exception ex){
        }
                
        return mlist; 
    }
    public List<Musteri> findByTelefon(String telefon){
         /**
         * Müşteri Kabı oluşturduk
         */
        List<Musteri> mlist = new ArrayList<>();
        Optional<Connection> conn = openConnection();
        try{
            String SQL = "select * from tblmusteri where ad like %"+telefon+"%";
            if(conn.isPresent()){
                PreparedStatement pr = conn.get().prepareCall(SQL);
                /**
                 * Tüm tabloyu ResultSet içine çektik
                 */
                ResultSet rs = pr.executeQuery();
                while(rs.next()){
                    /**
                     * Müşteri nesnesi oluşturarak tablo içindeki tüm datayı 
                     * müşteri bilgilerine yazdık.
                     */
                    Musteri musteri = new Musteri();
                    musteri.setId(rs.getLong("id"));
                    musteri.setAd(rs.getNString("ad"));
                    musteri.setAdres(rs.getNString("adres"));
                    musteri.setAvatar(rs.getNString("avatar"));
                    musteri.setTelefon(rs.getNString("telefon"));
                    musteri.setState(rs.getInt("state"));
                    mlist.add(musteri);
                }
                conn.get().close();
            }
        }catch(Exception ex){
        }
                
        return mlist; 
    }
    public List<Musteri> findByAdres(String adres){
         /**
         * Müşteri Kabı oluşturduk
         */
        List<Musteri> mlist = new ArrayList<>();
        Optional<Connection> conn = openConnection();
        try{
             String SQL = "select * from tblmusteri where ad like %"+adres+"%";
            if(conn.isPresent()){
                PreparedStatement pr = conn.get().prepareCall(SQL);
                /**
                 * Tüm tabloyu ResultSet içine çektik
                 */
                ResultSet rs = pr.executeQuery();
                while(rs.next()){
                    /**
                     * Müşteri nesnesi oluşturarak tablo içindeki tüm datayı 
                     * müşteri bilgilerine yazdık.
                     */
                    Musteri musteri = new Musteri();
                    musteri.setId(rs.getLong("id"));
                    musteri.setAd(rs.getNString("ad"));
                    musteri.setAdres(rs.getNString("adres"));
                    musteri.setAvatar(rs.getNString("avatar"));
                    musteri.setTelefon(rs.getNString("telefon"));
                    musteri.setState(rs.getInt("state"));
                    mlist.add(musteri);
                }
                conn.get().close();
            }
        }catch(Exception ex){
        }
                
        return mlist; 
    }
    
    
}
