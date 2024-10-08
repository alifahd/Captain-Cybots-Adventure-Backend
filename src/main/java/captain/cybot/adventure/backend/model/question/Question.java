package captain.cybot.adventure.backend.model.question;

import captain.cybot.adventure.backend.model.user.Level;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Level level;

    private String type;

    public Question(String type) {
        this.type = type;
    }

    @JsonIgnore
    public String[] getQuestionAnswers() {return null;}
}
