package krissto87.charity.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "institutions")
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false, unique = true)
    private String name;
    @Column (nullable = false)
    private String description;
}
