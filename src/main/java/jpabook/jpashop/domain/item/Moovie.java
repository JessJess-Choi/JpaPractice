package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Getter @Setter
@DiscriminatorValue("M")
public class Moovie extends Item{

    private String director;
    private String actor;
}
