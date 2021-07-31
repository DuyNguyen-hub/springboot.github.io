package com.spring.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMesage {
    @Size(min = 4, max = 30, message = "Name must between 5 and 30")
    @NotBlank(message = "name cannot null")
    private String name;
    @Size(min=4)
    @NotBlank(message = "phone cannot null")
    private String phone;
    @NotBlank(message = "email cannot null")
    private String email;
}
