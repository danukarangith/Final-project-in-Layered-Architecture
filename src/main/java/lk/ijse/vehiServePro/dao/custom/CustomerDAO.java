package lk.ijse.vehiServePro.dao.custom;

import lk.ijse.vehiServePro.dao.CrudDAO;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer> {
   /* boolean save(final CustomerDTO dto) throws SQLException;
    boolean update( CustomerDTO dto) throws SQLException;
    List<Customer> getAll() throws SQLException;
    boolean delete(String id) throws SQLException ;*/
}
