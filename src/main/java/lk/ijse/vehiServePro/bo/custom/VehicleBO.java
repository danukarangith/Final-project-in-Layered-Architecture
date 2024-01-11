package lk.ijse.vehiServePro.bo.custom;

import lk.ijse.vehiServePro.bo.SuperBO;
import lk.ijse.vehiServePro.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.List;

public interface VehicleBO extends SuperBO {
    List<VehicleDTO> getAllVehicle() throws SQLException;
    boolean saveVehicle(VehicleDTO dto) throws SQLException;
    boolean updateVehicle(VehicleDTO dto) throws SQLException;
    boolean deleteVehicle(String id) throws SQLException;
}
