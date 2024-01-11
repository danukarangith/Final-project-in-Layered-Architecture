package lk.ijse.vehiServePro.bo.custom.impl;

import lk.ijse.vehiServePro.bo.custom.VehicleBO;
import lk.ijse.vehiServePro.dao.DAOFactory;
import lk.ijse.vehiServePro.dao.custom.VehicleDAO;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.dto.VehicleDTO;
import lk.ijse.vehiServePro.entity.Customer;
import lk.ijse.vehiServePro.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleBOImpl implements VehicleBO {
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.VEHICLE);
    @Override
    public List<VehicleDTO> getAllVehicle() throws SQLException {
        List<Vehicle> vehicles = vehicleDAO.getAll();
        List<VehicleDTO> list = new ArrayList<>();

        for (Vehicle vehicle : vehicles){
            list.add(
                    new VehicleDTO(
                             vehicle.getId(),
                             vehicle.getName(),
                            vehicle.getNum(),
                            vehicle.getBrand(),
                            vehicle.getType()

                    )
            );
        }
        return list;
    }
    @Override
    public boolean saveVehicle(VehicleDTO dto) throws SQLException {
        Vehicle entity = new Vehicle(
                 dto.getId(),
                dto.getName(),
                dto.getNum(),
                dto.getBrand(),
                dto.getType()
        );
        return vehicleDAO.save(entity);
    }
    @Override
    public boolean updateVehicle(VehicleDTO dto) throws SQLException {
        Vehicle entity = new Vehicle(
                dto.getId(),
                dto.getName(),
                dto.getNum(),
                dto.getBrand(),
                dto.getType()
        );
        return vehicleDAO.update(entity);
    }
    @Override
    public boolean deleteVehicle(String id) throws SQLException {
        return vehicleDAO.delete(id);
    }
}
