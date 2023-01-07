package junit;

import java.time.Instant;
import java.util.Objects;

public class MyDto {

    private String name;

    private Integer age;

    private Instant created;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDto myDto = (MyDto) o;
        return Objects.equals(name, myDto.name) && Objects.equals(age, myDto.age) && Objects.equals(created, myDto.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, created);
    }

    @Override
    public String toString() {
        return "MyDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", crated=" + created +
                '}';
    }
}
