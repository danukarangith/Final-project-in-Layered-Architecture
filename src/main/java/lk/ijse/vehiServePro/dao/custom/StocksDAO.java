package lk.ijse.vehiServePro.dao.custom;

import lk.ijse.vehiServePro.dto.StocksDTO;

import java.sql.SQLException;
import java.util.List;

public interface StocksDAO {
    boolean saveItem(final StocksDTO dto) throws SQLException;
    boolean updateStock( StocksDTO dto) throws SQLException;
    boolean deleteStock(String id) throws SQLException;
    List<StocksDTO> getAllStock() throws SQLException;
}
