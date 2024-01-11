package lk.ijse.vehiServePro.bo.custom;

import lk.ijse.vehiServePro.bo.SuperBO;
import lk.ijse.vehiServePro.dto.ReservationDTO;

import java.sql.SQLException;
import java.util.List;

public interface ReservationBO extends SuperBO {
    List<ReservationDTO> getAllReservation() throws SQLException;
    boolean saveReservation(ReservationDTO dto) throws SQLException;
    boolean updateReservation (ReservationDTO dto) throws SQLException;
    boolean deleteReservation(String id) throws SQLException;
}
