package lk.ijse.vehiServePro.dao.custom.impl;

import lk.ijse.vehiServePro.dao.custom.SupplierDAO;
import lk.ijse.vehiServePro.db.DbConnection;
import lk.ijse.vehiServePro.dto.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public boolean saveSupplier(final SupplierDTO dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO stock_supplier VALUES(?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());



        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;
    }
   @Override
   public boolean updateSupplier( SupplierDTO dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE stock_supplier set sup_name = ?,sup_address = ?  WHERE stock_supplier_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getId());


        return pstm.executeUpdate() > 0;
    }
    @Override
    public boolean deleteSupplier(String id) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM stock_supplier WHERE stock_supplier_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;
    }
    @Override
    public List<SupplierDTO> getAllSupplier() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM stock_supplier";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<SupplierDTO> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new SupplierDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)

            ));
        }
        return cusList;
    }
}
