package lk.ijse.vehiServePro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Reservation {
    private String id;
    private String email;
    private String vehNum;
    private String date;
    private String time;
}
