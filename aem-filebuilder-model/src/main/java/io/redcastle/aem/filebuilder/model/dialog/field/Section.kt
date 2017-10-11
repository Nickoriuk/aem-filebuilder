package io.redcastle.aem.filebuilder.model.dialog.field

import io.redcastle.aem.filebuilder.model.propertyDelegate
import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.dialog.FormFieldContainer
import io.redcastle.aem.filebuilder.model.dialog.SLING_RESOURCETYPE
import io.redcastle.aem.filebuilder.model.dialog.StandardLayouts
import io.redcastle.aem.filebuilder.model.impl.NodeImpl

class Section(name: String) : Node by NodeImpl(name), FormFieldContainer {

    init {
        StandardLayouts.FIXED_COLUMNS.applyTo(this)
        attributes[SLING_RESOURCETYPE] = RESOURCE_TYPE
    }

    var title: String by propertyDelegate("jcr:title")

    override fun addField(field: Node) {
        StandardLayouts.FIXED_COLUMNS.getItemRoot(this).children.add(field)
    }

    companion object {
        const val RESOURCE_TYPE = "granite/ui/components/foundation/section"
    }
}
