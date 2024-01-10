package lk.ijse.vehiServePro.dao.custom.impl;

import lk.ijse.vehiServePro.dao.SQLUtil;
import lk.ijse.vehiServePro.dao.custom.VehicleDAO;
import lk.ijse.vehiServePro.db.DbConnection;
import lk.ijse.vehiServePro.dto.VehicleDTO;
import lk.ijse.vehiServePro.entity.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO {
   @Override
   public boolean save(final Vehicle entity) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO vehicle VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getNum());
        pstm.setString(4, dto.getBrand());
        pstm.setString(5, dto.getType());

        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;*/
      return SQLUtil.excecute("INSERT INTO vehicle VALUES(?,?,?,?,?)",
               entity.getId(),
               entity.getName(),
               entity.getNum(),
               entity.getBrand(),
               entity.getType()
       );
    }
   @Override
   public boolean update( Vehicle entity) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE vehicle set customer_id = ?,veh_num = ?,veh_brand = ? ,veh_type = ? WHERE vehicle_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getNum());
        pstm.setString(3, dto.getBrand());
        pstm.setString(4, dto.getType());
        pstm.setString(5, dto.getId());


        return pstm.executeUpdate() > 0;*/
      return SQLUtil.excecute("UPDATE vehicle set customer_id = ?,veh_num = ?,veh_brand = ? ,veh_type = ? WHERE vehicle_id = ?",
               entity.getName(),
               entity.getNum(),
               entity.getBrand(),
               entity.getType(),
               entity.getId()
       );
    }
   @Override
   public boolean delete(String id) throws SQLException{
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM vehicle WHERE vehicle_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;*/

      return SQLUtil.excecute("DELETE FROM vehicle WHERE vehicle_id = ?",id);
    }
    @Override
    public List<Vehicle> getAll() throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM vehicle";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();*/
        ResultSet resultSet = SQLUtil.excecute("SELECT * FROM vehicle");

        List<Vehicle> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new Vehicle(
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
