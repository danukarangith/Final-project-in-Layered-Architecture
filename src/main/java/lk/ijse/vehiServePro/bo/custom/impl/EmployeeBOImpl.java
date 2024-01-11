package lk.ijse.vehiServePro.bo.custom.impl;

import lk.ijse.vehiServePro.bo.custom.EmployeeBO;
import lk.ijse.vehiServePro.dao.DAOFactory;
import lk.ijse.vehiServePro.dao.custom.EmployeeDAO;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.dto.EmployeeDTO;
import lk.ijse.vehiServePro.entity.Customer;
import lk.ijse.vehiServePro.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO =(EmployeeDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.EMPLOYEE);

    @Override
    public List<EmployeeDTO> getAllEmployee() throws SQLException {
        List<Employee> employees = employeeDAO.getAll();
        List<EmployeeDTO> list = new ArrayList<>();

        for (Employee employee : employees){
            list.add(
                    new EmployeeDTO(
                            employee.getName(),
                            employee.getId(),
                            employee.getAddress(),
                            employee.getContact(),
                            employee.getType(),
                            employee.getUser()
                    )

            );
        }
        return list;
    }

    @Override
    public boolean saveEmployee(EmployeeDTO dto) throws SQLException {
        Employee entity = new Employee(
                dto.getName(),
                dto.getId(),
                dto.getAddress(),
                dto.getContact(),
                dto.getType(),
                dto.getUser()
        );
        return employeeDAO.save(entity);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException {
        Employee entity = new Employee(
                dto.getName(),
                dto.getId(),
                dto.getAddress(),
                dto.getContact(),
                dto.getType(),
                dto.getUser()
        );
        return employeeDAO.update(entity);
    }
    @Override
    public boolean deleteEmployee(String id) throws SQLException {
        return employeeDAO.delete(id);
    }

}
