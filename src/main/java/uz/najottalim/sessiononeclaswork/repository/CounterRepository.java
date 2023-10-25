package uz.najottalim.sessiononeclaswork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.sessiononeclaswork.entity.Counter;

import java.util.Optional;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {


    Optional<Counter> findBySession(String s);
}
