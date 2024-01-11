package lk.ijse.vehiServePro.bo.custom.impl;

import lk.ijse.vehiServePro.bo.custom.PaymentBO;
import lk.ijse.vehiServePro.dao.DAOFactory;
import lk.ijse.vehiServePro.dao.custom.PaymentDAO;
import lk.ijse.vehiServePro.dto.CustomerDTO;
import lk.ijse.vehiServePro.dto.PaymentDTO;
import lk.ijse.vehiServePro.entity.Customer;
import lk.ijse.vehiServePro.entity.Payment;

import java.sql.SQLException;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.PAYMENT);

    @Override
    public boolean savePayment(PaymentDTO dto) throws SQLException {
        Payment entity = new Payment(
                 dto.getId(),
                dto.getName(),
                dto.getAmount(),
                dto.getMethod(),
                dto.getDetail()

        );
        return paymentDAO.save(entity);
    }
    @Override
    public boolean updatePayment(PaymentDTO dto) throws SQLException {
        Payment entity = new Payment(
                dto.getId(),
                dto.getName(),
                dto.getAmount(),
                dto.getMethod(),
                dto.getDetail()

        );
        return paymentDAO.update(entity);
    }
    @Override
    public boolean deletePayment(String id) throws SQLException {
        return paymentDAO.delete(id);
    }
}
