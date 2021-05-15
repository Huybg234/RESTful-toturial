package entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_student")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Student {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "full_name", nullable = false)
    String fullName;

    @Column(name = "birth_day", nullable = false)
    Date birthDay;

    @Column(name = "class_name", nullable = false)
    String className;
}
