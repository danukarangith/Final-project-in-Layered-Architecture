package lk.ijse.vehiServePro.model;

import lk.ijse.vehiServePro.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.vehiServePro.dto.EmployeeDTO;
import lk.ijse.vehiServePro.dto.tm.EmployeeTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
   /* public boolean saveEmployee(final EmployeeDTO dto) throws SQLException {
       *//* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getId());
        pstm.setString(3, dto.getContact());
        pstm.setString(4, dto.getAddress());
        pstm.setString(5, dto.getType());
        pstm.setString(6, dto.getUser());

        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;*//*

        EmployeeDAOImpl  employeeDAO = new EmployeeDAOImpl();
        boolean isSaved = employeeDAO.saveEmployee(new EmployeeDTO(dto.getName(),dto.getId(),dto.getContact(),dto.getAddress(),dto.getType(),dto.getUser()));
        return isSaved;
    }
    public boolean updateEmployee( EmployeeDTO dto) throws SQLException {
       *//* Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE employee set employee_id = ?,emp_address = ? ,emp_contact_number=?,emp_type=?,user_name = ? WHERE emp_name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getContact());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getType());
        pstm.setString(5, dto.getUser());
        pstm.setString(6, dto.getName());



        return pstm.executeUpdate() > 0;*//*
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        boolean isUpdate = employeeDAO.updateEmployee(new EmployeeDTO(dto.getName(),dto.getId(),dto.getAddress(),dto.getContact(),dto.getType(),dto.getUser()));
        return isUpdate;
    }

    public boolean deleteCustomer(String id) throws SQLException{
       *//* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM employee WHERE emp_name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;*//*

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        boolean isDelete = employeeDAO.deleteCustomer(id);
        return isDelete;
    }

    public List<EmployeeDTO> getAllEmployee() throws SQLException {
        *//*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM employee";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<EmployeeDTO> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new EmployeeDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)

            ));
        }
        return cusList;*//*
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        ArrayList<EmployeeDTO> allEmployee = (ArrayList<EmployeeDTO>) employeeDAO.getAllEmployee();
        for (EmployeeDTO dto : allEmployee){
            new EmployeeTm(
                    dto.getName(),
                    dto.getId(),
                    dto.getAddress(),
                    dto.getContact(),
                    dto.getType(),
                    dto.getUser()


            );

        }
        return allEmployee;
    }

*/
}
