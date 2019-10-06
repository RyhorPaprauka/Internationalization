package by.itacademy.internationalization.repository;

import by.itacademy.internationalization.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> getByCode(Integer code);
}
