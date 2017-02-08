package tlh;

import com.aust.tlh.controller.TlhV2Controller;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * 类描述:
 * Created by tanglinhui on 2017/1/13.
 * Version 1.0
 */
public class ControllerTest {

    @Test
    public void testController() throws Exception{

        TlhV2Controller controller = new TlhV2Controller();
       // assertEquals("dubboInvoke",controller.dubboInvoke());

        MockMvc mockMvc= standaloneSetup(controller).build();

        mockMvc.perform(post("/")).andExpect(view().name("index.html"));
    }
}
