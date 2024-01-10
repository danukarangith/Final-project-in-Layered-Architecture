package lk.ijse.vehiServePro.dao.custom.impl;

import lk.ijse.vehiServePro.dao.SQLUtil;
import lk.ijse.vehiServePro.dao.custom.PaymentDAO;
import lk.ijse.vehiServePro.db.DbConnection;
import lk.ijse.vehiServePro.dto.PaymentDTO;
import lk.ijse.vehiServePro.entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

   @Override
   public boolean save(final Payment entity) throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO payment VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAmount());
        pstm.setString(4, dto.getMethod());
        pstm.setString(5, dto.getDetail());*/

      return SQLUtil.excecute("INSERT INTO payment VALUES(?,?,?,?,?)",
               entity.getId(),
               entity.getName(),
               entity.getAmount(),
               entity.getMethod(),
               entity.getDetail()
       );

        /*boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;*/
    }

   @Override
   public boolean update( Payment entity) throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE payment set customer_name = ?,payment_amount = ?,payment_method = ? ,detail = ? WHERE payment_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAmount());
        pstm.setString(3, dto.getMethod());
        pstm.setString(4, dto.getDetail());
        pstm.setString(5, dto.getId());


        return pstm.executeUpdate() > 0;*/

      return SQLUtil.excecute("UPDATE payment set customer_name = ?,payment_amount = ?,payment_method = ? ,detail = ? WHERE payment_id = ?",
               entity.getName(),
               entity.getAmount(),
               entity.getMethod(),
               entity.getDetail(),
               entity.getId()
       );
    }

    @Override
    public List<Payment> getAll() throws SQLException {
        return null;
    }

    @Override
   public boolean delete(String id) throws SQLException{
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM payment WHERE payment_id= ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;*/
      return SQLUtil.excecute("DELETE FROM payment WHERE payment_id= ?",id);
    }
}
