package lk.ijse.vehiServePro.bo.custom.impl;

import lk.ijse.vehiServePro.bo.custom.SupplierBO;
import lk.ijse.vehiServePro.dao.DAOFactory;
import lk.ijse.vehiServePro.dao.custom.SupplierDAO;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.dto.SupplierDTO;
import lk.ijse.vehiServePro.entity.Customer;
import lk.ijse.vehiServePro.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.SUPPLIER);

    @Override
    public List<SupplierDTO> getAllSupplier() throws SQLException {
        List<Supplier> suppliers = supplierDAO.getAll();
        List<SupplierDTO> list = new ArrayList<>();

        for (Supplier supplier : suppliers){
            list.add(
                    new SupplierDTO(
                            supplier.getId(),
                            supplier.getName(),
                            supplier.getAddress()
                    )
            );
        }
        return list;
    }
    @Override
    public boolean saveSupplier(SupplierDTO dto) throws SQLException {
        Supplier entity = new Supplier(
                 dto.getId(),
                dto.getName(),
                dto.getAddress()
        );
        return supplierDAO.save(entity);
    }
    @Override
    public boolean updateSupplier(SupplierDTO dto) throws SQLException {
        Supplier entity = new Supplier(
                dto.getId(),
                dto.getName(),
                dto.getAddress()

        );
        return supplierDAO.update(entity);
    }
    @Override
    public boolean deleteSupplier(String id) throws SQLException {
        return supplierDAO.delete(id);
    }

}
