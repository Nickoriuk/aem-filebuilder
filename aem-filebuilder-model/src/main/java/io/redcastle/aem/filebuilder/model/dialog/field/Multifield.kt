package io.redcastle.aem.filebuilder.model.dialog.field

import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.attachNewChild
import io.redcastle.aem.filebuilder.model.dialog.FormFieldContainer
import io.redcastle.aem.filebuilder.model.dialog.SLING_RESOURCETYPE
import io.redcastle.aem.filebuilder.model.impl.NodeImpl
import io.redcastle.aem.filebuilder.model.propertyDelegate

/**
 * Represents a multifield.
 *
 * See [https://docs.adobe.com/docs/en/aem/6-3/develop/ref/granite-ui/api/jcr_root/libs/granite/ui/components/coral/foundation/form/multifield/index.html]
 */
class Multifield(nodeName: String, formName: String) : Node by NodeImpl(nodeName), FormFieldContainer {


    private val multifieldRoot = this.attachNewChild("field", FIELD_RESOURCE_TYPE)
    private val multifieldItemRoot = multifieldRoot.attachNewChild("items")

    var fieldLabel: String? by propertyDelegate()
    var fieldDescription: String? by propertyDelegate()
    /**
     * If true, the from content value is handled as composite, instead of being stored as a multivalue property. This
     * means that you can end up with a deep / nested node structure as a result when using multiple fields inside a
     * multifield. More more information on this, see the Adobe documentation linked in the class documentation for
     * this type.
     */
    var compose: Boolean by propertyDelegate()
    var deleteHint: Boolean by propertyDelegate()
    var typeHint: String by propertyDelegate()
    var required: Boolean by propertyDelegate()
    var validation: List<String> by propertyDelegate()

    init {
        attributes[SLING_RESOURCETYPE] = RESOURCE_TYPE
        multifieldRoot.attributes["name"] = formName
    }

    override fun addField(field: Node) {
        multifieldItemRoot.children += field
    }

    companion object {
        val RESOURCE_TYPE = "granite/ui/components/coral/foundation/form/multifield"
        private val FIELD_RESOURCE_TYPE = "granite/ui/components/coral/foundation/container"
    }
}
