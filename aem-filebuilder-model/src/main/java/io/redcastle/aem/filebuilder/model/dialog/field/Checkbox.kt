package io.redcastle.aem.filebuilder.model.dialog.field

import io.redcastle.aem.filebuilder.model.propertyDelegate

class Checkbox(nodeName: String, fieldName: String) : DialogField(nodeName, fieldName, RESOURCE_TYPE) {

    var deleteHint: Boolean? by propertyDelegate()
    var value: String? by propertyDelegate()
    var uncheckedValue: String? by propertyDelegate()
    var disabled: Boolean? by propertyDelegate()
    var required: Boolean? by propertyDelegate()
    var validation: List<String> by propertyDelegate()
    var checked: Boolean? by propertyDelegate()
    var ignoreData: Boolean? by propertyDelegate()
    var text: String? by propertyDelegate()
    var autosubmit: Boolean? by propertyDelegate()
    var fieldDescription: String? by propertyDelegate()
    var toolTipPosition: TooltipPosition? by propertyDelegate()
    var renderReadOnly: Boolean? by propertyDelegate()

    var showEmptyInReadOnly: Boolean? by propertyDelegate()
    var wrapperClass: String? by propertyDelegate()

    enum class TooltipPosition(private val stringValue: String) {
        RIGHT("right"),
        LEFT("left"),
        TOP("top"),
        BOTTOM("bottom");

        override fun toString(): String {
            return stringValue
        }
    }

    companion object {
        const val RESOURCE_TYPE = "granite/ui/components/coral/foundation/form/checkbox"
    }
}
