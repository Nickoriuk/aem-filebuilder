package io.redcastle.aem.filebuilder.model.impl

import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.dialog.SLING_RESOURCETYPE

internal fun nodeWithResourceType(name: String, resourceType: String, init: (Node.() -> Unit)? = null): Node {
    val node = NodeImpl(name)
    node.attributes[SLING_RESOURCETYPE] = resourceType

    if (init != null) node.init()

    return node
}

@DslMarker
annotation class VaultDsl
