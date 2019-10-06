package by.itacademy.internationalization.mapper;

import by.itacademy.internationalization.dto.ItemDto;
import by.itacademy.internationalization.entity.AttributeLang;
import by.itacademy.internationalization.entity.Item;
import by.itacademy.internationalization.entity.ItemLang;
import by.itacademy.internationalization.entity.enam.Language;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public abstract class ItemMapper {

    public ItemDto toDto(Item item, Language language) {
        if (item == null) {
            return null;
        }

        String name = item.getTranslations().stream()
                .filter(itemLang -> itemLang.getLang().getName().equals(language))
                .map(ItemLang::getMeaning)
                .findFirst()
                .orElse(item.getDefaultName());

        List<String> attributeList = new ArrayList<>();
        item.getAttributes().forEach(attribute -> attributeList.add(attribute.getTranslations().stream()
                .filter(attributeLang -> attributeLang.getLang().getName().equals(language))
                .map(AttributeLang::getMeaning)
                .findFirst()
                .orElse(attribute.getDefaultName())));

        return new ItemDto(name, attributeList);
    }
}
