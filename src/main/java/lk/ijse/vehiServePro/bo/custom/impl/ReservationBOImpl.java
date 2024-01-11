package lk.ijse.vehiServePro.bo.custom.impl;

import lk.ijse.vehiServePro.bo.custom.ReservationBO;
import lk.ijse.vehiServePro.dao.DAOFactory;
import lk.ijse.vehiServePro.dao.custom.ReservationDAO;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.dto.ReservationDTO;
import lk.ijse.vehiServePro.entity.Customer;
import lk.ijse.vehiServePro.entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 public class ReservationBOImpl implements ReservationBO {

    ReservationDAO reservationDAO =(ReservationDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.RESERVATION);

 @Override
public List<ReservationDTO> getAllReservation() throws SQLException {
     List<Reservation> reservations = reservationDAO.getAll();
     List<ReservationDTO> list = new ArrayList<>();

     for (Reservation reservation : reservations) {
         list.add(
                 new ReservationDTO(
                         reservation.getId(),
                         reservation.getEmail(),
                         reservation.getVehNum(),
                         reservation.getDate(),
                         reservation.getTime()

                 )
         );
     }
     return list;
 }

     @Override
     public boolean saveReservation(ReservationDTO dto) throws SQLException {
         Reservation entity = new Reservation(
                  dto.getId(),
                 dto.getEmail(),
                 dto.getVehNum(),
                 dto.getDate(),
                 dto.getTime()
         );
         return reservationDAO.save(entity);
     }

     @Override
     public boolean updateReservation (ReservationDTO dto) throws SQLException {
         Reservation entity = new Reservation(
                  dto.getId(),
                 dto.getEmail(),
                 dto.getVehNum(),
                 dto.getDate(),
                 dto.getTime()
         );
         return reservationDAO.update(entity);
     }

     @Override
     public boolean deleteReservation(String id) throws SQLException {
         return reservationDAO.delete(id);
     }
}
