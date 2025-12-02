package com.example.miniquiz_wojciechjaskiewicz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    TextView titleText, questionText, scoreText;
    Button startButton, resetButton, answerA, answerB, answerC;

    ArrayList<Question> allQuestions = new ArrayList<>();
    ArrayList<Question> selectedQuestions = new ArrayList<>();

    int score = 0;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText = findViewById(R.id.titleText);
        questionText = findViewById(R.id.questionText);
        scoreText = findViewById(R.id.scoreText);
        startButton = findViewById(R.id.startButton);
        resetButton = findViewById(R.id.resetButton);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);

        loadQuestions();

        startButton.setOnClickListener(v -> startQuiz());
        resetButton.setOnClickListener(v -> resetQuiz());

        answerA.setOnClickListener(v -> checkAnswer(answerA.getText().toString()));
        answerB.setOnClickListener(v -> checkAnswer(answerB.getText().toString()));
        answerC.setOnClickListener(v -> checkAnswer(answerC.getText().toString()));
    }

    void loadQuestions() {
        allQuestions.add(new Question("Stolica Włoch to:", "Rzym", "Paryż", "Madryt", "Rzym"));
        allQuestions.add(new Question("Największy ocean:", "Spokojny", "Atlantycki", "Indyjski", "Spokojny"));
        allQuestions.add(new Question("Ile dni ma rok:", "365", "300", "500", "365"));
        allQuestions.add(new Question("Planeta czerwona:", "Mars", "Ziemia", "Merkury", "Mars"));
        allQuestions.add(new Question("Pierwiastek H to:", "Wodór", "Hel", "Wapń", "Wodór"));
    }

    void startQuiz() {
        score = 0;
        scoreText.setText("Wynik: 0");
        currentIndex = 0;

        Collections.shuffle(allQuestions);
        selectedQuestions = new ArrayList<>(allQuestions.subList(0, 5));

        startButton.setVisibility(View.GONE);
        showQuestion();
    }

    void showQuestion() {
        Question q = selectedQuestions.get(currentIndex);

        questionText.setVisibility(View.VISIBLE);
        answerA.setVisibility(View.VISIBLE);
        answerB.setVisibility(View.VISIBLE);
        answerC.setVisibility(View.VISIBLE);

        questionText.setText(q.text);
        answerA.setText(q.answerA);
        answerB.setText(q.answerB);
        answerC.setText(q.answerC);
    }

    void checkAnswer(String selected) {
        Question q = selectedQuestions.get(currentIndex);

        if (selected.equals(q.correct)) {
            score++;
            scoreText.setText("Wynik: " + score);
        }

        currentIndex++;

        if (currentIndex >= 5) {
            questionText.setText("Koniec quizu! Twój wynik: " + score + " / 5");
            answerA.setVisibility(View.GONE);
            answerB.setVisibility(View.GONE);
            answerC.setVisibility(View.GONE);
        } else {
            showQuestion();
        }
    }

    void resetQuiz() {
        score = 0;
        scoreText.setText("Wynik: 0");

        startButton.setVisibility(View.VISIBLE);

        questionText.setVisibility(View.GONE);
        answerA.setVisibility(View.GONE);
        answerB.setVisibility(View.GONE);
        answerC.setVisibility(View.GONE);

        currentIndex = 0;
    }
}
