package lk.ijse.vehiServePro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ServiceDetail {
    private String id;
    private String Cuname;
    private String number;
    private String date;
    private String time;
    private String detail;
    private String Ename;

}
