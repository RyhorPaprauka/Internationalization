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
@Entity
@Table(name = "attribute_lang")
public class AttributeLang {

    @EmbeddedId
    private AttributeLangId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("attributeId")
    private Attribute attribute;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("langId")
    private Lang lang;

    @Column(name = "meaning")
    private String meaning;

    public AttributeLang(Attribute attribute, Lang lang) {
        this.attribute = attribute;
        this.lang = lang;
        this.id = new AttributeLangId(attribute.getId(), lang.getId());
    }
}
