package lk.ijse.vehiServePro.model;

import lk.ijse.vehiServePro.dao.CustomerDAOImpl;
import lk.ijse.vehiServePro.db.DbConnection;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.dto.tm.CustomerTm;
import org.jsoup.select.Evaluator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

    public boolean saveCustomer(final CustomerDTO dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getContact());
        pstm.setString(5, dto.getEmail());

        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;*/

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        boolean isSaved = customerDAO.saveCustomer(new CustomerDTO(dto.getId(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getContact()));
        return isSaved;
    }

    public boolean updateCustomer( CustomerDTO dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE customer set cu_name = ?,cu_address = ?,cu_contact = ? ,cu_email = ? WHERE customer_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getContact());
        pstm.setString(4, dto.getEmail());
        pstm.setString(5, dto.getId());


        return pstm.executeUpdate() > 0;*/

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        boolean isUpdated = customerDAO.updateCustomer(new CustomerDTO(dto.getId(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getContact()));
        return isUpdated;
    }

    public List<CustomerDTO> getAllCustomers() throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM customer";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<CustomerDTO> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new CustomerDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return cusList;*/

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();

        ArrayList<CustomerDTO> allCustomer = (ArrayList<CustomerDTO>) customerDAO.getAllCustomers();
        for (CustomerDTO dto : allCustomer){
            new CustomerTm(
                    dto.getId(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getContact(),
                    dto.getEmail()
            );

        }
        return allCustomer;
    }

    public boolean deleteCustomer(String id) throws SQLException{
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM customer WHERE customer_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;*/

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        boolean isDelete = customerDAO.deleteCustomer(id);
        return isDelete;
    }

}




