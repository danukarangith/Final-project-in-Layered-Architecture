package lk.ijse.vehiServePro.dao.custom.impl;

import lk.ijse.vehiServePro.dao.SQLUtil;
import lk.ijse.vehiServePro.dao.custom.EmployeeDAO;
import lk.ijse.vehiServePro.db.DbConnection;
import lk.ijse.vehiServePro.dto.EmployeeDTO;
import lk.ijse.vehiServePro.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean save(final Employee entity) throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getId());
        pstm.setString(3, dto.getContact());
        pstm.setString(4, dto.getAddress());
        pstm.setString(5, dto.getType());
        pstm.setString(6, dto.getUser());*/

       return SQLUtil.excecute("INSERT INTO employee VALUES(?,?,?,?,?,?)",
                        entity.getName(),
                        entity.getId(),
                        entity.getContact(),
                        entity.getAddress(),
                        entity.getType(),
                        entity.getUser()
        );



    }

   @Override
   public boolean update( Employee entity) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();


        String sql = "UPDATE employee set employee_id = ?,emp_address = ? ,emp_contact_number=?,emp_type=?,user_name = ? WHERE emp_name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getContact());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getType());
        pstm.setString(5, dto.getUser());
        pstm.setString(6, dto.getName());



        return pstm.executeUpdate() > 0;*/

      return SQLUtil.excecute("UPDATE employee set employee_id = ?,emp_address = ? ,emp_contact_number=?,emp_type=?,user_name = ? WHERE emp_name = ?",
               entity.getId(),
               entity.getContact(),
               entity.getAddress(),
               entity.getType(),
               entity.getUser(),
               entity.getName()
       );
    }

   @Override
   public boolean delete(String id) throws SQLException{
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM employee WHERE emp_name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);*/

      return SQLUtil.excecute( "DELETE FROM employee WHERE emp_name = ?",id);

       // return pstm.executeUpdate()>0;
    }

   @Override
   public List<Employee> getAll() throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM employee";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();*/
       ResultSet resultSet =SQLUtil.excecute("SELECT * FROM employee");

        List<Employee> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)

            ));
        }
        return cusList;
    }


}
