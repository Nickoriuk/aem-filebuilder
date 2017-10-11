package io.redcastle.aem.filebuilder.model.impl

import io.redcastle.aem.filebuilder.model.api.Node

internal class NodeImpl(override val name: String) : Node {

    override val children: MutableList<Node> = mutableListOf()
    override val attributes: MutableMap<String, Any?> = mutableMapOf()

    init {
        setDefaultPrimaryNodeType()
    }

    private fun setDefaultPrimaryNodeType() = attributes.put("jcr:primaryType", "nt:unstructured")
    override fun toString(): String {
        return "NodeImpl(name='$name', children=$children, attributes=$attributes)"
    }


}
