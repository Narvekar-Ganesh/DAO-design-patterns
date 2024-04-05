package home.pratice.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Data
@Entity
public class MobileNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String countryCode;

    @Column
    private String number;
}
