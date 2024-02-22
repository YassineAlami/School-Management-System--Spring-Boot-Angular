package ma.edu.gestionecole.gestionecole.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le Nom est Obligatoire") @Size(max = 30)
    private String nom;
    @NotBlank(message = "Le Prenom est Obligatoire") @Size(max = 30)
    private String prenom;
    @Email
    private String email;
    private String specialite;

    @OneToMany(mappedBy = "enseignant")
    @JsonIgnore
    private List<Cours> cours;
}
