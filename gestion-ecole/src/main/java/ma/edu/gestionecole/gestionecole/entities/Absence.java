package ma.edu.gestionecole.gestionecole.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Absence
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateAbsence;
    @Column(columnDefinition = "VARCHAR(150) DEFAULT 'Sans justification '")
    private String motif;

    @ManyToOne
    @NotNull
    private Etudiant etudiant;

    @ManyToOne
    @NotNull
    private Matiere matiere;
}
