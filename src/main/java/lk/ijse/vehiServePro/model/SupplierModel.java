package lk.ijse.vehiServePro.model;

import lk.ijse.vehiServePro.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.vehiServePro.dto.SupplierDTO;
import lk.ijse.vehiServePro.dto.tm.SupplierDetailTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierModel {
    public boolean saveSupplier(final SupplierDTO dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO stock_supplier VALUES(?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());



        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;*/
        SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
        boolean isSave = supplierDAO.saveSupplier(new SupplierDTO(dto.getId(),dto.getName(),dto.getAddress()));
        return isSave;
    }
    public boolean updateSupplier( SupplierDTO dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE stock_supplier set sup_name = ?,sup_address = ?  WHERE stock_supplier_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getId());


        return pstm.executeUpdate() > 0;*/
        SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
        boolean isUpdate = supplierDAO.updateSupplier(new SupplierDTO(dto.getId(),dto.getName(),dto.getAddress()));
        return isUpdate;
    }
    public boolean deleteSupplier(String id) throws SQLException{
        /*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM stock_supplier WHERE stock_supplier_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;*/
        SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
        boolean isDelete = supplierDAO.deleteSupplier(id);
        return isDelete;
    }
    public List<SupplierDTO> getAllSupplier() throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();

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
        return cusList;*/
        SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
        ArrayList<SupplierDTO> allSupplier = (ArrayList<SupplierDTO>) supplierDAO.getAllSupplier();
        for (SupplierDTO dto : allSupplier){
            new SupplierDetailTm(dto.getId(),dto.getName(),dto.getAddress());
        }
        return allSupplier;
    }
}
