package by.itacademy.internationalization.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String defaultName;

    @Column(name = "code", nullable = false, unique = true)
    private Integer code;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "item_attribute",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private Set<Attribute> attributes = new HashSet<>();

    @OneToMany(mappedBy = "item",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Builder.Default
    private Set<ItemLang> translations = new HashSet<>();

    public void addLang(Lang lang) {
        translations.add(new ItemLang(this, lang));
    }
}
