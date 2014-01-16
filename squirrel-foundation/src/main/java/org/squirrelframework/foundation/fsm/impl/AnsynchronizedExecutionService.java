package org.squirrelframework.foundation.fsm.impl;

import java.util.concurrent.ExecutorService;

import org.squirrelframework.foundation.component.SquirrelConfiguration;
import org.squirrelframework.foundation.fsm.StateMachine;

public class AnsynchronizedExecutionService<T extends StateMachine<T, S, E, C>, S, E, C>
        extends AbstractExecutionService<T, S, E, C> {

    private ExecutorService executorService;

    public AnsynchronizedExecutionService() {
        executorService = SquirrelConfiguration.getExecutor();
    }

    @Override
    public void execute() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                AnsynchronizedExecutionService.super.execute();
            }
        });
    }

}
