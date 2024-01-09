package lk.ijse.vehiServePro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vehicle {
    private String id;
    private String name;
    private String num;
    private String brand;
    private String Type;
}
