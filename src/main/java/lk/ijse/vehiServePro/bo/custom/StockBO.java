package lk.ijse.vehiServePro.bo.custom;

import lk.ijse.vehiServePro.bo.SuperBO;
import lk.ijse.vehiServePro.dto.StocksDTO;

import java.sql.SQLException;
import java.util.List;

public interface StockBO extends SuperBO {
    List<StocksDTO> getAllStocks() throws SQLException;
    boolean saveStocks(StocksDTO dto) throws SQLException;
    boolean updateStocks(StocksDTO dto) throws SQLException;
    boolean deleteStocks(String id) throws SQLException;
}
