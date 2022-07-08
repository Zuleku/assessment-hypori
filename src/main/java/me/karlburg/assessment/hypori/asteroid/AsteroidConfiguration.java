package me.karlburg.assessment.hypori.asteroid;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import java.io.IOException;
import java.util.List;

@Configuration
public class AsteroidConfiguration {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private AsteroidRepository repository;

    @EventListener(ContextRefreshedEvent.class)
    public void eventLoadAsteroidData() {
        var type = new TypeReference<List<AsteroidEntity>>(){};
        try(var stream = TypeReference.class.getResourceAsStream("/memory/2vr3-k9wn.json")) {
            var asteroids = this.mapper.readValue(stream, type);
            this.repository.saveAll(asteroids);
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}