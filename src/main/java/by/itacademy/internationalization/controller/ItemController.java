package by.itacademy.internationalization.controller;

import by.itacademy.internationalization.dto.ItemDto;
import by.itacademy.internationalization.entity.enam.Language;
import by.itacademy.internationalization.mapper.ItemMapper;
import by.itacademy.internationalization.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @GetMapping
    public ResponseEntity<ItemDto> get(@RequestParam(value = "code") Integer code,
                                       @RequestParam(value = "language") Language language) {
        return ResponseEntity.ok(itemService.getByCode(code, language));
    }
}
