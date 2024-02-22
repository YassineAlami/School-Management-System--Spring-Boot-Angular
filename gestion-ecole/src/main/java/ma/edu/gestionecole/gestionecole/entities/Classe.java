package ma.edu.gestionecole.gestionecole.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Classe
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le Nom est Obligatoire") @Size(max = 30)
    private String nom;
    @Max(25)
    private int capacite = 0;
    private int anneeScolaire = Calendar.getInstance().get(Calendar.YEAR);

    @OneToMany(mappedBy = "classe",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Etudiant> etudiants;

    @ManyToMany
    @JoinTable(
            /*name = "classe_cours",
            joinColumns = @JoinColumn(name = "classe_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id")*/
    )
    private List<Cours> cours;

    @ManyToOne
    private Enseignant enseignantPrincipal;

/*    public int getNumberOfEtudiants() {
        if (etudiants != null) {
            return etudiants.size();
        } else {
            return 0;
        }
    }*/
}