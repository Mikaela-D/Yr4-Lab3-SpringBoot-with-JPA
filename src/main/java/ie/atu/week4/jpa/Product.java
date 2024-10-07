package ie.atu.week4.jpa;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    @NotBlank(message = "Product name is mandatory")
    private String productName;
    @NotBlank(message = "Product description is mandatory")
    private String productDescription;
    @Min(value = 0, message = "Product price must be non-negative")
    private int productPrice;
    @NotNull(message = "Product code is mandatory")
    private int productCode;
}
