package dev.aziz.amazonrestapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Firstname should not be empty")
    private String firstName;

    @NotNull(message = "Lastname should not be empty")
    private String lastName;

    @NotNull(message = "Birth date should not be empty")
    private LocalDate birthDate;

    @NotNull(message = "Login should not be empty")
    @Column(unique = true)
    private String login;

    @NotNull(message = "Password should not be empty")
    private String password;

}
