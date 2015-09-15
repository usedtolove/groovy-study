package com.tz

import griffon.core.artifact.GriffonModel
import griffon.transform.FXObservable
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonModel)
class HelloGriffonModel {
    @FXObservable String clickCount = "0"
}
