package org.sp2;
import java.sql.*;

public class App
{
    public static void main( String[] args )
    {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String db="Entregavel";
            String url="jdbc:mysql://localhost:32771/"+db;
            String user="root";
            String psw="root";

            conn=DriverManager.getConnection(url,user,psw);



            String inserir = "INSERT INTO Frequencia VALUES (4,'31865041','8:30','12:00')";
            PreparedStatement pstm2 = conn.prepareStatement(inserir);
            pstm2.execute();
            System.out.println("Inserido!");

            //Mostra os dados da tabela
            String sql = "SELECT * FROM Frequencia";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                String PK = rs.getString("PK");
                String tia = rs.getString("TIA");
                String horarioEntrada = rs.getString("horarioEntrada");
                String horarioSaida = rs.getString("horarioSaida");

                System.out.println("#"+PK+" "+tia+"-"+horarioEntrada+"-"+horarioEntrada);
            }

            rs.close();
            conn.close();

        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
        catch(InstantiationException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            System.out.println("SQL EXCEPTION");
            e.printStackTrace();
        }
    }
}
