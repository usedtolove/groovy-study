import griffon.util.AbstractMapResourceBundle;

import javax.annotation.Nonnull;
import java.util.Map;

import static java.util.Arrays.asList;
import static griffon.util.CollectionUtils.map;

public class Config extends AbstractMapResourceBundle {
    @Override
    protected void initialize(@Nonnull Map<String, Object> entries) {
        map(entries)
            .e("application", map()
                .e("title", "helloGriffonJava")
                .e("startupGroups", asList("helloGriffon"))
                .e("autoShutdown", true)
            )
            .e("mvcGroups", map()
                .e("helloGriffon", map()
                    .e("model", "com.tz.HelloGriffonModel")
                    .e("view", "com.tz.HelloGriffonView")
                    .e("controller", "com.tz.HelloGriffonController")
                )
            );
    }
}