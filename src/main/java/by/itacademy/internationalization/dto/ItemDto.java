package by.itacademy.internationalization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ItemDto {

    private String itemName;
    private List<String> attributeNames;
}
