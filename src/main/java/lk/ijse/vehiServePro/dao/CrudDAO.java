package lk.ijse.vehiServePro.dao;

import lk.ijse.vehiServePro.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    boolean save(final T entity) throws SQLException;
    boolean update( T entity) throws SQLException;
    List<T> getAll() throws SQLException;
    boolean delete(String id) throws SQLException ;
}
