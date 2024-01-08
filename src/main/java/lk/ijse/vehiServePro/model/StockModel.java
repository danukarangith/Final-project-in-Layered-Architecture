package lk.ijse.vehiServePro.model;

import lk.ijse.vehiServePro.dao.custom.impl.StocksDAOImpl;

import lk.ijse.vehiServePro.dto.StocksDTO;
import lk.ijse.vehiServePro.dto.tm.StockTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockModel {
    public boolean saveItem(final StocksDTO dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO stock VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getPrice());
        pstm.setString(4, dto.getRemain());
        pstm.setString(5, dto.getUser());


        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;*/
        StocksDAOImpl stocksDAO = new StocksDAOImpl();
        boolean isSave = stocksDAO.saveItem(new StocksDTO(dto.getId(),dto.getName(),dto.getPrice(),dto.getRemain(),dto.getUser()));
        return isSave;
    }
    public boolean updateStock( StocksDTO dto) throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE stock set stock_name = ?,stock_price = ?,stock_remain = ?,user_name = ?  WHERE stock_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getPrice());
        pstm.setString(3, dto.getRemain());
        pstm.setString(4, dto.getUser());
        pstm.setString(5, dto.getId());


        return pstm.executeUpdate() > 0;*/
        StocksDAOImpl stocksDAO = new StocksDAOImpl();
        boolean isUpdate = stocksDAO.updateStock(new StocksDTO(dto.getId(),dto.getName(),dto.getPrice(),dto.getRemain(),dto.getUser()));
        return isUpdate;
    }
    public boolean deleteStock(String id) throws SQLException{
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM stock WHERE stock_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;*/
        StocksDAOImpl stocksDAO = new StocksDAOImpl();
        boolean isDelete = stocksDAO.deleteStock(id);
        return isDelete;
    }
    public List<StocksDTO> getAllStock() throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM stock";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<StocksDTO> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new StocksDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)

            ));
        }
        return cusList;*/
        StocksDAOImpl stocksDAO = new StocksDAOImpl();
        ArrayList<StocksDTO> allStocks =(ArrayList<StocksDTO>) stocksDAO.getAllStock();
        for (StocksDTO dto : allStocks){
            new StockTm(dto.getId(),dto.getName(),dto.getPrice(),dto.getRemain(),dto.getUser());
        }
        return allStocks;
    }
}
