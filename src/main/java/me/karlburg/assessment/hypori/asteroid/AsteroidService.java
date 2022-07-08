package me.karlburg.assessment.hypori.asteroid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsteroidService {

    @Autowired
    private AsteroidRepository repository;


    public List<AsteroidEntity> getAsteroids() {
        return this.repository.findAll();
    }
}