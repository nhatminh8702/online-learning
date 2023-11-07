package vn.edu.fpt.onlinelearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.fpt.onlinelearning.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
