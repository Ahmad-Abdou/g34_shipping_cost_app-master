package se.lexicon.repositroy;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.entity.Box;

public interface BoxRepository extends CrudRepository<Integer, Box> {
}
