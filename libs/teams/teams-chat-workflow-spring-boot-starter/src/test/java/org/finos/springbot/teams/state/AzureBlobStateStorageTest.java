package org.finos.springbot.teams.state;

import org.finos.springbot.teams.MockTeamsConfiguration;
import org.finos.springbot.teams.TeamsWorkflowConfig;
import org.finos.springbot.workflow.data.DataHandlerConfig;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {
		MockTeamsConfiguration.class, 
		TeamsWorkflowConfig.class,
		DataHandlerConfig.class
})
@ActiveProfiles("teams")
public class AzureBlobStateStorageTest extends AbstractStateStorageTest {

	@Autowired
	EntityJsonConverter ejc;
	
	@BeforeEach
	public void setup() {
		tss = new AzureBlobStateStorage();
	}
	
}
