package lk.ijse.vehiServePro.bo.custom.impl;

import lk.ijse.vehiServePro.bo.custom.StockBO;
import lk.ijse.vehiServePro.dao.DAOFactory;
import lk.ijse.vehiServePro.dao.custom.StocksDAO;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.dto.StocksDTO;
import lk.ijse.vehiServePro.entity.Customer;
import lk.ijse.vehiServePro.entity.Stock;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockBOImpl implements StockBO {
    StocksDAO stocksDAO = (StocksDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.STOCKS);

    @Override
    public List<StocksDTO> getAllStocks() throws SQLException {
        List<Stock> stocks = stocksDAO.getAll();
        List<StocksDTO> list = new ArrayList<>();

        for (Stock stock : stocks){
            list.add(
                    new StocksDTO(
                             stock.getId(),
                            stock.getName(),
                            stock.getPrice(),
                            stock.getRemain(),
                            stock.getUser()
                    )
            );
        }
        return list;
    }
    @Override
    public boolean saveStocks(StocksDTO dto) throws SQLException {
        Stock entity = new Stock(
                dto.getId(),
                dto.getName(),
                dto.getPrice(),
                dto.getRemain(),
                dto.getUser()
        );
        return stocksDAO.save(entity);
    }
    @Override
    public boolean updateStocks(StocksDTO dto) throws SQLException {
        Stock entity = new Stock(
                dto.getId(),
                dto.getName(),
                dto.getPrice(),
                dto.getRemain(),
                dto.getUser()
        );
        return stocksDAO.update(entity);
    }
    @Override
    public boolean deleteStocks(String id) throws SQLException {
        return stocksDAO.delete(id);
    }
}
