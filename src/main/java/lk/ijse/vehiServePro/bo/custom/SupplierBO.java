package lk.ijse.vehiServePro.bo.custom;

import lk.ijse.vehiServePro.bo.SuperBO;
import lk.ijse.vehiServePro.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.List;

public interface SupplierBO extends SuperBO {
    List<SupplierDTO> getAllSupplier() throws SQLException;
    boolean saveSupplier(SupplierDTO dto) throws SQLException;
    boolean updateSupplier(SupplierDTO dto) throws SQLException;
    boolean deleteSupplier(String id) throws SQLException;
}
