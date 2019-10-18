package by.itacademy.internationalization.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Embeddable
public class AttributeLangId implements Serializable {

    @Column(name = "attribute_id")
    private Long attributeId;

    @Column(name = "lang_id")
    private Long langId;

    public AttributeLangId(Long attributeId, Long langId) {
        this.attributeId = attributeId;
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

        AttributeLangId that = (AttributeLangId) o;
        return Objects.equals(attributeId, that.attributeId) && Objects.equals(langId, that.langId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeId, langId);
    }
}
