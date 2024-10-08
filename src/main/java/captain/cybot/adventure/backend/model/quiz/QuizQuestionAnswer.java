package captain.cybot.adventure.backend.model.quiz;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class QuizQuestionAnswer {

    private String answer;

    private int questionNumber;
}
