package lk.ijse.vehiServePro.dao;

import lk.ijse.vehiServePro.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory (){
        return (daoFactory == null)? daoFactory =new DAOFactory() : daoFactory;
    }

    public enum DaoTypes {
        CUSTOMER,EMPLOYEE,PAYMENT,RESERVATION,SERVICE_DETAIL,STOCKS,SUPPLIER,VEHICLE


    }

    public SuperDAO getDao (DaoTypes daoTypes) {
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();

            case EMPLOYEE:
                return new EmployeeDAOImpl();

            case PAYMENT:
                return new PaymentDAOImpl();

            case RESERVATION:
                return new ReservationDAOImpl();

            case SERVICE_DETAIL:
                return new ServiceDetailDAOImpl();

            case STOCKS:
                return new StocksDAOImpl();

            case SUPPLIER:
                return new SupplierDAOImpl();

            case VEHICLE:
                return new VehicleDAOImpl();

            default:
                return null;
        }
    }
}
