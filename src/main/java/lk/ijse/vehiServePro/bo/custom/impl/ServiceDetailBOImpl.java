package lk.ijse.vehiServePro.bo.custom.impl;

import lk.ijse.vehiServePro.bo.custom.ServiceDetailBO;
import lk.ijse.vehiServePro.dao.DAOFactory;
import lk.ijse.vehiServePro.dao.custom.ServiceDetailDAO;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.dto.ServiceDetailDTO;
import lk.ijse.vehiServePro.entity.Customer;
import lk.ijse.vehiServePro.entity.ServiceDetail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDetailBOImpl implements ServiceDetailBO {

    ServiceDetailDAO serviceDetailDAO = (ServiceDetailDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.SERVICE_DETAIL);


    @Override
    public List<ServiceDetailDTO> getAllServiceDetail() throws SQLException {
        List<ServiceDetail> serviceDetails = serviceDetailDAO.getAll();
        List<ServiceDetailDTO> list = new ArrayList<>();

        for (ServiceDetail serviceDetail : serviceDetails) {
            list.add(
                    new ServiceDetailDTO(
                            serviceDetail.getId(),
                            serviceDetail.getCuname(),
                            serviceDetail.getNumber(),
                            serviceDetail.getDate(),
                            serviceDetail.getTime(),
                            serviceDetail.getDetail(),
                            serviceDetail.getEname()
                    )
            );
        }
        return list;
    }
    @Override
    public boolean saveServiceDetail(ServiceDetailDTO dto) throws SQLException {
        ServiceDetail entity = new ServiceDetail(
                 dto.getId(),
                dto.getCuname(),
                dto.getNumber(),
                dto.getDate(),
                dto.getTime(),
                dto.getDetail(),
                dto.getEname()
        );
        return serviceDetailDAO.save(entity);
    }
    @Override
    public boolean updateServiceDetail(ServiceDetailDTO dto) throws SQLException {
        ServiceDetail entity = new ServiceDetail(
                dto.getId(),
                dto.getCuname(),
                dto.getNumber(),
                dto.getDate(),
                dto.getTime(),
                dto.getDetail(),
                dto.getEname()
        );
        return serviceDetailDAO.update(entity);
    }
    @Override
    public boolean deleteServiceDetail(String id) throws SQLException {
        return serviceDetailDAO.delete(id);
    }
}