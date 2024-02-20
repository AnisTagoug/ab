package datacenter.dc.produit.Controler;

import datacenter.dc.exeption.ResourceNotFoundException;
import datacenter.dc.produit.Model.Produit;
import datacenter.dc.produit.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:4200")
@RestController
@Repository
public class FirewallsController {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/produit")
    public List<Produit> getAllFirewalls (){
        return produitRepository.findAll();
    }

    @PostMapping("/produit")
    public Produit createFirewalls(@RequestBody Produit produit) {

        return produitRepository.save(produit);
    }
    @GetMapping("/produit/{id}")
    public ResponseEntity<Produit> getFirewallsById(@PathVariable Long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit not exist with id :" + id));
        return ResponseEntity.ok(produit);
    }
    @PutMapping("/produit/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitdet){
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit not exist with id :" + id));

        produit.setLibelle(produitdet.getLibelle());
        produit.setDescription(produitdet.getDescription());
        produit.setPhoto(produitdet.getPhoto());
        produit.setPrice(produitdet.getPrice());
        produit.setQuantity(produitdet.getQuantity());




        Produit updateProduit = produitRepository.save(produit);
        return ResponseEntity.ok(updateProduit);
    }
    @DeleteMapping("/produit/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFirewalls(@PathVariable Long id){
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit not exist with id :" + id));

        produitRepository.delete(produit);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}


