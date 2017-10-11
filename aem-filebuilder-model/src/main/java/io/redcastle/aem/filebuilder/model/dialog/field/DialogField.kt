package io.redcastle.aem.filebuilder.model.dialog.field

import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.dialog.SLING_RESOURCETYPE
import io.redcastle.aem.filebuilder.model.impl.NodeImpl


abstract class DialogField(nodeName: String, formName: String, resourceType: String) : Node by NodeImpl(nodeName) {
    init {
        attributes["name"] = formName
        attributes[SLING_RESOURCETYPE] = resourceType
    }
}
