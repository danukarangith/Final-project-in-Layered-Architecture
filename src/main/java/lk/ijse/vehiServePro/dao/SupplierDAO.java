package lk.ijse.vehiServePro.dao;

import lk.ijse.vehiServePro.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO {
    boolean saveSupplier(final SupplierDTO dto) throws SQLException;
    boolean updateSupplier( SupplierDTO dto) throws SQLException;
    boolean deleteSupplier(String id) throws SQLException;
    List<SupplierDTO> getAllSupplier() throws SQLException;
}
