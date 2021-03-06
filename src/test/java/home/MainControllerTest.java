package home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by hsenid on 5/4/17.
 */

@Test
@ContextConfiguration(locations ={"classpath:spring-test-config.xml" })
//@ContextConfiguration("*/hsenid/WEB-INF/spring-servlet.xml")

@WebAppConfiguration
public class MainControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeMethod
    public void setWac(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    //test for navigating to welcome page
    @Test
    public void getWelcomeViewTest() throws Exception {
        this.mockMvc.perform(get("/")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"));
    }

    //test for navigating to admin page
    @Test
    public void getAdminViewTest() throws Exception {
        this.mockMvc.perform(get("/admin")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(view().name("admin"));
    }

    //test for navigating to translate page
    @Test
    public void getViewTest() throws Exception {
        this.mockMvc.perform(get("/translate")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(view().name("translate"));
    }


}
