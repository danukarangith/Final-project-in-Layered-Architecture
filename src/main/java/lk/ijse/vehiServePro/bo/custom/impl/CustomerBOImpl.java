package lk.ijse.vehiServePro.bo.custom.impl;

import lk.ijse.vehiServePro.bo.custom.CustomerBO;
import lk.ijse.vehiServePro.dao.DAOFactory;
import lk.ijse.vehiServePro.dao.custom.CustomerDAO;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.CUSTOMER);

    @Override
    public List<CustomerDTO> getAllCustomer() throws SQLException {
        List<Customer> customers = customerDAO.getAll();
        List<CustomerDTO> list = new ArrayList<>();

        for (Customer customer : customers){
            list.add(
                    new CustomerDTO(
                            customer.getId(),
                            customer.getName(),
                            customer.getAddress(),
                            customer.getEmail(),
                            customer.getContact()
                    )
            );
        }
        return list;
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException {
        Customer entity = new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getContact()
        );
        return customerDAO.save(entity);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException {
        Customer entity = new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getContact()
        );
        return customerDAO.update(entity);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerDAO.delete(id);
    }
}
