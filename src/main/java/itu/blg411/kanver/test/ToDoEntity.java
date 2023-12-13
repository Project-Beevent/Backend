package itu.blg411.kanver.test;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class ToDoEntity {
    @Id
    private String id;

    private String title;

    private Boolean completed;
}
