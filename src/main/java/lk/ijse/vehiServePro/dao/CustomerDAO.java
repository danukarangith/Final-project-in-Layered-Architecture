package lk.ijse.vehiServePro.dao;

import lk.ijse.vehiServePro.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    boolean saveCustomer(final CustomerDTO dto) throws SQLException;
    boolean updateCustomer( CustomerDTO dto) throws SQLException;
    List<CustomerDTO> getAllCustomers() throws SQLException;
    boolean deleteCustomer(String id) throws SQLException ;
}
