package nl.hu.iac.webshop.restControllers;

import nl.hu.iac.webshop.domain.Categorie;
import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.services.CategorieService;
import nl.hu.iac.webshop.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.unbescape.html.HtmlEscape.escapeHtml5;

@RestController
@RequestMapping(ProductRestController.BASE_URL)
public class ProductRestController {
    static final String BASE_URL="/api/products";
    private final ProductService productService;
    private final CategorieService categorieService;


    public ProductRestController(ProductService productService, CategorieService categorieService) {
        this.productService = productService;
        this.categorieService = categorieService;
    }

    @GetMapping()
    public List<Product> getProducten(){
        return productService.findAllProducts();
    }

    @PostMapping("/get_product")
    public Product getProduct(@RequestBody Product product){
        return productService.findProduct(product.getNaam(), product.getPrijs(), product.getAfbeelding());
    }

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(escapeHtml5InProduct(product));
    }

    @PutMapping("/edit/{id}")
    public Product changeProduct(@RequestBody Product product, @PathVariable Long id) {
        return productService.changeProduct(escapeHtml5InProduct(product), id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/add_categorie/{product_id}/{categorie_id}")
    public void add_Categorie(@PathVariable Long product_id,
                                 @PathVariable Long categorie_id){
       Product product = productService.findById(product_id);
       Categorie categorie = categorieService.findById(categorie_id);

        List<Categorie> categorieLijst = product.getCategories();
        List<Product> productLijst = categorie.getProducts();

        categorieLijst.add(categorie);
        productLijst.add(product);

        product.setCategories(categorieLijst);
        categorie.setProducts(productLijst);

       productService.saveProduct(product);
       categorieService.saveCategorie(categorie);
    }

    private Product escapeHtml5InProduct(Product product) {
        product.setNaam(escapeHtml5(product.getNaam()));
        product.setOmschrijving(escapeHtml5(product.getOmschrijving()));
        product.setAanbiedingprijs(escapeHtml5(product.getAanbiedingprijs()));
        product.setAfbeelding(escapeHtml5(product.getAfbeelding()));

        return product;
    }

}
