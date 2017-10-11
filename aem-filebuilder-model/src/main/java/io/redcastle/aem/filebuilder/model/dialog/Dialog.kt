package io.redcastle.aem.filebuilder.model.dialog

import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.impl.NodeImpl
import io.redcastle.aem.filebuilder.model.impl.nodeWithResourceType


/**
 * Type representing a Touch UI Dialog in AEM 6.1.
 */
class Dialog(title: String, private val layout: Layout = StandardLayouts.NAV_TABS) : Node by NodeImpl("cq:dialog"), FormFieldContainer {

    private val dialogContent = nodeWithResourceType("content", "granite/ui/components/foundation/container")

    init {
        attributes["jcr:title"] = title
        attributes[SLING_RESOURCETYPE] = RESOURCE_TYPE
        children.add(dialogContent)
        layout.applyTo(dialogContent)
    }

    override fun addField(field: Node) {
        layout.getItemRoot(dialogContent).children += field
    }

    override fun toString(): String {
        return "Dialog(children=$children, attributes=$attributes)"
    }

    companion object {
        const val RESOURCE_TYPE = "cq/gui/components/authoring/dialog"
    }
}
