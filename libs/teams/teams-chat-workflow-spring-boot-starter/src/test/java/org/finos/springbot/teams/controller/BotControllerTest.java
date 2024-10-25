package org.finos.springbot.teams.controller;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.finos.springbot.teams.MockTeamsConfiguration;
import org.finos.springbot.teams.bot.BotController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.microsoft.bot.builder.Bot;
import com.microsoft.bot.builder.InvokeResponse;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.schema.Activity;

@SpringBootTest(classes = { MockTeamsConfiguration.class})
@ActiveProfiles("teams")
public class BotControllerTest {

	@Mock
	BotFrameworkHttpAdapter adapter;
	
	@Spy
	Bot bot;
	
	@InjectMocks
	BotController controller;
	
	
	@SuppressWarnings({ "deprecation" })
	@Test
	public void testIncoming() throws InterruptedException, ExecutionException {
		Activity a = Mockito.mock(Activity.class);
		InvokeResponse ir = new InvokeResponse(HttpStatus.OK.value(), "Success");
		Mockito.when(adapter.processIncomingActivity("any text", a, bot)).thenReturn(CompletableFuture.completedFuture(ir));
		CompletableFuture<ResponseEntity<Object>> future = controller.incoming(a, "any text");
		
		ResponseEntity<Object> entity = future.get();
		
		Assertions.assertEquals(200, entity.getStatusCodeValue());
		Assertions.assertEquals("Success", entity.getBody());
		
	}
	
}
