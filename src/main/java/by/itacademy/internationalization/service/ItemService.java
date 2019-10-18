package by.itacademy.internationalization.service;

import by.itacademy.internationalization.entity.Item;
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

    public Item getByCode(Integer code) {
        return itemRepository.getByCode(code)
                .orElseThrow(EntityNotFoundException::new);
    }
}
