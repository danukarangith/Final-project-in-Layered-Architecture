package lk.ijse.vehiServePro.dao.custom.impl;

import lk.ijse.vehiServePro.dao.SQLUtil;
import lk.ijse.vehiServePro.dao.custom.CustomerDAO;
import lk.ijse.vehiServePro.db.DbConnection;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(final Customer entity) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getContact());
        pstm.setString(5, dto.getEmail());*/

        return SQLUtil.excecute("INSERT INTO customer VALUES(?,?,?,?,?)",
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getContact(),
                entity.getEmail()
        );
    }

   @Override
   public boolean update( Customer entity) throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE customer set cu_name = ?,cu_address = ?,cu_contact = ? ,cu_email = ? WHERE customer_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, entity.getName());
        pstm.setString(2, entity.getAddress());
        pstm.setString(3, entity.getContact());
        pstm.setString(4, entity.getEmail());
        pstm.setString(5, entity.getId());*/

      return SQLUtil.excecute("UPDATE customer set cu_name = ?,cu_address = ?,cu_contact = ? ,cu_email = ? WHERE customer_id = ?",

               entity.getName(),
               entity.getAddress(),
               entity.getContact(),
               entity.getEmail(),
               entity.getId());



    }



    @Override
   public List<Customer> getAll() throws SQLException {
      /* Connection connection = DbConnection.getInstance().getConnection();

       String sql = "SELECT * FROM customer";
       ResultSet resultSet = connection.prepareStatement(sql).executeQuery();*/

      ResultSet resultSet =  SQLUtil.excecute("SELECT * FROM customer");

       List<Customer> cusList = new ArrayList<>();

       while (resultSet.next()) {
           cusList.add(new Customer(
                   resultSet.getString(1),
                   resultSet.getString(2),
                   resultSet.getString(3),
                   resultSet.getString(4),
                   resultSet.getString(5)
           ));
       }
       return cusList;
   }

    public boolean delete(String id) throws SQLException{
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM customer WHERE customer_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;*/
       return SQLUtil.excecute("DELETE FROM customer WHERE customer_id = ?",id);
    }
}
