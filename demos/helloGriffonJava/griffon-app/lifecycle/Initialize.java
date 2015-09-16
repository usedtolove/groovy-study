import griffon.core.GriffonApplication;
import org.codehaus.griffon.runtime.core.AbstractLifecycleHandler;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class Initialize extends AbstractLifecycleHandler {
    @Inject
    public Initialize(@Nonnull GriffonApplication application) {
        super(application);
    }

    @Override
    public void execute() {
        System.out.println("Initialize execute() run...");
        System.out.println("UserData size:"+UserData.getData().size());
    }
}