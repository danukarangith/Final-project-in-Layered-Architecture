package lk.ijse.vehiServePro.dao;

import lk.ijse.vehiServePro.dto.ReservationDTO;

import java.sql.SQLException;
import java.util.List;

public interface ReservationDAO {

    boolean saveReservation(final ReservationDTO dto) throws SQLException;
    boolean updateReservation( ReservationDTO dto) throws SQLException;
    boolean deleteReservation(String id) throws SQLException;
    List<ReservationDTO> getAllReservation() throws SQLException;

}
