package me.karlburg.assessment.hypori.asteroid;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.karlburg.assessment.hypori.util.ThreePointConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity @Table(name = "asteroids")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE)
public class AsteroidEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4410992280188782668L;

    @Id @Column(name = "designation")
    private String designation;
    public String getDesignation() { return this.designation; }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "discovery_date")
    private Date discovery_date;
    public Date getDiscoveryDate() { return this.discovery_date; }

    @Column(name = "h_mag")
    private Float h_mag;
    public Float getHMag() { return this.h_mag; }

    @Column(name = "moid_au")
    private Float moid_au;
    public Float getMoidAU() { return this.moid_au; }

    @Column(name = "q_au_1")
    private Float q_au_1;
    public Float getQAU1() { return this.q_au_1; }

    @Column(name = "q_au_2")
    private Float q_au_2;
    public Float getQAU2() { return this.q_au_2; }

    @Column(name = "period_yr")
    private Float period_yr;
    public Float getPeriodYR() { return this.period_yr; }

    @Column(name = "i_deg")
    private Float i_deg;
    public Float getIDeg() { return this.i_deg; }

    @Column(name = "pha")
//    @Convert(converter = ThreePointConverter.class)
    @JsonDeserialize(using = ThreePointConverter.Deserializer.class)
    private Boolean pha;
//    public String getPha() { return this.pha; }

    @Column(name = "orbit_class")
    private String orbit_class;
    public String getOrbitClass() { return this.orbit_class; }
}