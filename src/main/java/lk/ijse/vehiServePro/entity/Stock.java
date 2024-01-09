package lk.ijse.vehiServePro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Stock {
    private String id;
    private String name;
    private String price;
    private String remain;
    private String user;
}
