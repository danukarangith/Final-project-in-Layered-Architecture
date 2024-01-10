package lk.ijse.vehiServePro.dao.custom.impl;

import lk.ijse.vehiServePro.dao.SQLUtil;
import lk.ijse.vehiServePro.dao.custom.ReservationDAO;
import lk.ijse.vehiServePro.db.DbConnection;
import lk.ijse.vehiServePro.dto.ReservationDTO;
import lk.ijse.vehiServePro.entity.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

   @Override
   public boolean save(final Reservation entity) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO reservation VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getEmail());
        pstm.setString(3, dto.getVehNum());
        pstm.setString(4, dto.getDate());
        pstm.setString(5, dto.getTime());

        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;*/

      return SQLUtil.excecute("INSERT INTO reservation VALUES(?,?,?,?,?)",
               entity.getId(),
               entity.getEmail(),
               entity.getVehNum(),
               entity.getDate(),
               entity.getTime()
       );
    }

    @Override
    public boolean update( Reservation entity) throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE reservation set reservation_email = ?,reservation_VehNum = ? ,reservation_date=?,reservation_time=? WHERE reservation_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);



        pstm.setString(1, dto.getEmail());
        pstm.setString(2, dto.getVehNum());
        pstm.setString(3, dto.getDate());
        pstm.setString(4, dto.getTime());
        pstm.setString(5, dto.getId());



        return pstm.executeUpdate() > 0;*/

       return SQLUtil.excecute( "UPDATE reservation set reservation_email = ?,reservation_VehNum = ? ,reservation_date=?,reservation_time=? WHERE reservation_id = ?",
                entity.getEmail(),
                entity.getVehNum(),
                entity.getDate(),
                entity.getTime(),
                entity.getId()
        );
    }
   @Override
   public boolean delete(String id) throws SQLException{
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM reservation WHERE reservation_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;*/
      return SQLUtil.excecute("DELETE FROM reservation WHERE reservation_id = ?",id);
    }

    public List<Reservation> getAll() throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM reservation";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();*/
        ResultSet resultSet = SQLUtil.excecute("SELECT * FROM reservation");

        List<Reservation> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new Reservation(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return cusList;
    }
}
