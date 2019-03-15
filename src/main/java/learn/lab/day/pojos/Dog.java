package learn.lab.day.pojos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Dog {
    private String name;
    private Integer age;
}
