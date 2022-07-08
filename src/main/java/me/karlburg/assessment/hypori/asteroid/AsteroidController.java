package me.karlburg.assessment.hypori.asteroid;
import me.karlburg.assessment.hypori.filter.FilterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AsteroidController {

    @Autowired
    private FilterFactory factory;

    @Autowired
    private AsteroidService service;

    @GetMapping("/asteroids")
    public List<AsteroidEntity> getAsteroids(@RequestParam MultiValueMap<String, String> params) {
        var set = this.factory.convertParams(params);
        return this.service.getAsteroids();
    }
}