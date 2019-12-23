package krissto87.charity.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Getter @Setter
@ToString @EqualsAndHashCode(of = "id")
public class Role {

    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
}
