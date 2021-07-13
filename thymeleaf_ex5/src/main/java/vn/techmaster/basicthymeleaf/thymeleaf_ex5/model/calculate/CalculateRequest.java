package vn.techmaster.basicthymeleaf.thymeleaf_ex5.model.calculate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculateRequest {
    private float x;
    private float y;
}
