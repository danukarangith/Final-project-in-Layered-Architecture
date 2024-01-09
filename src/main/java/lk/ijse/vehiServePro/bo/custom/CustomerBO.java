package lk.ijse.vehiServePro.bo.custom;

import lk.ijse.vehiServePro.bo.SuperBO;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {

    List<CustomerDTO> getAllCustomer() throws SQLException;
    boolean saveCustomer(final CustomerDTO dto) throws SQLException;
    boolean updateCustomer( CustomerDTO dto) throws SQLException;

    boolean deleteCustomer(String id) throws SQLException;
}
