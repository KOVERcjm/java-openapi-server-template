package kovercheng.myapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "test")
public class TestPostgres {
    @Id
    @NotBlank
    private String key;

    @NotBlank
    private int value;
}
