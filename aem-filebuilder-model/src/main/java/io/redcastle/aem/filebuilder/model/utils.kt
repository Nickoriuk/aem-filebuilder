package io.redcastle.aem.filebuilder.model

import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.dialog.SLING_RESOURCETYPE
import io.redcastle.aem.filebuilder.model.impl.NodeImpl

/*
 * Generic method to support other types
 */
internal fun array(type: JcrPropertyType, values: List<Any>): String {
    return values.joinToString(prefix = "{${type.jcrName}}[", separator = ",", postfix = "]")
}

/**
 * Create a new node and attaches it to the receiver.
 */
internal fun Node.attachNewChild(name: String): Node = attachNewChild(name, null)

internal fun Node.items() : Node {
    val items: Node? = getChildByName("items")
    return if (items != null) items else attachNewChild("items")
}

// TODO: Look at replacing List<Node> children with Map<String, Node> children
// For now move the logic of get child by name into this method to make refactor-friendly
internal fun Node.getChildByName(name: String): Node? = children.firstOrNull { it.name == name }


internal fun Node.attachNewChild(name: String, resourceType: String?) : Node {
    val newChildNode = NodeImpl(name)
    if (resourceType != null) {
        newChildNode.attributes[SLING_RESOURCETYPE] = resourceType
    }
    children += newChildNode
    return newChildNode
}
interface JcrPropertyType {
    val jcrName: String
}
enum class JcrPropertyTypes(override val jcrName: String) : JcrPropertyType {
    STRING("String"),
    BINARY("Binary"),
    LONG("Long"),
    DOUBLE("Double"),
    DECIMAL("Decimal"),
    DATE("Date"),
    BOOLEAN("Boolean"),
    NAME("Name"),
    PATH("Path"),
    REFERENCE("Reference"),
    WEAKREFERENCE("WeakReference"),
    URI("URI"),
    UNDEFINED("undefined")
}
