package lk.ijse.vehiServePro.bo.custom;

import lk.ijse.vehiServePro.bo.SuperBO;
import lk.ijse.vehiServePro.dto.PaymentDTO;

import java.sql.SQLException;

public interface PaymentBO extends SuperBO {

    boolean savePayment(PaymentDTO dto) throws SQLException;
    boolean updatePayment(PaymentDTO dto) throws SQLException;
    boolean deletePayment(String id) throws SQLException;
}
