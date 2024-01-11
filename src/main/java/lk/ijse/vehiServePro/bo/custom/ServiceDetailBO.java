package lk.ijse.vehiServePro.bo.custom;

import lk.ijse.vehiServePro.bo.SuperBO;
import lk.ijse.vehiServePro.dto.ServiceDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface ServiceDetailBO extends SuperBO {
    List<ServiceDetailDTO> getAllServiceDetail() throws SQLException;
    boolean saveServiceDetail(ServiceDetailDTO dto) throws SQLException;
    boolean updateServiceDetail(ServiceDetailDTO dto) throws SQLException;
    boolean deleteServiceDetail(String id) throws SQLException;
}
