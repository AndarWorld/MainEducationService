package org.andarworld.maineducationservice.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "universities")
@Builder(setterPrefix = "with")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID uuid;

    @Column
    private String title;

    @Column
    private String city;

    @Column
    private String description;

    @Column
    private LocalDate periodFrom;

    @Column
    private Boolean governmentStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(title, that.title) && Objects.equals(city, that.city) && Objects.equals(description, that.description) && Objects.equals(periodFrom, that.periodFrom) && Objects.equals(governmentStatus, that.governmentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, city, description, periodFrom, governmentStatus);
    }

    @Override
    public String toString() {
        return "University{" +
                "title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", periodFrom=" + periodFrom +
                ", governmentStatus=" + governmentStatus +
                '}';
    }
}
