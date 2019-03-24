package nl.hu.iac.webshop;


import nl.hu.iac.webshop.domain.Product;
import nl.hu.iac.webshop.restControllers.ProductRestController;
import nl.hu.iac.webshop.services.CategorieService;
import nl.hu.iac.webshop.services.ProductService;
import nl.hu.iac.webshop.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductRestController.class)
public class ProductTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private UserService userService;

    @MockBean
    private CategorieService categorieService;

    @Test
    public void getProducts() throws Exception {
        Product test = new Product();
        test.setNaam("test");
        List<Product> list = new ArrayList<>();
        list.add(test);

        given(productService.findAllProducts()).willReturn(list);

        mvc.perform(get("/api/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].naam", is(test.getNaam())));
    }
}


