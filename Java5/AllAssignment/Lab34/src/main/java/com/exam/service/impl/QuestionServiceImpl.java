package com.exam.service.impl;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuestionRepository;
import com.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public void insertExcel() {
        String jdbcUrl = "jdbc:sqlserver://localhost;databaseName=examAssignment";
        String userName = "sa";
        String password = "123";
        String excelFilePath = "D:\\Book2.csv";
        int batchSize = 20;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            connection.setAutoCommit(false);
            String sql = "insert into question\n" +
                    "(ques_id, answer, content, image, option1, option2, option3, option4, quiz_q_id)\n" +
                    "values (?, ?, ?,?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            BufferedReader lineReader = new BufferedReader(new FileReader(excelFilePath));
            String lineText = null;
            int count = 0;
            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String id = data[0];
                String answer = data[1];
                String content = data[2];
                String image = data[3];
                String option1 = data[4];
                String option2 = data[5];
                String option3 = data[6];
                String option4 = data[7];
                String quiz_q_id = data[8];
                statement.setLong(1, Long.parseLong(id));
                statement.setString(2, answer);
                statement.setString(3, content);
                statement.setString(4, image);
                statement.setString(5, option1);
                statement.setString(6, option2);
                statement.setString(7, option3);
                statement.setString(8, option4);
                statement.setLong(9, Long.parseLong(quiz_q_id));
                statement.addBatch();
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
                lineReader.close();
                statement.executeBatch();
                connection.commit();
                lineReader.close();
                System.out.println("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        Question question = new Question();
        question.setQuesId(quesId);
         this.questionRepository.delete(question);
    }

    @Override
    public Question get(Long questionsId) {
        return this.questionRepository.getOne(questionsId);
    }
}
