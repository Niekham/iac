package nl.hu.iac.webshop.restControllers;

import nl.hu.iac.webshop.DTO.AanbiedingDTO;
import nl.hu.iac.webshop.domain.Aanbieding;
import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.services.AanbiedingService;
import nl.hu.iac.webshop.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.unbescape.html.HtmlEscape.escapeHtml5;


@RestController
@RequestMapping(AanbiedingRestController.BASE_URL)
public class AanbiedingRestController {
    static final String BASE_URL = "/api/aanbieding";
    private final AanbiedingService aanbiedingService;
    private final ProductService productService;

    public AanbiedingRestController(AanbiedingService aanbiedingService,ProductService productService) {
        this.productService = productService;
        this.aanbiedingService = aanbiedingService;
    }

    @GetMapping()
    public List<Aanbieding> getAanbiedingen() {
        return aanbiedingService.getAanbiedingen();
    }

    @GetMapping("/getAanbiedingen")
    public List<Aanbieding> getAanbiedingenWithoutProducts() {
        return aanbiedingService.getAanbiedingenWithoutProducts();
    }

    @GetMapping("/{id}")
    public Aanbieding getAanbiedingById(@PathVariable Long id) {
        return aanbiedingService.getAanbiedingenById(id);
    }

    @PostMapping("/add")
    public Aanbieding saveAanbieding(@RequestBody AanbiedingDTO aanbiedingDTO) {
        Aanbieding aanbieding = new Aanbieding();
        aanbieding.setVanDatum(escapeHtml5(aanbiedingDTO.getVanDatum()));
        aanbieding.setTotDatum(escapeHtml5(aanbiedingDTO.getTotDatum()));
        aanbieding.setPercentage(aanbiedingDTO.getPercentage());
        return aanbiedingService.saveAanbieding(aanbieding);
    }

    @PostMapping("/add_product/{product_id}/{aanbieding_id}")
    public void addAanbieding(@PathVariable Long product_id,@PathVariable Long aanbieding_id){
        Product product = productService.findById(product_id);
        Aanbieding aanbieding = aanbiedingService.getAanbiedingenById(aanbieding_id);
        product.setAanbieding(aanbieding);
        productService.saveProduct(product);

    }

    @PostMapping("/edit/{id}")
    public Aanbieding changeAanbieding(@RequestBody Aanbieding aanbieding, @PathVariable Long id){
        return aanbiedingService.changeAanbieding(aanbieding, id);
    }
}
