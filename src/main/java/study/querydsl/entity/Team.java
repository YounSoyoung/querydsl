package study.querydsl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //JPA는 기본 생성자가 있어야한다. 기본생성자를 protected level까지 허용 -> protected 기본 생성자가 생성된다.
@ToString(of = {"id", "name"})
public class Team {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")   //연관관계 주인 X
    private List<Member> members = new ArrayList<>();

    public Team(String name){
        this.name = name;
    }

}
