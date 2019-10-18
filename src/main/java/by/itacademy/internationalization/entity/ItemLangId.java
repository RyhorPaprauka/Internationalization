package by.itacademy.internationalization.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Embeddable
public class ItemLangId implements Serializable {

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "lang_id")
    private Long langId;

    public ItemLangId(Long itemId, Long langId) {
        this.itemId = itemId;
        this.langId = langId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ItemLangId that = (ItemLangId) o;
        return Objects.equals(itemId, that.itemId) && Objects.equals(langId, that.langId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, langId);
    }
}
