package lk.ijse.gdse.helloshoesbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PositiveOrZero;
import lk.ijse.gdse.helloshoesbackend.Enum.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryDTO implements SuperDTO{

    @Null(message = "Item Code Generate by the programmer")
    private String item_code;
    @NotBlank(message = "Item Description cannot be blank")
    private String item_desc;
    @NotNull(message = "profile picture cannot be null")
    private String pic;
    @NotNull(message = "Item Status cannot be null")
    private ItemStatus status;
    @NotNull(message = "Category cannot be null")
    private String category;
    @NotNull(message = "size cannot be null")
    private String size;
    @NotNull(message = "supplier code cannot be null")
    private String supplier_code;
    @NotNull(message = "Unit Price Sale cannot be null.")
    @PositiveOrZero(message = "Unit Price Sale cannot be negative.")
    private Double unitPriceSale;
    @NotNull(message = "Unit Price Buy cannot be null.")
    @PositiveOrZero(message = "Unit Price Buy cannot be negative.")
    private Double unitPriceBuy;
    @NotNull(message = "Expected Profit Sale cannot be null.")
    @PositiveOrZero(message = "Expected Profit Sale cannot be negative.")
    private Double expectedProfit;
    @NotNull(message = "Profit Margin cannot be null.")
    @PositiveOrZero(message = "profit Margin cannot be negative.")
    private Double profitMargin;

    private String genderCode;
    private String occasionCode;
    private String varietyCode;

}
