package lk.ijse.vehiServePro.dao.custom.impl;

import lk.ijse.vehiServePro.dao.SQLUtil;
import lk.ijse.vehiServePro.dao.custom.SupplierDAO;
import lk.ijse.vehiServePro.db.DbConnection;
import lk.ijse.vehiServePro.dto.SupplierDTO;
import lk.ijse.vehiServePro.entity.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public boolean save(final Supplier entity) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO stock_supplier VALUES(?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());



        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;*/
        return SQLUtil.excecute("INSERT INTO stock_supplier VALUES(?,?,?)",
                entity.getId(),
                entity.getName(),
                entity.getAddress()
        );
    }
   @Override
   public boolean update( Supplier entity) throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE stock_supplier set sup_name = ?,sup_address = ?  WHERE stock_supplier_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getId());


        return pstm.executeUpdate() > 0;*/
       return SQLUtil.excecute("UPDATE stock_supplier set sup_name = ?,sup_address = ?  WHERE stock_supplier_id = ?",
               entity.getName(),
               entity.getAddress(),
               entity.getId()
       );
    }
    @Override
    public boolean delete(String id) throws SQLException{
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM stock_supplier WHERE stock_supplier_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;*/

       return SQLUtil.excecute("DELETE FROM stock_supplier WHERE stock_supplier_id = ?",id);
    }
    @Override
    public List<Supplier> getAll() throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM stock_supplier";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();*/
        ResultSet resultSet = SQLUtil.excecute("SELECT * FROM stock_supplier");

        List<Supplier> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new Supplier(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)

            ));
        }
        return cusList;
    }
}
