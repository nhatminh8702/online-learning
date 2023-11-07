package vn.edu.fpt.onlinelearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.fpt.onlinelearning.entity.Dummy;

@Repository
public interface DummyRepository extends JpaRepository<Dummy, Integer> {
}
