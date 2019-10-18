package by.itacademy.internationalization.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
@Table(name = "item_lang")
public class ItemLang {

    @EmbeddedId
    private ItemLangId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itemId")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("langId")
    private Lang lang;

    @Column(name = "meaning")
    private String meaning;

    public ItemLang(Item item, Lang lang) {
        this.item = item;
        this.lang = lang;
        this.id = new ItemLangId(item.getId(), lang.getId());
    }
}
