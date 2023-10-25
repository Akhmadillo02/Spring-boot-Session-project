package uz.najottalim.sessiononeclaswork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Where(clause = "is_active = true")
public class Counter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String session;

    private Integer count = 0;
    private boolean isActive =true;

    public  Counter(String session) {
        this.session = session;
    }

    public void increment() {
        this.count++;
    }
}
