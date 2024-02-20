package datacenter.dc.produit.Repository;

import datacenter.dc.produit.Model.Produit;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduitRepository extends MongoRepository<Produit,Long> {
}
