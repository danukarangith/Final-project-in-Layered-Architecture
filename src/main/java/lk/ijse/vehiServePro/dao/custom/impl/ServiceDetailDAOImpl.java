package lk.ijse.vehiServePro.dao.custom.impl;

import lk.ijse.vehiServePro.dao.SQLUtil;
import lk.ijse.vehiServePro.dao.custom.ServiceDetailDAO;
import lk.ijse.vehiServePro.db.DbConnection;
import lk.ijse.vehiServePro.dto.ServiceDetailDTO;
import lk.ijse.vehiServePro.entity.ServiceDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ServiceDetailDAOImpl implements ServiceDetailDAO {
   @Override
   public boolean save(final ServiceDetail entity) throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO service_detail VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getCuname());
        pstm.setString(3, dto.getNumber());
        pstm.setString(4, dto.getDate());
        pstm.setString(5, dto.getTime());
        pstm.setString(6, dto.getDetail());
        pstm.setString(7, dto.getEname());

        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;*/
     return   SQLUtil.excecute("INSERT INTO service_detail VALUES(?,?,?,?,?,?,?)",
               entity.getId(),
               entity.getCuname(),
               entity.getNumber(),
               entity.getDate(),
               entity.getTime(),
               entity.getDetail(),
               entity.getEname()
       );
    }
    @Override
    public boolean update( ServiceDetail entity) throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE service_detail set customer_name = ?,vehicle_number = ?,service_date = ? ,service_time = ? ,details = ?,employee_name = ? WHERE service_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setString(1, dto.getCuname());
        pstm.setString(2, dto.getNumber());
        pstm.setString(3, dto.getDate());
        pstm.setString(4, dto.getTime());
        pstm.setString(5, dto.getDetail());
        pstm.setString(6, dto.getEname());
        pstm.setString(7, dto.getId());


        return pstm.executeUpdate() > 0;*/
       return SQLUtil.excecute("UPDATE service_detail set customer_name = ?,vehicle_number = ?,service_date = ? ,service_time = ? ,details = ?,employee_name = ? WHERE service_id = ?",
                entity.getCuname(),
                entity.getNumber(),
                entity.getDate(),
                entity.getTime(),
                entity.getDetail(),
                entity.getEname(),
                entity.getId()
        );
    }

    @Override
    public List<ServiceDetail> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException{
        /*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM service_detail WHERE service_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;*/
       return SQLUtil.excecute("DELETE FROM service_detail WHERE service_id = ?",id);
    }
}
