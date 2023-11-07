package vn.edu.fpt.onlinelearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.fpt.onlinelearning.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
