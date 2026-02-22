package vn.edu.hcmut.cse.adsoftweng.lab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name must not be blank")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email is not valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 99, message = "Age must be less than 100")
    @Column(nullable = false)
    private Integer age;
}
