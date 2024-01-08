package lk.ijse.vehiServePro.dao.custom;

import lk.ijse.vehiServePro.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.List;

public interface VehicleDAO {
    boolean saveVehicle(final VehicleDTO dto) throws SQLException;
    boolean updateVehicle( VehicleDTO dto) throws SQLException;
    boolean deleteCustomer(String id) throws SQLException;
    List<VehicleDTO> getAllVehicle() throws SQLException;
}
