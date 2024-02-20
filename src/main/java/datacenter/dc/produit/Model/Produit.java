package datacenter.dc.produit.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Document (collection = "Produit")
public class Produit {


        @Id
        private Long id;
        private String libelle;
        private String photo;
        private String description;
        private float price;
        private int quantity;

}
