package org.finos.springbot.workflow.java.resolvers;

import java.util.Map;
import java.util.Optional;

import org.finos.springbot.workflow.actions.FormAction;
import org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor;
import org.springframework.core.MethodParameter;

public class EntityMapResolverFactory implements WorkflowResolverFactory {

	@Override
	public WorkflowResolver createResolver(ChatHandlerExecutor che) {

		return new WorkflowResolver() {

			@Override
			public Optional<Object> resolve(MethodParameter mp) {
				if (che.action() instanceof FormAction fa) {
					Class<?> t = mp.getParameterType();
                    Map<String, Object> entityMap = fa.getData();
					return entityMap.values().stream()
							.filter(v -> v.getClass().isAssignableFrom(t))
							.findFirst();
				} else {
					return Optional.empty();
				}
			}

			@Override
			public boolean canResolve(MethodParameter mp) {
				return resolve(mp).isPresent();
			}
		};
	}

}
