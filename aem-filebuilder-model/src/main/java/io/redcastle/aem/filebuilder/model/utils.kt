package io.redcastle.aem.filebuilder.model

import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.dialog.SLING_RESOURCETYPE
import io.redcastle.aem.filebuilder.model.impl.NodeImpl

/*
 * Generic method to support other types
 */
private fun vaultArray(type: String, values: List<Any>): String {
    return values.joinToString(prefix = "{$type}[", separator = ",", postfix = "]")
}

/**
 * Create a new node and attaches it to the receiver.
 */
internal fun Node.attachNewChild(name: String): Node = attachNewChild(name, null)

internal fun Node.attachNewChild(name: String, resourceType: String?) : Node {
    val newChildNode = NodeImpl(name)
    if (resourceType != null) {
        newChildNode.attributes[SLING_RESOURCETYPE] = resourceType
    }
    children += newChildNode
    return newChildNode
}
