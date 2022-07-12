package me.karlburg.assessment.hypori.asteroid;
import me.karlburg.assessment.hypori.filter.FilterQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class AsteroidService {

    @Autowired
    private AsteroidRepository repository;


    public List<AsteroidEntity> getAsteroids(FilterQuery filterQuery) {
        var finalSpec = Specification.<AsteroidEntity>where(null);
        for(var spec : filterQuery.generateSpecs(AsteroidEntity.class)) {
            finalSpec.and(spec);
        }
        return this.repository.findAll(finalSpec);
    }
}