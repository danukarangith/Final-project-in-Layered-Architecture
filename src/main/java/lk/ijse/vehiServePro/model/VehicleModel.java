package lk.ijse.vehiServePro.model;

import lk.ijse.vehiServePro.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.vehiServePro.dto.VehicleDTO;
import lk.ijse.vehiServePro.dto.tm.VehicleTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleModel {
   /* public boolean saveVehicle(final VehicleDTO dto) throws SQLException {
        *//*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO vehicle VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getNum());
        pstm.setString(4, dto.getBrand());
        pstm.setString(5, dto.getType());

        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;*//*
        VehicleDAOImpl vehicleDAO = new VehicleDAOImpl();
        boolean isSave = vehicleDAO.saveVehicle(new VehicleDTO(dto.getId(),dto.getName(),dto.getNum(),dto.getBrand(),dto.getType()));
        return isSave;
    }
    public boolean updateVehicle( VehicleDTO dto) throws SQLException {
       *//* Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE vehicle set customer_id = ?,veh_num = ?,veh_brand = ? ,veh_type = ? WHERE vehicle_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getNum());
        pstm.setString(3, dto.getBrand());
        pstm.setString(4, dto.getType());
        pstm.setString(5, dto.getId());


        return pstm.executeUpdate() > 0;*//*
        VehicleDAOImpl vehicleDAO = new VehicleDAOImpl();
        boolean isUpdate = vehicleDAO.updateVehicle(new VehicleDTO(dto.getName(),dto.getNum(),dto.getBrand(),dto.getType(),dto.getId()));
        return isUpdate;
    }
    public boolean deleteCustomer(String id) throws SQLException{
        *//*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM vehicle WHERE vehicle_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;*//*
        VehicleDAOImpl vehicleDAO = new VehicleDAOImpl();
        boolean isDelete = vehicleDAO.deleteCustomer(id);
        return isDelete;
    }
    public List<VehicleDTO> getAllVehicle() throws SQLException {
       *//* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM vehicle";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<VehicleDTO> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new VehicleDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return cusList;*//*
        VehicleDAOImpl vehicleDAO = new VehicleDAOImpl();
        ArrayList<VehicleDTO> allVehicle = (ArrayList<VehicleDTO>) vehicleDAO.getAllVehicle();
        for (VehicleDTO dto : allVehicle) {
            new VehicleTm(dto.getId(),dto.getName(),dto.getNum(),dto.getBrand(),dto.getType());
        }
        return allVehicle;
    }*/
}
