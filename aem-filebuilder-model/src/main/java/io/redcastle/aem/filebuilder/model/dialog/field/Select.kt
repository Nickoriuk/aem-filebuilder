package io.redcastle.aem.filebuilder.model.dialog.field

import io.redcastle.aem.filebuilder.model.propertyDelegate
import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.impl.NodeImpl

/**
 * @param nodeName The name of the node as stored in the JCR.
 * @param formName The name of the field, which is submitted to the server.
 */
class Select(
        val nodeName: String,
        val formName: String
) : DialogField(nodeName, formName, RESOURCE_TYPE) {

    private val optionsRoot: Node = NodeImpl("items")

    init {
        children.add(optionsRoot)
    }

    var fieldLabel: String by propertyDelegate()
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
    val options: MutableList<SelectItem> get() = optionsRoot.children as MutableList<SelectItem>

    class SelectItem(nodeName: String): Node by NodeImpl(nodeName) {
        var value: String? by propertyDelegate()
        var disabled: String? by propertyDelegate()
        var selected: String? by propertyDelegate()
        var text: String? by propertyDelegate()
        var icon: String? by propertyDelegate()
        var statusIcon: String? by propertyDelegate()
        var statusText: String? by propertyDelegate()
        var statusVariant: StatusVariant by propertyDelegate()

        enum class StatusVariant(val value: String) {

            ERROR("error"),
            WARNING("warning"),
            SUCCESS("success"),
            HELP("help"),
            INFO("info");

            override fun toString() = value
        }
    }

    companion object {
        const val RESOURCE_TYPE = "granite/ui/components/coral/foundation/form/select"
    }
}
