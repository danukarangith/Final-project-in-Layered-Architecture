package lk.ijse.vehiServePro.bo;

import lk.ijse.vehiServePro.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public  static BOFactory getBoFactory (){
        return (boFactory == null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BoTypes {
        CUSTOMER,EMPLOYEE,PAYMENT,RESERVATION,SERVICE_DETAIL,STOCK,USER,VEHICLE
    }

    public  SuperBO getBO (BoTypes boTypes){

        switch (boTypes){
            case CUSTOMER:
                return  new CustomerBOImpl();

            case EMPLOYEE:
                return new EmployeeBOImpl();

            case PAYMENT:
                return new PaymentBOImpl();

            case RESERVATION:
                return new ReservationBOImpl();

            case SERVICE_DETAIL:
                return new ServiceDetailBOImpl();

            case STOCK:
                return new StockBOImpl();

            case USER:
                return new UserBOImpl();

            case VEHICLE:
                return new VehicleBOImpl();

            default:
                return null;
        }

    }

}
