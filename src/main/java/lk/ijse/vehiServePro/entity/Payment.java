package lk.ijse.vehiServePro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Payment {
    private String id;
    private String name;
    private String amount;
    private String method;
    private String detail;
}
