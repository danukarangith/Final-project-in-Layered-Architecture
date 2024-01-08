package lk.ijse.vehiServePro.dao.custom;

import lk.ijse.vehiServePro.dto.PaymentDTO;

import java.sql.SQLException;

public interface PaymentDAO {

    boolean savePayment(final PaymentDTO dto) throws SQLException;

    boolean updatePayment( PaymentDTO dto) throws SQLException;

    boolean deletePayment(String id) throws SQLException;
}
