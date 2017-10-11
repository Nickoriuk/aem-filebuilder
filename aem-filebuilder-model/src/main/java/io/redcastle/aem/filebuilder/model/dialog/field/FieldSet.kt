package io.redcastle.aem.filebuilder.model.dialog.field

import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.dialog.FormFieldContainer
import io.redcastle.aem.filebuilder.model.dialog.SLING_RESOURCETYPE
import io.redcastle.aem.filebuilder.model.impl.NodeImpl
import io.redcastle.aem.filebuilder.model.propertyDelegate

class FieldSet(nodeName: String) : Node by NodeImpl(nodeName), FormFieldContainer {


    private val itemRoot = NodeImpl("items")

    init {
        children.add(itemRoot)
        attributes[SLING_RESOURCETYPE] = RESOURCE_TYPE
    }

    var title: String? by propertyDelegate("jcr:title")

    override fun addField(field: Node) {
        itemRoot.children.add(field)
    }

    companion object {
        const val RESOURCE_TYPE =  "granite/ui/components/coral/foundation/form/fieldset"
    }
}
