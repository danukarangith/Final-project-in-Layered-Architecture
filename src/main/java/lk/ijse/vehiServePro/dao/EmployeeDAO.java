package lk.ijse.vehiServePro.dao;

import lk.ijse.vehiServePro.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    boolean saveEmployee(final EmployeeDTO dto) throws SQLException;
    boolean updateEmployee( EmployeeDTO dto) throws SQLException;
    boolean deleteCustomer(String id) throws SQLException;
    List<EmployeeDTO> getAllEmployee() throws SQLException;
}
