

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import com.nexis.interfaces.SpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={SpringConfig.class})
@ActiveProfiles("local")
public class LocalProfileTest {

	@Autowired
	private Properties getApplicationProperties;	
	
	@Test
	public void testLocalProperties() {
		assertNotNull(getApplicationProperties);				
		System.out.println("email.attachment.folder = " + getApplicationProperties.getProperty("email.attachment.folder"));		
		assert(true);
	}

}
