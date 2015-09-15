package com.tz;

import griffon.core.artifact.GriffonController;
import griffon.metadata.ArtifactProviderFor;
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController;

import griffon.transform.Threading;

@ArtifactProviderFor(GriffonController.class)
public class HelloGriffonController extends AbstractGriffonController {
    private HelloGriffonModel model;

    public void setModel(HelloGriffonModel model) {
        this.model = model;
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    public void click() {
        int count = Integer.parseInt(model.getClickCount());
        model.setClickCount(String.valueOf(count + 1));
    }
}