package io.redcastle.aem.filebuilder.model.dialog.field

import io.redcastle.aem.filebuilder.model.propertyDelegate
import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.impl.NodeImpl

/**
 * @constructor test
 * @param formName The name of the field, which is submitted to the server.
 */
class Select(
        val nodeName: String,
        val formName: String
) : DialogField(nodeName, formName, RESOURCE_TYPE) {

    var emptyText: String? by propertyDelegate()
    var disabled: Boolean? by propertyDelegate()
    var required: Boolean? by propertyDelegate()
    var validation: List<String> by propertyDelegate()
    var multiple: Boolean? by propertyDelegate()
    var translateOptions: Boolean? by propertyDelegate()
    var ordered: Boolean? by propertyDelegate()
    var emptyOption: Boolean? by propertyDelegate()
    var variant: String? by propertyDelegate()
    var deleteHint: Boolean? by propertyDelegate()
    var options: List<SelectItem> = TODO("Make sure that these get added to the node structure")



    class SelectItem(nodeName: String): Node by NodeImpl(nodeName) {
        var value: String? by propertyDelegate()
        var disabled: String? by propertyDelegate()
        var selected: String? by propertyDelegate()
        var text: String? by propertyDelegate()
        var icon: String? by propertyDelegate()
        var statusIcon: String? by propertyDelegate()
        var statusText: String? by propertyDelegate()
        var statusVariant: String? by propertyDelegate()
    }

    companion object {
        const val RESOURCE_TYPE = "granite/ui/components/foundation/form/select"
    }
}
