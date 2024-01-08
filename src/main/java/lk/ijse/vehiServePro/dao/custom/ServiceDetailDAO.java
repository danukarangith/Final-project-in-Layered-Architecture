package lk.ijse.vehiServePro.dao.custom;

import lk.ijse.vehiServePro.dto.ServiceDetailDTO;

import java.sql.SQLException;

public interface ServiceDetailDAO {
    boolean saveDetail(final ServiceDetailDTO dto) throws SQLException;
    boolean updateDetail( ServiceDetailDTO dto) throws SQLException;
    boolean deleteDetail(String id) throws SQLException;
}