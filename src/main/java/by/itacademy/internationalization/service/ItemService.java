package by.itacademy.internationalization.service;

import by.itacademy.internationalization.dto.ItemDto;
import by.itacademy.internationalization.entity.Item;
import by.itacademy.internationalization.entity.enam.Language;
import by.itacademy.internationalization.mapper.ItemMapper;
import by.itacademy.internationalization.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemDto getByCode(Integer code, Language language) {
        return itemRepository.getByCode(code).map(item -> itemMapper.toDto(item, language))
                .orElseThrow(EntityNotFoundException::new);
    }
}
