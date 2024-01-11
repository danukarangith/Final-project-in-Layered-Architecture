package lk.ijse.vehiServePro.bo.custom;

import lk.ijse.vehiServePro.bo.SuperBO;
import lk.ijse.vehiServePro.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
     List<EmployeeDTO> getAllEmployee() throws SQLException;
     boolean saveEmployee(EmployeeDTO dto) throws SQLException;
     boolean updateEmployee(EmployeeDTO dto) throws SQLException;
     boolean deleteEmployee(String id) throws SQLException;
}
